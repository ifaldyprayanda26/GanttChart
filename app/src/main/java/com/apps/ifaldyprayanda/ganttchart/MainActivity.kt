package com.apps.ifaldyprayanda.ganttchart

import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.apps.ifaldyprayanda.ganttchart.Adapter.GantAdapter
import com.apps.ifaldyprayanda.ganttchart.Common.Common
import com.apps.ifaldyprayanda.ganttchart.Listener.IOnCardItemClickListener
import com.apps.ifaldyprayanda.ganttchart.Model.GanttItem
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), IOnCardItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create adapter
        createAdapter()
    }

    private fun createAdapter() {
        val fullList: MutableList<GanttItem> = ArrayList()
        // example row
        // row:1 success, from 0 to 3 / 45
        val row1 = GanttItem(false, "Requirements", Point(0,3))
        // row 2: success, from 5 to 10 / 45
        val row2 = GanttItem(false, "Design", Point(5, 10))

        fullList.add(row1)
        fullList.add(row2)

        //Add Empty row
        fullList.add(GanttItem("Coding", true))
        fullList.add(GanttItem("Testing", true))

        //Add Error row (Red)
        fullList.add(GanttItem(true, "Maintenance", Point(6,7)))

        // Okay, now create adapter
        val adapter = GantAdapter(this, fullList)
        val body = getBody(fullList)
        adapter.setFirstHeader("Task Name")
        adapter.setFirstBody(body as List<List<String?>?>?)
        adapter.header = header
        adapter.body = body as List<List<String?>?>?
        adapter.setSection(body as List<List<String?>?>?)

        adapter.setListener(this)

        tablefixheaders.adapter = adapter // Set Adapter
    }

    private fun getBody(fullList: MutableList<GanttItem>): MutableList<List<String>> {
        val rows: MutableList<List<String>> = ArrayList()

        for (ganttItem in fullList)
        {
            val cols: MutableList<String> = ArrayList()
            if (!ganttItem.isEmpty) // If have gant item
            {
                for (col in 0 until Common.COLUMN_COUNT)
                    if (col >= ganttItem.point.x && col < ganttItem.point.y)
                        if (ganttItem.isError) cols.add("error") else cols.add("done")
                    else cols.add("empty")

                rows.add(cols)
            }else
            {
                // Just Create empty code
                for (col in 0 until Common.COLUMN_COUNT) cols.add("empty")
                rows.add(cols)
            }
        }
        return rows
    }

    private val header: MutableList<String>
        private get()
        {
            val header: MutableList<String> = ArrayList()
            for (i in 0 until Common.HEADER_COUNT) header.add(StringBuilder().append(i).toString())
            return header
        }

    override fun onCardItemClickListener(view: View?, row: Int) {
        val text_view = view!! as TextView
        Toast.makeText(this, "" + text_view.text + "Row : " + row, Toast.LENGTH_SHORT).show()
    }


}