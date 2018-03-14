package com.example.recyclerviewtest.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by lao.zhong on 2018/3/13.
 */

class SwipeRecyclerView : RecyclerView {

    var mLastX = 0
    var mLastY = 0


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun onTouchEvent(e: MotionEvent?): Boolean {
        //滑动就移动距离

        var deltX = 0
        var deltY = 0
        when (e?.action) {
            MotionEvent.ACTION_DOWN -> {
                mLastX = e.x.toInt()
                mLastY = e.y.toInt()
            }

            MotionEvent.ACTION_MOVE -> {
                deltX = e.x.toInt()-mLastX
                deltY = e.y.toInt()- mLastY

            }
        }

        return super.onTouchEvent(e)


    }


}