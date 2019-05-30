package com.jumbox.tekatekisilang

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.os.CountDownTimer
import android.support.v4.app.FragmentTransaction
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.content.Intent
import com.jumbox.tts.dialogs.DialogListener

/**
 *Created by Jumadi Janjaya
 *25, October, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */

class DialogWinner : DialogFragment() {

    companion object {
        const val POINT: String = "point"
    }

    private lateinit var relativeLayout: RelativeLayout
    private lateinit var btnShare: Button
    private lateinit var btnNext: Button
    private lateinit var tvTitle: TextView
    private lateinit var tvPoint: TextView
    private lateinit var tvScore: TextView

    var animShow: Animation? = null
    private var animExit: Animation? = null

    var click: Int = -1

    private var listener: DialogListener? =null

    fun setListener(dialogListener: DialogListener) {
        listener = dialogListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_dialog_winner, container, false)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setStyle(android.support.v4.app.DialogFragment.STYLE_NO_FRAME, android.R.style.Theme)

        relativeLayout = v.findViewById(R.id.menu_winner)
        btnNext = v.findViewById(R.id.btn_ok)
        btnShare = v.findViewById(R.id.btn_batal)
        tvTitle = v.findViewById(R.id.tv_title)
        tvPoint = v.findViewById(R.id.tv_point)
        tvScore = v.findViewById(R.id.tv_score)

        animShow = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        animExit = AnimationUtils.loadAnimation(context, R.anim.fade_out)

        btnShare.typeface = Utils.utils.font(Utils.DIMBO)
        btnNext.typeface = Utils.utils.font(Utils.DIMBO)
        tvTitle.typeface = Utils.utils.font(Utils.DIMBO)
        tvScore.typeface = Utils.utils.font(Utils.COMIC_NEUE_BOLD)
        tvPoint.typeface = Utils.utils.font(Utils.COMIC_NEUE_BOLD)

        tvPoint.text = "+${arguments!!.getString(POINT)}"
        tvScore.text = getString(R.string.score, DataGame.get().data.jumlahPoint!!.toString())

        relativeLayout.visibility = View.GONE

        countDownTimer.start()
        MediaManager.sound!!.playBerhasil()

        btnShare.setOnClickListener {
            MediaManager.sound!!.playClick()
            val kirim = getString(R.string.txt_share_app, activity!!.packageName)
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, kirim)
            startActivity(Intent.createChooser(intent, getString(R.string.title_share)))
        }
        btnNext.setOnClickListener {
            MediaManager.sound!!.playClick()
            val fragment = MainGameFragmet()
            val bundle = Bundle()
            bundle.putInt(Utils.LEVEL, DataGame.get().data.level!!)
            fragment.arguments = bundle
            val transaction  : FragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
            transaction.replace(R.id.fragment_container, fragment, MainGameFragmet.TAG).addToBackStack(MainMenuFragment.TAG).commit()
            dismiss()
        }
        return v
    }

    private val countDownTimer = object : CountDownTimer(4000, 10) {
        override fun onTick(l: Long) {

        }

        override fun onFinish() {
            relativeLayout.visibility = View.VISIBLE
            relativeLayout.startAnimation(animShow)
            if (BuildConfig.isAdsAdmob) AdsGame.adsGame!!.showInterstitial()
            else AdGame.adGame!!.showInterstitial()
        }
    }

}
