package com.example.laozhong.ktolinlibrary

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

/**
 * Created by lao.zhong on 2018/3/14.
 */
class TestAdapter : RecyclerView.Adapter<TestAdapter.TestViewHolder>,AdapterTouchCallback{


    var data : ArrayList<String> = ArrayList()

    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
        if(viewHolder == null || target == null){
            return false
        }else {

            var from: Int = viewHolder.adapterPosition
            var to = target.adapterPosition
            Collections.swap(data, from, to)
            notifyItemMoved(from,to)
            return true
        }
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
        if(viewHolder != null) {
            data.removeAt(viewHolder.adapterPosition)
            notifyItemRemoved(viewHolder.adapterPosition)
        }
    }


    constructor() : super()



    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.text?.text =data.get(position)
    }

    override fun getItemCount(): Int {
        return data.size

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return TestViewHolder(view)

    }

    class TestViewHolder: RecyclerView.ViewHolder {
        var text : TextView ?=null
        constructor(itemView: View?) : super(itemView){
            text = itemView?.findViewById(R.id.tv_test_data)
        }
    }
}