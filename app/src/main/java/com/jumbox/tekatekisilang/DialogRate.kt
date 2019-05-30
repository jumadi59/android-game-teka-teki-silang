package com.jumbox.tekatekisilang

import android.content.ActivityNotFoundException
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.RatingBar
import android.content.Intent
import android.net.Uri
import android.widget.TextView

@Suppress("DEPRECATION")
/**
 *Created by Jumadi Janjaya
 *25, October, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */

class DialogRate : DialogFragment() {

    var ratingBar: RatingBar? = null
    var btnBatal: Button? =null
    var btnRateMe: Button? = null
    var txtRate: TextView? = null
    var jumRating: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_dialog_rate, container, false)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setStyle(android.support.v4.app.DialogFragment.STYLE_NO_FRAME, android.R.style.Theme)

        ratingBar = v.findViewById(R.id.rating)
        btnBatal = v.findViewById(R.id.batal_rate)
        btnRateMe = v.findViewById(R.id.btn_rate_me)
        txtRate = v.findViewById(R.id.txtRating)

        btnRateMe!!.typeface = Utils.utils.font(Utils.DIMBO)
        txtRate!!.typeface = Utils.utils.font(Utils.DIMBO)
        btnBatal!!.typeface = Utils.utils.font(Utils.DIMBO)

        ratingBar!!.rating = DataGame.get().data.rating!!.toFloat()

        ratingBar!!.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { r, rating, b ->
            jumRating = rating.toInt()
        }

        btnRateMe!!.setOnClickListener {
            MediaManager.sound!!.playClick()
            DataGame.get().setRating(jumRating)
            try {
                val uri = Uri.parse("market://details?id=" + activity!!.packageName)
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = uri
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                val uri = Uri.parse("https://play.google.com/store/apps/details?id=" + activity!!.packageName)
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = uri
                startActivity(intent)
            }
            dialog.dismiss()
        }

        btnBatal!!.setOnClickListener {
            MediaManager.sound!!.playClick()
            dialog.cancel()
        }

        return v
    }

}// Required empty public constructor
