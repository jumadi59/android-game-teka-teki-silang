package com.jumbox.tekatekisilang

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 *Created by Jumadi Janjaya
 *13, December, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */
@Suppress("DEPRECATION")
class MainMenuFragment : Fragment() {

    companion object {
        var TAG = "MainMenuFragment"
    }

    private lateinit var btnMulai: Button
    private lateinit var bntRate: Button
    private lateinit var btnMoreApps: Button

    private lateinit var tvCopyRigth: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_main_menu, container, false)
        (activity as MainActivity).cekFragmentTag(false)

        btnMulai = v.findViewById(R.id.btn_mulai)
        bntRate = v.findViewById(R.id.btn_rate)
        btnMoreApps = v.findViewById(R.id.btn_more)
        tvCopyRigth = v.findViewById(R.id.copyright)

        btnMulai.typeface = Utils.utils.font(Utils.DIMBO)
        bntRate.typeface = Utils.utils.font(Utils.DIMBO)
        btnMoreApps.typeface = Utils.utils.font(Utils.DIMBO)
        tvCopyRigth.typeface = Utils.utils.font(Utils.COMIC_NEUE_BOLD)

        tvCopyRigth.text = Html.fromHtml("&copy; 2018 Jumbox Studios")

        btnMulai.setOnClickListener {
            MediaManager.sound!!.playClick()
            if (BuildConfig.DEBUG) {
                val fragment = ListLevelDebugFragment()
                val transaction  = activity!!.supportFragmentManager.beginTransaction()
                transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                transaction.replace(R.id.fragment_container, fragment, ListLevelDebugFragment.TAG).addToBackStack(TAG).commit()
            } else {
                val fragment = MainGameFragmet()
                val transaction  = activity!!.supportFragmentManager.beginTransaction()
                transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                transaction.replace(R.id.fragment_container, fragment, MainGameFragmet.TAG).addToBackStack(TAG).commit()
            }
        }

        bntRate.setOnClickListener {
            MediaManager.sound!!.playClick()
            val dialogRate =  DialogRate()
            val transaction = activity!!.supportFragmentManager.beginTransaction()
            transaction.add(dialogRate, null).show(dialogRate).commit()
            dialogRate.isCancelable = false
        }

        btnMoreApps.setOnClickListener {
            MediaManager.sound!!.playClick()
            val uri = Uri.parse("https://play.google.com/store/apps/developer?id=Jumbox+Studios")
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri
            startActivity(intent)
        }

        return v
    }

}