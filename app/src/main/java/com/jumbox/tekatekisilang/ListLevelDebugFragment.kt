package com.jumbox.tekatekisilang

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_list_level_debug.view.*

/**
 *Created by Jumadi Janjaya
 *15, December, 2018
 *Jumbox Studios,
 *Bengkulu, Indonesia.
 */


class ListLevelDebugFragment : Fragment() {

    companion object {
        val TAG = "ListLevelDebugFragment"
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v =  inflater.inflate(R.layout.fragment_list_level_debug, container, false)

        recyclerView = v.findViewById(R.id.recyclerview)
        adapter = ListAdapter(listener)
        v.tv_pilih.typeface = Utils.utils.font(Utils.DIMBO)

        val gridLayoutManager = GridLayoutManager(context, 4)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = adapter
        return v
    }

    private val listener = object : ListAdapter.LevelListener {
        override fun onClick(position: Int) {
            val fragment = MainGameFragmet()
            val bundle = Bundle()
            bundle.putInt("level", position)
            fragment.arguments = bundle
            val transaction  = activity!!.supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
            transaction.replace(R.id.fragment_container, fragment, MainGameFragmet.TAG).addToBackStack(TAG).commit()
        }

    }

    class ListAdapter(var levelListener: LevelListener) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_pilih_soal, parent, false)
            return ViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return ManagerLevel.managerLevel.levelCount()
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.tvLevel.text = position.plus(1).toString()
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

            override fun onClick(p0: View?) {
                levelListener.onClick(position)
            }
            var tvLevel: TextView = itemView.findViewById(R.id.tv_level)

            init {
                itemView.setOnClickListener(this)
                tvLevel.typeface = Utils.utils.font(Utils.DIMBO)
            }
        }

        interface LevelListener {
            fun onClick(position: Int)
        }
    }

}