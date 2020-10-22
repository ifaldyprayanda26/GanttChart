package com.apps.ifaldyprayanda.ganttchart.Listener

import android.view.View

class MyClickListener (private val row: Int, private val listener:IOnCardItemClickListener): View.OnClickListener {
    override fun onClick(view: View?) {
        listener.onCardItemClickListener(view, row)
    }
}