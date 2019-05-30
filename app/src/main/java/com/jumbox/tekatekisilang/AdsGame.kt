package com.jumbox.tekatekisilang

import android.content.Context
import android.view.View
import android.widget.RelativeLayout
import com.google.android.gms.ads.*
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener


/**
 *Created by Jumadi Janjaya
 *31, October, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */

class AdsGame : RewardedVideoAdListener {
    override fun onRewardedVideoAdClosed() {

    }

    override fun onRewardedVideoAdLeftApplication() {

    }

    override fun onRewardedVideoAdLoaded() {
        isLoadReward = true
    }

    override fun onRewardedVideoAdOpened() {

    }

    override fun onRewardedVideoCompleted() {
        if (adsListener !=null) {
            adsListener!!.onRewardedVideoCompleted()
            isLoadReward = false
        }
    }

    override fun onRewarded(p0: RewardItem?) {

    }

    override fun onRewardedVideoStarted() {

    }

    override fun onRewardedVideoAdFailedToLoad(p0: Int) {
        isLoadReward = false
    }

    val AD_UNIT_ID_BANNER_DEBUG = "ca-app-pub-3940256099942544/6300978111"
    val AD_UNIT_ID_INTERSITIAL_DEBUG = "ca-app-pub-3940256099942544/1033173712"
    val AD_UNIT_ID_VIDEO_REWARD_DEBUG = "ca-app-pub-3940256099942544/5224354917"

    companion object {
        var TAG = "AdsGame"
        val JUMLAH_TONTON_VIDEO_REWARD = 1

        var adsGame: AdsGame? = null
        fun instance(): AdsGame {
            adsGame = AdsGame()
            return adsGame!!
        }
    }

    private var adReq: AdRequest.Builder? = null
    private var interstitial: InterstitialAd? = null
    private var adView: AdView? = null
    var rewardedVideoAd: RewardedVideoAd? = null
    private var adsListener: AdsGameListener? = null
    private var isLoadReward: Boolean = false
    private lateinit var idAdsVideoReward: String
    private var isTypeShow: Int = 0

    fun setListener(adsVideoRewwardListener: AdsGameListener) {
        adsListener = adsVideoRewwardListener
    }

    fun create(context: Context) {
        MobileAds.initialize(context, context.getString(R.string.ad_unit_id_app))
        adReq = AdRequest.Builder()
        adView = AdView(context)
        adView!!.adSize = AdSize.SMART_BANNER
        adView!!.adUnitId = if (BuildConfig.DEBUG) AD_UNIT_ID_BANNER_DEBUG else context.getString(R.string.banner_ad_unit_id)
        adReq!!.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
        adView!!.loadAd(adReq!!.build())

        interstitial = InterstitialAd(context)
        interstitial!!.adUnitId = if (BuildConfig.DEBUG) AD_UNIT_ID_INTERSITIAL_DEBUG else context.getString(R.string.interstitial_ad_unit_id)
        interstitial!!.loadAd(adReq!!.build())
        interstitial!!.adListener = object : AdListener() {
            override fun onAdLoaded() {}
            override fun onAdClosed() {}
        }

        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(context)
        rewardedVideoAd!!.rewardedVideoAdListener = this
        idAdsVideoReward = if (BuildConfig.DEBUG) AD_UNIT_ID_VIDEO_REWARD_DEBUG else context.getString(R.string.video_reward_ad_unit_id)
    }

    fun createBanner(view: RelativeLayout) {
        view.addView(adView)
        adView!!.adListener = object : AdListener() {

            override fun onAdFailedToLoad(errorCode: Int) {
                super.onAdFailedToLoad(View.GONE)
            }
        }
    }

    fun createBanner(view: RelativeLayout, adListener: AdListener) {
        view.addView(adView)
        adView!!.adListener = adListener
    }

    fun bannerLoad() {
        adView!!.loadAd(adReq!!.build())
    }

    fun showInterstitial() {
        interstitial!!.show()
    }

    fun showInterstitial(type: Int) {
        if (interstitial!!.isLoaded) {
            isTypeShow = type
            interstitial!!.show()
        }
    }

    fun reqInterstitial() {
        interstitial!!.loadAd(adReq!!.build())
    }

    fun showVideoReward() {
        rewardedVideoAd!!.show()
    }

    fun reqVideoReward() {
        rewardedVideoAd!!.loadAd(idAdsVideoReward, adReq!!.build())
    }

    fun isVideoRewardLoad(): Boolean {
        return isLoadReward
    }

    fun onDestroy() {
        adView!!.destroy()
        rewardedVideoAd!!.destroy()
    }

}
