package com.jumbox.tekatekisilang

import android.util.Log
import com.jumbox.tekatekisilang.model.TtsLevel
import com.jumbox.tekatekisilang.model.TtsResponseMsg
import com.jumbox.tekatekisilang.model.TtsSoal
import com.jumbox.tekatekisilang.soal.Soal
import com.jumbox.tekatekisilang.soal.Soal1
import com.jumbox.tekatekisilang.soal.Soal2
import com.jumbox.tekatekisilang.soal.Soal3

/**
 *Created by Jumadi Janjaya
 *13, December, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */
class ManagerLevel {

    companion object {

        var TAG = "ManagerLevel"
        const val URL_SOAL = "http://apps.cumacoding.com/teka-teki_silang"
        lateinit var managerLevel: ManagerLevel

        fun instance(): ManagerLevel {
            managerLevel = ManagerLevel()
            return managerLevel
        }
    }

    private var levels: ArrayList<TtsLevel> = ArrayList()
    private var tts: TSilang? = null

    private var gLevel: Int = 0
    private var gKotak = -1

    init {
        addArrayLevels(Soal.soal10x10, TSilang.KOTAK_10X10)
        addArrayLevels(Soal.soal12x12, 12)
        addArrayLevels(Soal1.soal10x10, TSilang.KOTAK_10X10)
        addArrayLevels(Soal2.soal10x10, TSilang.KOTAK_10X10)
        addArrayLevels(Soal3.soal10x10, TSilang.KOTAK_10X10)

        addLevels(DataGame.get().loadLevelUnduhan())
        downloadSoalOnline()
    }

    private fun downloadSoalOnline() {
        val ls = DataGame.get().loadLevelUnduhan()
        val params = HashMap<String, String>()

        params["user_project"] = "jumadi-12345"
        params["start_index"] = "${(ls.size)}"

        val request = HttpHandler(HttpHandler.REQUEST_METHOD_GET, URL_SOAL, params, object : HttpHandler.ResponseListener {
            override fun onSuccessResponse(string: String?) {
                if (string == null) return

                Log.d(TAG, string)
                if (string.contains("[")) {
                    val data: TtsResponseMsg = Utils.utils.JsonToObject(string,  TtsResponseMsg::class.java)
                    if (data.message == 1) {
                        if (data.data !=null) {
                            DataGame.d!!.saveLevelUnduhan(data.data!!)
                            addLevels(data.data!!)
                        }
                    }
                } else {
                    Log.d(TAG, "Type not JSON")
                }

            }

            override fun onErrorResponse(string: String?) {
                Log.d(TAG, "error : $string")
            }

        })
        request.start()
    }

    fun addLevels(levels: ArrayList<TtsLevel>) {
        this.levels.addAll(levels)
    }

    fun addArrayLevels(obj: Array<Array<Array<Any>>>, jumKotak: Int) {
        for ((i: Int, level: Array<Array<Any>>) in obj.withIndex()) {

            val arrSoal = ArrayList<TtsSoal>()

            for (soal in level) {
                val jawaban = soal[0] as String
                val clue = soal[1] as String
                val row = soal[2] as Int
                val col = soal[3] as Int
                var orentation: Boolean
                orentation = try {
                    soal[4] as Boolean
                } catch (e: Exception) {
                    val o = soal[4] as String
                    o.toLowerCase() == "mendatar".toLowerCase()
                }

                arrSoal.add(TtsSoal(jawaban, clue, row, col, orentation))
            }

            levels.add(TtsLevel(i, arrSoal, jumKotak))
        }
    }

    fun setLevel(mLevel: Int) {
        val level = levels[mLevel]
        val soals = level.soals
        gLevel = mLevel
        gKotak = level.kotak
        tts = TSilang(level.kotak, level.kotak)
        for (soal in  soals) {
            tts!!.add(soal.tts, soal.clue, soal.row, soal.colm, soal.orietation)
        }
    }

    fun levelCount(): Int {
        return levels.size
    }

    fun kotak(): Int {
        return gKotak
    }

    fun level(): Int {
        return gLevel
    }

    fun Tts(): TSilang {
        return this.tts!!
    }

}