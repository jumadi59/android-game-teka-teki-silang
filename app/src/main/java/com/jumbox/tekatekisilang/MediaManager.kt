package com.jumbox.tekatekisilang

import android.content.Context
import android.media.SoundPool
import android.media.AudioManager


/**
 *Created by Jumadi Janjaya
 *28, October, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */
class MediaManager(context: Context) : SoundPool.OnLoadCompleteListener {

    companion object {
        var TAG = "MediaManager"
        var sound: MediaManager? = null

        fun instance(c: Context): MediaManager {
            sound = MediaManager(c)
            return sound as MediaManager
        }
    }

    private var soundPool: SoundPool? = null
    private var audioManager: AudioManager? = null
    private var clickId: Int = 0
    private var winnerId: Int = 0
    private var volume: Float = 0.toFloat()
    private var loaded: Boolean = false

    init {
        audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager?
        assert(audioManager != null)
        val actVolume = audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC).toFloat()
        val maxVolume = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC).toFloat()
        volume = actVolume / maxVolume

        soundPool = SoundPool(10, AudioManager.STREAM_MUSIC, 1)
        soundPool!!.setOnLoadCompleteListener(this)

        clickId = soundPool!!.load(context, Utils.BTN_CLICK, 1)
        winnerId = soundPool!!.load(context, Utils.WINNER, 1)
    }

    fun playClick() {
        if (DataGame.get().data.sound!! && loaded) {
            soundPool!!.play(clickId, volume, volume, 1, 0, 1f)
        }
    }

    fun playBerhasil() {
        if (DataGame.get().data.sound!! && loaded) {
            soundPool!!.play(winnerId, volume, volume, 1, 0, 1f)
        }
    }

    override fun onLoadComplete(soundPool: SoundPool, i: Int, i1: Int) {
        loaded = true
    }
}

