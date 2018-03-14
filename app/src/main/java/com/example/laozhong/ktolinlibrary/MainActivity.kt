package com.example.laozhong.ktolinlibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()

    }

    private fun initData() {
        rv_test_list.layoutManager = LinearLayoutManager(this)
        var adapter = TestAdapter()
        var data = adapter.data
        for (i in 1..10) {
            data.add(i.toString() + "个数据")
        }
        Log.d("haha",data.size.toString())
        rv_test_list.adapter = adapter
        adapter.notifyDataSetChanged()
        var callback = SimpleTouchHelperCallback(adapter)
        var touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(rv_test_list)
    }


}
