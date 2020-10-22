package com.apps.ifaldyprayanda.ganttchart.ViewGroup

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.apps.ifaldyprayanda.ganttchart.Listener.IOnCardItemClickListener
import com.apps.ifaldyprayanda.ganttchart.Listener.MyClickListener
import com.apps.ifaldyprayanda.ganttchart.Model.GanttItem
import com.apps.ifaldyprayanda.ganttchart.R
import miguelbcr.ui.tableFixHeadesWrapper.TableFixHeaderAdapter

class DefaultCellViewGroup: FrameLayout, TableFixHeaderAdapter.FirstHeaderBinder<String?>, TableFixHeaderAdapter.HeaderBinder<String?>, TableFixHeaderAdapter.FirstBodyBinder<List<String?>?>,TableFixHeaderAdapter.BodyBinder<List<String?>>, TableFixHeaderAdapter.SectionBinder<List<String?>?> {

    var text_view: TextView
    private var rowList:List<GanttItem>? = null

    private var listener: IOnCardItemClickListener? = null

    fun setListener(listener: IOnCardItemClickListener)
    {
        this.listener = listener
    }

    constructor(context: Context, rowList: List<GanttItem>):super(context)
    {
        LayoutInflater.from(context).inflate(R.layout.text_item, this, true)
        text_view = findViewById(R.id.txt_content) as TextView
        this.rowList = rowList
    }

    //bind first header of table
    override fun bindFirstHeader(headerName: String?) {
        text_view.text = headerName!!

    }

    //bind header of table
    override fun bindHeader(headerName: String?, col: Int) {
        text_view.text = headerName!!
    }

    override fun bindFirstBody(bodyList: List<String?>?, row: Int) {
        text_view.text = rowList!![row].title
        text_view.setOnClickListener(MyClickListener(row,listener!!))
    }

    override fun bindBody(items: List<String?>?, row: Int, col: Int) {
        text_view.text = items!![col]
    }

    override fun bindSection(p0: List<String?>?, row: Int, col: Int) {
        text_view.text = if (col == 0) "Section: " + (row+1) else ""
    }

}