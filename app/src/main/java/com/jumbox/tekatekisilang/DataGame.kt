package com.jumbox.tekatekisilang

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Base64
import android.util.JsonReader
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jumbox.tekatekisilang.model.TtsLevel
import java.io.*
import java.util.*
import kotlin.collections.ArrayList
import com.google.gson.JsonParser










/**
 *Created by Jumadi Janjaya
 *30, October, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */
class DataGame(activity: Activity) {

    companion object {
        var TAG = "DataGame"

        @SuppressLint("StaticFieldLeak")
        var d: DataGame? = null
        fun instance(a: Activity): DataGame {
            d = DataGame(a)
            return d!!
        }

        fun get(): DataGame {
            return d!!
        }
    }
    private val atv: Activity = activity
    private var file: File? = null
    private var pathDir: File? = null
    private var fileName = "data.dt"
    private var fileDataLevelsName = "levels.dt"
    private var isEnCodeDataLevels = false
    var data: GD = GD()
    private var dataTts = ArrayList<DataTts>()
    private val paramsK: HashMap<Int, String> = HashMap()
    private var level = 0

    fun create() {
        pathDir = File(atv.filesDir, "save/")
        try {
            if (!pathDir!!.exists()) {
                pathDir!!.mkdir()

                file = File( pathDir,fileName)
                data.level =0
                data.sound = true
                data.bantuan = false
                data.jumlahCek = 15
                data.jumlahPoint = 0
                data.level = 0
                data.rating = 0

                val tts = DataTts()
                tts.level = data.level
                tts.ttsText = ""
                tts.point = 100
                dataTts.add(tts)
                data.dataTtsSave = dataTts

                save()
                Log.i("dataGAME", "SAVE")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        load()
        Log.i("dataGAME", "load")
    }

    fun save() {
        val gson = Gson().toJson(data)
        val output = BufferedWriter(FileWriter("$pathDir/$fileName"))
        output.write(gson)
        output.close()

    }

    fun load() {
        val json = BufferedReader(FileReader("$pathDir/$fileName"))
         data = Gson().fromJson(json, DataGame . GD ::class.java)

    }

    fun saveLevelUnduhan(levels: ArrayList<TtsLevel>) {
        val fileSoal = File(pathDir, fileDataLevelsName)
        if (!fileSoal.isFile) {
            fileSoal.createNewFile()
        }
        val load = loadLevelUnduhan()
        load.addAll(levels)
        val gson = Gson().toJson(load)
        val fileOutputStream = FileOutputStream("$pathDir/$fileDataLevelsName")

        if (isEnCodeDataLevels) {
            fileOutputStream.write(Base64.encode((gson + System.getProperty("line.separator")).toByteArray(), Base64.DEFAULT))
        } else {
            fileOutputStream.write((gson + System.getProperty("line.separator")).toByteArray())
        }
        fileOutputStream.close()

        Log.d(TAG, gson)

        val data: ArrayList<TtsLevel> = Utils.utils.JsonToObject(gson, object : TypeToken<ArrayList<TtsLevel>>(){}.type)

    }

    fun loadLevelUnduhan(): ArrayList<TtsLevel> {
        val fileSoal = File(pathDir, fileDataLevelsName)
        val arr = ArrayList<TtsLevel>()

        if (!fileSoal.isFile) return arr

        var fileContent = ""

        try {
            val fileInputStream = FileInputStream("$pathDir/$fileDataLevelsName")
            fileContent = HttpHandler.convertStreamToString(fileInputStream)

            if (isEnCodeDataLevels) {
                fileContent = String(Base64.decode(fileInputStream.readBytes(), Base64.DEFAULT),Charsets.UTF_8)
            }
            fileInputStream.close()

            Log.d(TAG, fileContent)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        if (fileContent.isEmpty() || fileContent.isBlank()) return arr

        val parser = JsonParser()
        val array = parser.parse(fileContent).asJsonArray
        for (json in array) {
            val entity = Gson().fromJson(json, TtsLevel::class.java)
            arr.add(entity)
        }

        Log.d(TAG, ""+array.size())
        return arr
    }

    fun setScreenWidth(width: Int): DataGame {
        data.screenWidth = width
        return this
    }

    fun setScreenHeight(height: Int): DataGame {
        data.screenHeight = height
        return  this
    }

    fun setHeightRecy(height: Int): DataGame {
        data.heightRecy = height
        return this
    }

    fun addDataKotak(): DataGame {
        val tts = DataTts()
        tts.level = data.level
        tts.ttsText = ""
        tts.point = 100
        data.dataTtsSave!!.add(tts)
        return this
    }

    fun setLevel(level: Int): DataGame {
        data.level = level
        return this
    }

    fun setSound(sound: Boolean): DataGame {
        data.sound = sound
        return this
    }

    fun setBantuan(bantuan: Boolean): DataGame {
        data.bantuan = bantuan
        return this
    }

    fun setJumCek(cek: Int): DataGame {
        data.jumlahCek = cek
        return this
    }

    fun setJumPoints(point: Int): DataGame {
        data.jumlahPoint = point
        return this
    }

    fun setRating(rating: Int): DataGame {
        data.rating = rating
        return this
    }

    fun setPoint(point: Int): DataGame {
        data.dataTtsSave!![level].point = point
        return this
    }

    fun getPoint(): Int {
        return data.dataTtsSave!![level].point!!
    }

    fun saveKotak(id: Int, text: String) {
        if (paramsK[id] != null) {
            paramsK.remove(id)
            paramsK[id] = text
        } else {
            paramsK[id] = text
        }
        var t = ""
        paramsK.forEach {
            t += "${it.key}:${it.value}|"
        }
        data.dataTtsSave!![level].ttsText = t
        save()

    }

    fun clearKotak():DataGame {
        data.dataTtsSave!![level].ttsText = ""
        return this
    }

    fun loadKotak(id: Int): String {
        return if (paramsK.size > 0) {
            if (paramsK[id] != null) {
                paramsK[id]!!
            } else {
                ""
            }
        } else {
            ""
        }
    }

    fun loadDataLevel(level: Int) {
        paramsK.clear()
        this.level = lSToIndex(level)
        try {
            if (data.dataTtsSave!![this.level].ttsText!!.contains("|")) {
                val arr = data.dataTtsSave!![this.level].ttsText!!.split("|")
                for (i in 0 until arr.size-1) {
                    val ar = arr[i].split(":")
                    Log.i("loaddatalevel", "${ar[0]} , ${ar[1]}")
                    paramsK[ar[0].toInt()] = ar[1]
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun lSToIndex(level: Int): Int {
        var index: Int = -1
        for (t in 0 until data.dataTtsSave!!.size) {
            if (level == data.dataTtsSave!![t].level!!) {
                index = t
            }
        }
        return index
    }

    class GD {
        var screenWidth: Int? = null
        var screenHeight: Int? = null
        var heightRecy: Int? = null
        var sound: Boolean? = null
        var bantuan: Boolean? = null
        var jumlahCek: Int? = null
        var jumlahPoint: Int? = null
        var level: Int? = null
        var dataTtsSave: ArrayList<DataTts>? = ArrayList()
        var rating: Int? = null
    }

    class DataTts {
        var level: Int? = null
        var ttsText: String? = null
        var point: Int? = null
    }

}