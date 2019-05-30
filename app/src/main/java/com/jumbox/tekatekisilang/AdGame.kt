package com.jumbox.tekatekisilang

import android.annotation.SuppressLint
import android.content.Context
import android.widget.RelativeLayout
import com.facebook.ads.*

/**
 *
 * ADS Audience Network
 *
 */

class AdGame {


    lateinit var adView: AdView
    lateinit var interstitialAd: InterstitialAd
    lateinit var rewardedVideoAd: RewardedVideoAd
    private var isLoadReward = false
    private var isTypeShow = 0
    private var adGameListener: AdsGameListener? = null

    fun setListener(adGameListener: AdsGameListener) {
        this.adGameListener = adGameListener
    }

    fun create(context: Context) {

        AudienceNetworkAds.initialize(context)
        if (BuildConfig.DEBUG) AdSettings.addTestDevice("88888888-aaaa-bbbb-cccc-111111111111")
        adView = AdView(context, ADVIEW_ID, AdSize.BANNER_HEIGHT_50)

        interstitialAd = InterstitialAd(context, INTERSTITIALAD_ID)
        interstitialAd.setAdListener(object : InterstitialAdListener {
            override fun onInterstitialDisplayed(p0: Ad?) {
            }

            override fun onAdClicked(p0: Ad?) {
                adGameListener!!.onInterstitialShow()
            }

            override fun onInterstitialDismissed(p0: Ad?) {
                adGameListener!!.onInterstitialShow()
                loadInterstitial()
            }

            override fun onError(p0: Ad?, p1: AdError?) {
                loadInterstitial()
            }

            override fun onAdLoaded(p0: Ad?) {
            }

            override fun onLoggingImpression(p0: Ad?) {
            }

        })

        rewardedVideoAd = RewardedVideoAd(context, NATIVEAD_ID)
        rewardedVideoAd.setAdListener(object : RewardedVideoAdListener {
            override fun onRewardedVideoClosed() {
                reqVideoReward()
            }

            override fun onAdClicked(p0: Ad?) {
            }

            override fun onRewardedVideoCompleted() {
                reqVideoReward()
                if (adGameListener !=null) {
                    adGameListener!!.onRewardedVideoCompleted()
                    isLoadReward = false
                }
            }

            override fun onError(p0: Ad?, p1: AdError?) {
                reqVideoReward()
            }

            override fun onAdLoaded(p0: Ad?) {
            }

            override fun onLoggingImpression(p0: Ad?) {
            }

        })
    }

    fun createBanner(view: RelativeLayout) {
        view.addView(adView)
        adView.loadAd()
    }

    fun createBanner(view: RelativeLayout, adListener: AdListener) {
        view.addView(adView)
        adView.setAdListener(adListener)
        adView.loadAd()
    }

    fun bannerLoad() {
        adView.loadAd()
    }

    fun loadInterstitial() {
        interstitialAd.loadAd()
    }

    fun showInterstitial() {
        if (interstitialAd.isAdLoaded) {
            interstitialAd.show()
        }
    }


    fun showInterstitial(type: Int) {
        if (interstitialAd.isAdLoaded) {
            isTypeShow = type
            interstitialAd.show()
        }
    }

    fun showVideoReward() {
        if (rewardedVideoAd.isAdLoaded) {
            rewardedVideoAd.show()
        } else {
            reqVideoReward()
        }
    }

    fun reqVideoReward() {
        rewardedVideoAd.loadAd()
    }

    fun isVideoRewardLoad(): Boolean {
        return isLoadReward
    }

    fun onDestroy() {
        adView.destroy()
        interstitialAd.destroy()
        rewardedVideoAd.destroy()
    }

    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
        private const val ADVIEW_ID = "647955325634743_647993035630972"
        private const val INTERSTITIALAD_ID = "647955325634743_648122398951369"
        private const val NATIVEAD_ID = "647955325634743_648125305617745"

        @SuppressLint("StaticFieldLeak")
        var adGame: AdGame? = null

        fun instance(): AdGame {
            adGame = AdGame()
            return adGame!!
        }
    }
}