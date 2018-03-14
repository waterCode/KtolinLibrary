package com.example.laozhong.ktolinlibrary

import android.support.v7.widget.RecyclerView

/**
 * Created by lao.zhong on 2018/3/14.
 */
interface AdapterTouchCallback {

    fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean


    fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int)
}