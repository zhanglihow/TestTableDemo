package com.example.testtabledemo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val names1= mutableListOf<String>()
        val names2= mutableListOf<String>()
        val names3= mutableListOf<String>()
        names1.add("111")
        names1.add("222")
        names1.add("333")
        names1.add("444")
        names1.add("555")
        names2.clear()
        names2.add("你好")
        names2.add("他好")
        names2.add("她好")
        names2.add("它好")
        names2.add("好")
        names3.clear()
        names3.add("你好")
        names3.add("他123123112312312312顺丰到付23好")
        names3.add("她好")
        names3.add("它123123好")
        names3.add("好111")

        table_layout.initWidth(getWindowWidth(this))
        table_layout.addTables(names1)

        table_layout2.initWidth(getWindowWidth(this))
        table_layout2.addTables(names3,names1)

        table_layout3.initWidth(getWindowWidth(this))
        table_layout3.addTables(names1,names2,names3,names1)
    }


    private fun getWindowWidth(context: Activity):Int{
        val outMetrics = DisplayMetrics()
        context.windowManager.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.widthPixels
    }

}