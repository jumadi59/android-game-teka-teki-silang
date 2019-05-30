package com.jumbox.tekatekisilang

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.FragmentManager
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.AdListener
import com.jumbox.tekatekisilang.soal.Soal
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.annotation.SuppressLint



class MainActivity : AppCompatActivity() {

    companion object {
        var TAG = "MainActivity"
    }

    private lateinit var anim: Animation

    @SuppressLint("HandlerLeak")
    private val handler = Handler()
    private var next = false
    private var pos = -1
    private var nextPos = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        DataGame.instance(this).create()
        ManagerLevel.instance()

        if(BuildConfig.isAdsAdmob) AdsGame.instance().create(this)
        else AdGame.instance().create(this)

        Utils.create(this)
        MediaManager.instance(this)

        if (DataGame.get().data.screenHeight == null) {
            fragment_container.post {
                DataGame.get().setScreenWidth(fragment_container.width)
                        .setScreenHeight(fragment_container.height)
                        .save()
            }
        }
        val fragment = MainMenuFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment, MainMenuFragment.TAG).commitAllowingStateLoss()

        if(BuildConfig.isAdsAdmob) {
            AdsGame.adsGame!!.createBanner(iklan, object : com.google.android.gms.ads.AdListener() {
                override fun onAdLoaded() {
                    tv_pepatah.visibility = TextView.GONE
                    img_logo.visibility = ImageView.GONE
                    pos = -1
                }

                override fun onAdFailedToLoad(p0: Int) {
                    super.onAdFailedToLoad(p0)
                    AdsGame.adsGame!!.bannerLoad()
                    iklan.setBackgroundResource(R.drawable.banner)
                    tv_pepatah.visibility = TextView.VISIBLE
                    img_logo.visibility = ImageView.VISIBLE
                    if (pos == -1) iklan()
                }
            })
            AdsGame.adsGame!!.reqInterstitial()
            AdsGame.adsGame!!.reqVideoReward()
        } else {
            AdGame.adGame!!.createBanner(iklan, object : AdListener {
                override fun onAdClicked(p0: Ad?) {

                }

                override fun onLoggingImpression(p0: Ad?) {

                }

                override fun onAdLoaded(ad: Ad) {
                    tv_pepatah.visibility = TextView.GONE
                    img_logo.visibility = ImageView.GONE
                    pos = -1
                }
                override fun onError(ad: Ad, adError: AdError) {
                    AdGame.adGame!!.bannerLoad()
                    iklan.setBackgroundResource(R.drawable.banner)
                    tv_pepatah.visibility = TextView.VISIBLE
                    img_logo.visibility = ImageView.VISIBLE
                    if (pos == -1) iklan()
                }
            })
            AdGame.adGame!!.loadInterstitial()
            AdGame.adGame!!.reqVideoReward()
        }
    }

    fun cekFragmentTag(b: Boolean) {
        fragment_container.post {
            iklan.visibility = if (b) View.VISIBLE else View.GONE
        }
    }

    private fun iklan() {
        anim = AnimationUtils.loadAnimation(this, R.anim.circle_anim)
        img_logo.animation = anim
        tv_pepatah.typeface = Utils.utils.font(Utils.COMIC_NEUE_BOLD)
        tv_pepatah.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17f)
        pos = Random().nextInt(Soal.pepatah.size - 1)
        tv_pepatah.text = Soal.pepatah[pos]
        nextPos = pos

        handler.postDelayed(object : Runnable {
            override fun run() {
                iklanOffline()
                handler.postDelayed(this, 10000)
            }

        }, 15000)
    }

    private fun iklanOffline() {
        pos = if (next) {
            Random().nextInt(Soal.pepatah.size - 1)
        } else {
            nextPos
        }
        tv_pepatah.startAnimation(anim)
        if (next) {
            next = false
            tv_pepatah.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17f)
            tv_pepatah.text = Soal.pepatah[pos]
            nextPos = pos
        } else {
            next = true
            tv_pepatah.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
            tv_pepatah.text = getString(R.string.artinya, Soal.artinya[pos])
        }

    }

    override fun onDestroy() {
        if (BuildConfig.isAdsAdmob) AdsGame.adsGame!!.onDestroy()
        else AdGame.adGame!!.onDestroy()
        super.onDestroy()
    }

    override fun onBackPressed() {
        when {
            supportFragmentManager.findFragmentByTag(MainGameFragmet.TAG) !=null && BuildConfig.DEBUG -> supportFragmentManager.popBackStack(ListLevelDebugFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            supportFragmentManager.findFragmentByTag(MainGameFragmet.TAG) !=null -> supportFragmentManager.popBackStack(MainMenuFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            else -> super.onBackPressed()
        }
    }
}
