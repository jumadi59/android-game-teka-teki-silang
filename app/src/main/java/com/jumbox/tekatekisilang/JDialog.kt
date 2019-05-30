package com.jumbox.tekatekisilang


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.jumbox.tts.dialogs.DialogListener

/**
 *Created by Jumadi Janjaya
 *25, October, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */

class JDialog : DialogFragment() {

    companion object {
        var DIALOG = "dialog"
        var BANTUAN = "bantuan"
        var BANTUAN_CEK = 0x222
        var DIALOG_TONTON = 0x123
        var DIALOG_GAGAL_LOAD = 0x000
        var DIALOG_GUNA_BANTUAN = 0x333
        var DIALOG_GUNA_INTERSTITIAL = 0x344
        var DIALOG_CEK_HABIS = 0x321
        var DIALOG_GAME_OVER = 0x999
    }

    var btnOk: Button? = null
    var btnBatal: Button? = null
    var txtTile: TextView? = null
    var txtDescrip: TextView? = null
    var img: ImageView? = null
    private var listener: DialogListener? =null

    fun setListener(dialogListener: DialogListener) {
        listener = dialogListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_dialog, container, false)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setStyle(android.support.v4.app.DialogFragment.STYLE_NO_FRAME, android.R.style.Theme)
        btnOk = v.findViewById(R.id.btn_ok)
        btnBatal = v.findViewById(R.id.btn_batal)
        txtTile = v.findViewById(R.id.tv_title)
        txtDescrip = v.findViewById(R.id.tv_descripsi)
        img = v.findViewById(R.id.img)

        btnOk!!.typeface = Utils.utils.font(Utils.DIMBO)
        btnBatal!!.typeface = Utils.utils.font(Utils.DIMBO)
        txtTile!!.typeface = Utils.utils.font(Utils.DIMBO)
        txtDescrip!!.typeface = Utils.utils.font(Utils.COMIC_NEUE_BOLD)

        img!!.visibility = View.GONE

        val dialogArgument = arguments!!.getInt(DIALOG)
        when(dialogArgument){
            DIALOG_TONTON -> dialogTonton()
            DIALOG_GAGAL_LOAD -> dialogGagalLoad()
            DIALOG_GUNA_BANTUAN -> dialogGunaBantuan()
            DIALOG_CEK_HABIS -> dialogCekHabis()
            DIALOG_GAME_OVER -> dialogGameOver()
        }

        return v
    }

    private fun dialogGunaBantuan() {
        val id: Int;
        txtTile!!.text = getString(R.string.title_guna_bantuan)
        if (BuildConfig.isAdsAdmob && AdsGame.adsGame!!.isVideoRewardLoad()) {
            id = DIALOG_GUNA_BANTUAN
            txtDescrip!!.text = getString(R.string.guna_bantuan)
        } else if(!BuildConfig.isAdsAdmob && AdGame.adGame!!.isVideoRewardLoad()) {
            id = DIALOG_GUNA_BANTUAN
            txtDescrip!!.text = getString(R.string.guna_bantuan)
        }
        else {
            id = DIALOG_GUNA_INTERSTITIAL
            txtDescrip!!.text = getString(R.string.show_interstitial)
        }

        btnOk!!.setOnClickListener {
            MediaManager.sound!!.playClick()
            listener!!.diClick(id)
            dialog.dismiss()
        }

        btnBatal!!.setOnClickListener {
            MediaManager.sound!!.playClick()
            dialog.dismiss()
        }

    }

    private fun dialogCekHabis() {
        txtTile!!.text = getString(R.string.title_batas_cek_habis)
        txtDescrip!!.text = getString(R.string.batas_cek_habis)

        btnOk!!.setOnClickListener {
            MediaManager.sound!!.playClick()
            dialog.dismiss()
        }

        btnBatal!!.visibility = View.GONE

    }

    private fun dialogTonton() {
        txtTile!!.text = context!!.resources.getString(R.string.title_show_video)
        if (arguments!!.getInt(BANTUAN) != BANTUAN_CEK) {
            txtDescrip!!.text = getString(R.string.show_video, "Bantuan")
        } else {
            txtDescrip!!.text = getString(R.string.show_video, "Bantuan Cek 15X")
        }

        btnOk!!.setOnClickListener {
            MediaManager.sound!!.playClick()
            dialog.dismiss()
            listener!!.diClick(DIALOG_TONTON)
        }

        btnBatal!!.setOnClickListener {
            MediaManager.sound!!.playClick()
            dialog.dismiss()
        }

    }

    private fun dialogGagalLoad() {
        txtTile!!.text = getString(R.string.title_failed_load)
        txtDescrip!!.text = getString(R.string.video_failed_load)
        btnBatal!!.visibility = Button.GONE

        btnOk!!.setOnClickListener {
            MediaManager.sound!!.playClick()
            dialog.dismiss()
            listener!!.diClick(DIALOG_GAGAL_LOAD)
        }
    }

    private fun dialogGameOver() {
        txtTile!!.text = getString(R.string.title_soal_habis)
        txtDescrip!!.text = getText(R.string.soal_habis)

        img!!.visibility = View.VISIBLE
        btnBatal!!.visibility = View.GONE
        btnOk!!.setOnClickListener {
            MediaManager.sound!!.playClick()
            val fragment = MainMenuFragment()
            val transaction  : FragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
            transaction.replace(R.id.fragment_container, fragment, MainMenuFragment.TAG).addToBackStack(MainGameFragmet.TAG).commit()
            dialog.dismiss()
        }
    }

}
