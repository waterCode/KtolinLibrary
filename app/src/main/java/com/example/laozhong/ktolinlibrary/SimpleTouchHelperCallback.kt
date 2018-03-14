package com.example.laozhong.ktolinlibrary

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

/**
 * Created by lao.zhong on 2018/3/14.
 */
class SimpleTouchHelperCallback : ItemTouchHelper.Callback{

    var mAdapter:AdapterTouchCallback
    constructor(adapter: AdapterTouchCallback){
        mAdapter = adapter
    }

    override fun getMovementFlags(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?): Int {
        var dragFlag = (ItemTouchHelper.UP)
        var swipeFlag = ItemTouchHelper.LEFT
        return makeMovementFlags(dragFlag,swipeFlag)

    }

    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
        mAdapter.onMove(recyclerView,viewHolder,target)
        return  true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
        mAdapter.onSwiped(viewHolder,direction)
    }

    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

}