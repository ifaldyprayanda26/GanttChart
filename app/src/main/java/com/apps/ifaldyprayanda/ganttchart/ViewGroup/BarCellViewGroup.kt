package com.apps.ifaldyprayanda.ganttchart.ViewGroup

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.apps.ifaldyprayanda.ganttchart.Model.GanttItem
import com.apps.ifaldyprayanda.ganttchart.R
import kotlinx.android.synthetic.main.bar_view_item.view.*
import miguelbcr.ui.tableFixHeadesWrapper.TableFixHeaderAdapter

class BarCellViewGroup: FrameLayout, TableFixHeaderAdapter.BodyBinder<List<String?>?> {

    var card_item: RelativeLayout? = null
    var myContext: Context?=null
    var gantItemList: List<GanttItem>?=null

    constructor(context: Context): super(context){}

    constructor(context: Context, ganttItemList: List<GanttItem>): super(context)
    {
        this.myContext = context
        this.gantItemList = ganttItemList

        LayoutInflater.from(context).inflate(R.layout.bar_view_item, this, true)
        card_item = findViewById(R.id.card_item) as RelativeLayout

    }

    override fun bindBody(bodyList: List<String?>?, row: Int, col: Int) {
        if (bodyList!![col] == "error") // if display of body table error, set color red
            card_item!!.setBackgroundColor(ContextCompat.getColor(context!!, android.R.color.holo_red_dark))
        else if (bodyList!![col] == "done") // if display of body table success, set color blue
            card_item!!.setBackgroundColor(ContextCompat.getColor(context!!, android.R.color.holo_blue_bright))
        else // if display of body table empty
            card_item!!.setBackgroundResource(R.drawable.border)
    }
}