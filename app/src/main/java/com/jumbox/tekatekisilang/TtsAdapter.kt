package com.jumbox.tekatekisilang

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView


@Suppress("DEPRECATION")
/**
 *Created by Jumadi Janjaya
 *25, October, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */

class TtsAdapter : RecyclerView.Adapter<TtsAdapter.ViewHolder>() {

    var ttsList: ArrayList<TTS> = ArrayList()
    private var ttsListener: TtsListener? = null
    private var views: HashMap<Int, ViewHolder> = HashMap()
    private var selectArea: ArrayList<ViewHolder> = ArrayList()

    var selectedItem = -1
    var noUbah: Boolean = false
    var bantuan:Boolean = false
    private var txtKode = ""
    var orientation = false
    private var kotak: Int = 0
    private var delayAnimate: Long = 100
    private var positionAnim = 0
    private var noLoadAnim = false

    fun add(tts: TTS) {
        ttsList.add(tts)
    }

    fun add(index: Int, tts: TTS) {
        ttsList.add(index, tts)
    }

    fun remove(index: Int) {
        ttsList.removeAt(index)
    }

    fun get(index: Int): TTS {
        return ttsList[index]
    }

    fun setListener(listener: TtsListener) {
        ttsListener = listener
    }

    fun bantuan(b: Boolean) {
        bantuan = b
        updateAllDataTts()
    }

    fun setK(kotak: Int) {
        this.kotak = kotak
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val itemView = LayoutInflater.from(viewGroup!!.context).inflate(R.layout.layout_item_grid, viewGroup, false)

        itemView.post {
            val height = (DataGame.get().data.heightRecy!! - (viewGroup.paddingTop + viewGroup.paddingBottom)) / kotak.toFloat()
            val width = (DataGame.get().data.screenWidth!! / kotak)

            Log.i("tinggi", " ${DataGame.get().data.heightRecy}, $height")

            val params = itemView.layoutParams
            val marginParams = itemView.layoutParams as ViewGroup.MarginLayoutParams

            params.width = width - (marginParams.leftMargin + marginParams.rightMargin)
            params.height = Math.round(height) - (marginParams.topMargin + marginParams.bottomMargin)
            itemView.layoutParams = params
        }

        val holder = ViewHolder(itemView)
        if (ttsList[i].kode !=null) {
            holder.itemView.setBackgroundColor(Color.WHITE)
            views[i] = holder
        } else {
            holder.itemView.setBackgroundColor(0xffffff)
        }
        return holder
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return ttsList.size
    }

    override fun onBindViewHolder(view: ViewHolder, i: Int) {
        val tts = get(i)
        if (tts.clue != null && !noLoadAnim) {
            view.itemView.visibility = View.GONE
            Handler().postDelayed({
                val anim = AnimationUtils.loadAnimation(view.itemView.context, R.anim.anim_masuk)
                view.itemView.startAnimation(anim)
                view.itemView.visibility = View.VISIBLE
            }, delayAnimate * positionAnim)
            positionAnim++
        }


        if (tts.update != "") {
            view.txtItem.text = tts.update.toUpperCase()
        } else {
            if (BuildConfig.DEBUG) view.txtItem.text = ""
            else view.txtItem.text = ""
        }
        if (tts.clue != null) {

            var selected = false

            if (selectedItem == i) {
                selected = true
                ttsListener!!.click(i, txtKode, noUbah)
            }

            if (bantuan) {
                if (tts.tts.toUpperCase() == tts.update.toUpperCase()) {
                    view.txtItem.setTextColor(Color.BLACK)
                    view.imgSalah.visibility = ImageView.GONE
                } else {
                    if (tts.update !="") {
                        view.txtItem.setTextColor(Color.RED)
                        view.imgSalah.visibility = ImageView.GONE
                    } else {
                        view.imgSalah.visibility = ImageView.VISIBLE
                    }
                }
            } else if (selected) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    view.txtItem.setTextColor(view.itemView.context.getColor(R.color.colorWhite))
                } else {
                    view.txtItem.setTextColor(view.itemView.context.resources.getColor(R.color.colorWhite))
                }
                view.imgSalah.visibility = ImageView.GONE
            } else {
                view.txtItem.setTextColor(Color.BLACK)
                view.imgSalah.visibility = ImageView.GONE
            }

        }

    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!), View.OnClickListener {
        override fun onClick(p0: View?) {
            if(adapterPosition != RecyclerView.NO_POSITION) {
                selectedItem = adapterPosition
                noUbah = false
                focusKotak(selectedItem)
            }
        }

        var txtItem: TextView = itemView!!.findViewById(R.id.tv_tts)
        var imgSalah: ImageView = itemView!!.findViewById(R.id.img_salah)


        init {
            txtItem.typeface = Utils.utils.font(Utils.DIMBO)
            itemView!!.setBackgroundColor(Color.WHITE)
            itemView.setOnClickListener(this)
        }

    }

    fun focusKotak(indexNew: Int) {
        val ts = get(indexNew)

        if (ts.kode != null) {
            if (ts.kode.contains(":")) {
                orientation = !orientation
                val ko = ts.kode.split(":")
                txtKode = if (orientation) {
                    ko[0]
                } else {
                    ko[1]
                }
            } else {
                txtKode = ts.kode
            }
            selectKotak()
            updateDataTts(indexNew)
        }
    }

    private fun selectKotak() {
        clearArea()
        for (i in 0 until ttsList.size) {
            val iO = get(i)

            if (iO.clue != null) {
                if(iO.kode.contains(":")) {
                    val k = iO.kode.split(":")
                    when (txtKode) {
                        k[0] -> selectArea(i)
                        k[1] -> selectArea(i)
                    }
                } else if (iO.kode == txtKode) selectArea(i)
            }
        }

        selectUpdateArea()

    }

    fun nextPos(pos: Int, nextPos: Int) {
        selectedItem = nextPos
        noUbah = true
        views[pos]!!.itemView.setBackgroundResource(R.color.colorKotakSelectArea)
        views[nextPos]!!.itemView.setBackgroundResource(R.color.colorKotakFocus)

        updateDataTts(pos)
        updateDataTts(nextPos)
    }

    private fun selectArea(i: Int) {
        if (views[i] == null) return

        selectArea.add(views[i]!!)
    }

    private fun selectUpdateArea() {
        for ((i, area: ViewHolder) in selectArea.withIndex()) {
            area.itemView.setBackgroundResource(R.color.colorKotakSelectArea)

            if (selectedItem == selectArea[i].position) area.itemView.setBackgroundResource(R.color.colorKotakFocus)
        }
    }

    fun updateAllDataTts() {
        views.forEach {
            noLoadAnim = true
            onBindViewHolder(it.value, it.key)
        }
    }

    private fun updateDataTts(i: Int) {
        if (views[i] == null) return
        noLoadAnim = true
        onBindViewHolder(views[i]!!, i)
    }

    private fun clearArea() {
        for (area: ViewHolder in selectArea) {
            area.txtItem.setTextColor(Color.BLACK)
            area.itemView.setBackgroundColor(Color.WHITE)
        }
        selectArea.clear()
    }

    fun block(index: Int, nextPos: Int): Boolean {
        val ts = get(index)
        val ts1 = get(nextPos)
        if (ts.kode.contains(":") && ts1.kode.contains(":")) {
            val ko = ts.kode.split(":")
            val ko1 = ts1.kode.split(":")
            return when {
                ko[0] == ko1[0] -> false
                ko[1] == ko1[1] -> false
                ko[0] == ko1[1] -> false
                ko[1] == ko1[0] -> false
                else -> true
            }
        } else if (ts1.kode.contains(":")) {
            val ko = ts1.kode.split(":")
            return if (ts.kode == ko[0]) { false
            } else ts.kode != ko[1]
        } else if (ts.kode.contains(":")) {
            val ko = ts.kode.split(":")
            return when {
                ts1.kode == ko[0] -> false
                else -> ts1.kode != ko[1]
            }
        } else {
            return ts.kode != ts1.kode
        }

    }

    interface TtsListener {
        fun click(posisi: Int, txtpKode: String, noUbah: Boolean)
    }

}