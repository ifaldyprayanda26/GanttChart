package com.apps.ifaldyprayanda.ganttchart.Adapter

import android.content.Context
import com.apps.ifaldyprayanda.ganttchart.Common.Common
import com.apps.ifaldyprayanda.ganttchart.Listener.IOnCardItemClickListener
import com.apps.ifaldyprayanda.ganttchart.Model.GanttItem
import com.apps.ifaldyprayanda.ganttchart.R
import com.apps.ifaldyprayanda.ganttchart.ViewGroup.BarCellViewGroup
import com.apps.ifaldyprayanda.ganttchart.ViewGroup.DefaultCellViewGroup
import miguelbcr.ui.tableFixHeadesWrapper.TableFixHeaderAdapter

class GantAdapter(
    private val context: Context, private val ganttItemList: List<GanttItem>): TableFixHeaderAdapter<String, DefaultCellViewGroup, String, DefaultCellViewGroup, List<String?>?, DefaultCellViewGroup, BarCellViewGroup, DefaultCellViewGroup>(context) {

    private var listener: IOnCardItemClickListener? = null

    fun setListener(listener: IOnCardItemClickListener)
    {
        this.listener = listener
    }


    override fun isSection(p0: MutableList<List<String?>?>?, p1: Int): Boolean {
       return false
    }

    override fun inflateBody(): BarCellViewGroup {
        return BarCellViewGroup(context, ganttItemList)
    }

    override fun getHeaderWidths(): MutableList<Int> {
        val headerWidths : MutableList<Int> = ArrayList()
        // First Header
        headerWidths.add(context.resources.getDimension(R.dimen._150dp).toInt())
        // Each Remain header , set 40dp
        for (i in 0 until Common.COLUMN_COUNT) headerWidths.add(context.resources.getDimension(R.dimen._40dp).toInt())
        return headerWidths
    }

    override fun getHeaderHeight(): Int {
        return context.resources.getDimension(R.dimen._40dp).toInt()
    }

    override fun getSectionHeight(): Int {
        return context.resources.getDimension(R.dimen._40dp).toInt()
    }

    override fun inflateHeader(): DefaultCellViewGroup {
        val defaultCellViewGroup = DefaultCellViewGroup(context, ganttItemList)
        defaultCellViewGroup.setListener(listener!!)
        return defaultCellViewGroup
    }

    override fun inflateSection(): DefaultCellViewGroup {
        return DefaultCellViewGroup(context, ganttItemList)
    }

    override fun inflateFirstBody(): DefaultCellViewGroup {
       val defaultCellViewGroup = DefaultCellViewGroup(context, ganttItemList)
        defaultCellViewGroup.setListener(listener!!)
        return defaultCellViewGroup
    }

    override fun inflateFirstHeader(): DefaultCellViewGroup {
        return DefaultCellViewGroup(context, ganttItemList)
    }

    override fun getBodyHeight(): Int {
        return context.resources.getDimension(R.dimen._40dp).toInt()
    }
}