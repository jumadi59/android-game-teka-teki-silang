package com.jumbox.tekatekisilang

import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import com.jumbox.tts.dialogs.DialogListener
import kotlinx.android.synthetic.main.layout_keypad.view.*
import java.util.*

/**
 *Created by Jumadi Janjaya
 *13, December, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */
class MainGameFragmet : Fragment(), TtsAdapter.TtsListener, AdsGameListener, DialogListener {
    override fun onInterstitialShow() {
        adapter.bantuan(true)
        DataGame.get().setBantuan(true)
        adapter.updateAllDataTts()
    }

    override fun diClick(id: Int) {
        when(id) {
            JDialog.DIALOG_TONTON -> {
                if (BuildConfig.isAdsAdmob && AdsGame.adsGame!!.isVideoRewardLoad()) {
                    AdsGame.adsGame!!.showVideoReward()
                } else if(!BuildConfig.isAdsAdmob && AdGame.adGame!!.isVideoRewardLoad()) {
                    AdGame.adGame!!.showVideoReward()
                } else {
                    val dialogGagalLoad =  JDialog()
                    val bundle = Bundle()
                    bundle.putInt(JDialog.DIALOG, JDialog.DIALOG_GAGAL_LOAD)
                    dialogGagalLoad.arguments = bundle
                    dialogGagalLoad.setListener(this)
                    val transaction = activity!!.supportFragmentManager.beginTransaction()
                    transaction.add(dialogGagalLoad, null).show(dialogGagalLoad).commit()
                    dialogGagalLoad.isCancelable = false
                }
            }
            JDialog.DIALOG_GAGAL_LOAD -> {}

            JDialog.DIALOG_GUNA_BANTUAN -> {
                val dialogTonton =  JDialog()
                val bundle = Bundle()
                bundle.putInt(JDialog.DIALOG, JDialog.DIALOG_TONTON)
                dialogTonton.arguments = bundle
                dialogTonton.setListener(this)
                val transaction = activity!!.supportFragmentManager.beginTransaction()
                transaction.add(dialogTonton, null).show(dialogTonton).commit()
                dialogTonton.isCancelable = false
            }
            JDialog.DIALOG_GUNA_INTERSTITIAL -> {
                if(BuildConfig.isAdsAdmob) AdsGame.adsGame!!.showInterstitial(1)
                else AdGame.adGame!!.showInterstitial(1)
            }
        }
    }

    override fun click(posisi: Int, txtpKode: String, noUbah: Boolean) {
        val tts = adapter.get(posisi)
        this.txtJawaban = txtpKode

        var txtkode = ""
        var petunjuk = ""
        if (tts.kode.contains(":")) {

            val ko = tts.kode.split(":")
            val pt = tts.clue.split(";")

            if (txtpKode == ko[0]) {
                txtkode = ko[0]
                petunjuk = pt[0]
            } else if (txtpKode == ko[1]) {
                txtkode = ko[1]
                petunjuk = pt[1]
            }

        } else {
            txtkode = tts.kode
            petunjuk = tts.clue
        }

        setTextBtn(txtkode, tts.id, noUbah)

        if (petunjuk != "") {
            val u = petunjuk[0].toString()
            val bal = u.toUpperCase()
            tvPetunjuk.text = petunjuk.replaceFirst(u, bal)
        }
    }

    override fun onRewardedVideoCompleted() {
        adapter.bantuan(true)
        DataGame.get().setBantuan(true)
        adapter.updateAllDataTts()
    }

    companion object {
        var TAG = "MainGameFragment"
    }

    private val btnKeypad: ArrayList<Button> = ArrayList()
    private lateinit var btnHapus: Button
    private lateinit var btnCek: Button
    private lateinit var btnBantuan: Button

    private lateinit var tvPoint: TextView
    private lateinit var tvLevel: TextView
    private lateinit var tvScore: TextView
    private lateinit var tvPetunjuk: TextView

    private lateinit var bar: RelativeLayout
    private lateinit var keypad: RelativeLayout
    private lateinit var relPetunjuk: RelativeLayout

    private val adapter: TtsAdapter = TtsAdapter()
    private lateinit var recyclerView: RecyclerView

    private lateinit var manager:ManagerLevel

    private var txtJawaban: String = ""
    private var jumKotakTts: Int = 0
    private var jumKotakBenarTts = 0
    var txtPetunjukOld: String = ""
    var jumCek: Int = 15
    var point: Int = 100

    @Suppress("DEPRECATION")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_main_game, container, false)
        (activity as MainActivity).cekFragmentTag(true)

        btnKeypad.add(v.btn_1)
        btnKeypad.add(v.btn_2)
        btnKeypad.add(v.btn_3)
        btnKeypad.add(v.btn_4)
        btnKeypad.add(v.btn_5)
        btnKeypad.add(v.btn_6)
        btnKeypad.add(v.btn_7)
        btnKeypad.add(v.btn_8)
        btnKeypad.add(v.btn_9)
        btnKeypad.add(v.btn_10)

        btnHapus = v.findViewById(R.id.btn_hapus)
        btnCek = v.findViewById(R.id.btn_cek)
        btnBantuan = v.findViewById(R.id.btn_bantuan)

        tvPoint = v.findViewById(R.id.tv_point)
        tvLevel = v.findViewById(R.id.tv_level)
        tvScore = v.findViewById(R.id.tv_jumlah_point)
        tvPetunjuk = v.findViewById(R.id.tv_petunjuk)

        recyclerView = v.findViewById(R.id.recyclerview)

        bar = v.findViewById(R.id.tool_bar)
        keypad = v.findViewById(R.id.lin_keypad)
        relPetunjuk = v.findViewById(R.id.rel_petunjuk)

        tvPoint.typeface = Utils.utils.font(Utils.DIMBO)
        tvLevel.typeface = Utils.utils.font(Utils.DIMBO)
        tvScore.typeface = Utils.utils.font(Utils.DIMBO)
        tvPetunjuk.typeface = Utils.utils.font(Utils.COMIC_NEUE_BOLD)
        btnCek.typeface = Utils.utils.font(Utils.DIMBO)
        btnHapus.typeface = Utils.utils.font(Utils.DIMBO)
        btnBantuan.typeface = Utils.utils.font(Utils.DIMBO)

        manager = ManagerLevel.managerLevel
        adapter.setListener(this)

        if (BuildConfig.isAdsAdmob) AdsGame.adsGame!!.setListener(this)
        else AdGame.adGame!!.setListener(this)

        recyclerView.adapter = adapter
        createTts()

        for (i in 0 until btnKeypad.size) {
            val btn = btnKeypad[i]
            btn.text = getText(R.string.tekan)[i].toString()
            btn.setTypeface(Utils.utils.font(Utils.DIMBO), Typeface.BOLD)
            btn.setOnClickListener { view ->
                MediaManager.sound!!.playClick()
                var id = -1
                if(view.tag != null) id = view.tag as Int
                updateKotak(id, btn.text as String)
            }
        }

        btnHapus.setOnClickListener { view ->
            MediaManager.sound!!.playClick()
            var id = -1
            if(view.tag != null) id = view.tag as Int
            updateKotak(id, "")
        }

        btnBantuan.setOnClickListener {
            MediaManager.sound!!.playClick()
            val dialogBantuan =  JDialog()
            val bundle = Bundle()
            bundle.putInt(JDialog.DIALOG, JDialog.DIALOG_GUNA_BANTUAN)
            dialogBantuan.arguments = bundle
            dialogBantuan.setListener(this)
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            transaction.add(dialogBantuan, null).show(dialogBantuan).commit()
            dialogBantuan.isCancelable = false
        }

        btnCek.setOnClickListener {
            MediaManager.sound!!.playClick()
            if(jumCek > 0 && !(DataGame.get().data.bantuan!!)) {
                timerDown.start()
                adapter.bantuan(true)
                adapter.updateAllDataTts()
                jumCek -= 1
                point -=2
                tvPoint.text = getString(R.string.point, point.toString())
                DataGame.get().setJumCek(jumCek)
            }else if(DataGame.get().data.bantuan!!)  {
                val txt = "<font color='red'><b>${getString(R.string.bantuan_sudah_digunakan)}</b></font>"
                txtPetunjukOld = tvPetunjuk.text.toString()
                tvPetunjuk.setText(Html.fromHtml(txt), TextView.BufferType.SPANNABLE)
                timerDown.start()
            } else if (jumCek == 0){
                val dialogCekHabis =  JDialog()
                val bundle = Bundle()
                bundle.putInt(JDialog.DIALOG, JDialog.DIALOG_CEK_HABIS)
                dialogCekHabis.arguments = bundle
                val transaction = activity!!.supportFragmentManager.beginTransaction()
                transaction.add(dialogCekHabis, null).show(dialogCekHabis).commit()
                dialogCekHabis.isCancelable = false
            }
        }

        return  v
    }

    private fun createTts() {
        val level: Int = if (BuildConfig.DEBUG) {
            arguments!!.getInt("level")
        } else {
            DataGame.get().data.level!!
        }

        if (level > manager.levelCount()) {
            val dialogGameOver =  JDialog()
            val bundle = Bundle()
            bundle.putInt(JDialog.DIALOG, JDialog.DIALOG_GAME_OVER)
            dialogGameOver.arguments = bundle
            dialogGameOver.setListener(this)
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            transaction.add(dialogGameOver, null).show(dialogGameOver).commit()
            dialogGameOver.isCancelable = false
            return
        }

        manager.setLevel(level)

        val sLevel =(manager.level()+1).toString()
        point = DataGame.get().getPoint()
        tvLevel.text = getString(R.string.level, sLevel)
        tvPoint.text = getString(R.string.point, "$point ")
        tvScore.text = getString(R.string.score, DataGame.get().data.jumlahPoint.toString())

        val tts = manager.Tts()
        val gridLayoutManager = GridLayoutManager(context, manager.kotak())
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.isVerticalScrollBarEnabled = false

        adapter.setK(manager.kotak())
        DataGame.get().loadDataLevel(manager.level())

        if (DataGame.get().data.heightRecy == null) {
            val gridParams = recyclerView.layoutParams
            gridParams.height = ((DataGame.get().data.screenHeight!! - bar.layoutParams.height) - relPetunjuk.layoutParams.height) - keypad.layoutParams.height
            recyclerView.layoutParams = gridParams
            DataGame.get().setHeightRecy(gridParams.height).save()
        }

        val heigRecy = (DataGame.get().data.heightRecy!! - (recyclerView.paddingTop + recyclerView.paddingBottom))
        val height = heigRecy / manager.kotak().toFloat()
        val sisa = heigRecy - (Math.round(height) * manager.kotak())

        val clueParams = relPetunjuk.layoutParams
        clueParams.height = clueParams.height + sisa
        relPetunjuk.layoutParams = clueParams

        var count = 0
        for (i in 0 until manager.kotak()) {
            for (j in 0 until manager.kotak()) {
                val mTts = TTS()
                mTts.id = count
                mTts.tts = tts.hTts(i, j)
                mTts.kode = tts.hKode(i, j)
                mTts.clue = tts.hClue(i, j)
                mTts.orie = tts.hOrie(i, j)
                mTts.update = DataGame.get().loadKotak(count)
                count++
                adapter.add(mTts)
            }
        }

        adapter.bantuan = DataGame.get().data.bantuan!!
        adapter.notifyDataSetChanged()

    }

    private val timerDown = object : CountDownTimer(1000, 100) {

        override fun onTick(millisUntilFinished: Long) {
        }

        override fun onFinish() {
            if (jumCek > -1 && !DataGame.get().data.bantuan!!) {
                adapter.bantuan(false)
            } else {
                tvPetunjuk.text = txtPetunjukOld
            }
            adapter.updateAllDataTts()
        }
    }

    private fun updateKotak(id: Int, txt: String) {
        var nextPos = 0
        var posisi = 0
        if (id < 0) {
            return
        }

        for (cr in adapter.ttsList) {
            if (cr.id == id) {
                val index = adapter.ttsList.indexOf(cr)
                posisi = index
                if (txt != "") {

                    if (cr.kode.contains(":")) {
                        val ko = cr.kode.split(":")
                        if (txtJawaban == ko[0]) {
                            nextPos = index + 1
                        } else if (txtJawaban == ko[1]) {
                            nextPos = index + manager.kotak()
                        }
                    } else {
                        nextPos = if (cr.orie) index + 1 else index + manager.kotak()
                    }
                } else {

                    if (cr.kode.contains(":")) {
                        val ko = cr.kode.split(":")
                        if (txtJawaban == ko[0]) {
                            nextPos = index - 1
                        } else if (txtJawaban == ko[1]) {
                            nextPos = index - manager.kotak()
                        }
                    } else {
                        nextPos = if (cr.orie) index - 1 else index - manager.kotak()
                    }
                }


                if (nextPos > adapter.itemCount - 1 || nextPos < 0) {
                    nextPos = posisi
                } else if (nextPos < adapter.itemCount - 1 || nextPos > 0) {
                    val tc = adapter.get(nextPos)
                    if (tc.kode == null || adapter.block(posisi, nextPos)) {
                        nextPos = posisi
                    }
                }
                cr.tts = cr.tts
                cr.id = cr.id
                cr.clue = cr.clue
                cr.kode = cr.kode
                cr.update = txt
                adapter.remove(index)
                adapter.add(index, cr)
                DataGame.get().saveKotak(index, txt)
                break
            }
        }
        adapter.nextPos(posisi, nextPos)

        if (cekGame()) {
            val dialogWinner =  DialogWinner()
            dialogWinner.setListener(this)
            val bundle = Bundle()
            bundle.putString(DialogWinner.POINT, point.toString())
            dialogWinner.arguments = bundle
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            transaction.add(dialogWinner, null).show(dialogWinner).commit()
            dialogWinner.isCancelable = false
        }
    }

    private fun cekGame(): Boolean {
        jumlahBenar()
        var mCek = false
        val jPoint =DataGame.get().data.jumlahPoint!!.plus(point)
        if (jumKotakBenarTts == jumKotakTts) {
            DataGame.get().setLevel(manager.level()+1)
                    .addDataKotak()
                    .clearKotak()
                    .setPoint(point)
                    .setJumCek(15)
                    .setJumPoints(jPoint)
                    .setBantuan(false)
                    .save()
            mCek = true

        }
        return mCek
    }

    private fun jumlahBenar() {
        var jumlahBenar = 0
        var jumlahTts = 0
        for (i in 0 until adapter.ttsList.size) {
            val tc = adapter.get(i)
            if (tc.tts.toString().toUpperCase() == DataGame.get().loadKotak(i).toUpperCase()) {
                if (DataGame.get().loadKotak(i) != "") {
                    jumlahBenar++
                }
            }

            if (tc.tts != " ") {
                jumlahTts++
            }
        }
        this.jumKotakTts = jumlahTts
        this.jumKotakBenarTts = jumlahBenar
    }

    private fun setTextBtn(str: String, id: Int, noUbah: Boolean) {
        val random = Random()
        val huruf = "abcdefghijklmnopqrstuvwxyz"
        val b = 10
        val arr = arrayOfNulls<String>(b)
        for (i in 0 until str.length) {
            arr[i] = str.substring(i, i + 1)
        }
        for (i in str.length until b) {
            arr[i] = "" + huruf[random.nextInt(huruf.length)]
        }

        for (i in 0 until b) {
            val str2 = arr[i]
            val nextInt = random.nextInt(b)
            arr[i] = arr[nextInt]
            arr[nextInt] = str2
        }

        btnHapus.tag = id
        for (i in 0 until btnKeypad.size) {
            val btn = btnKeypad[i]
            if (!noUbah) {
                btn.text = arr[i]
            }
            btn.tag = id
        }

    }
}