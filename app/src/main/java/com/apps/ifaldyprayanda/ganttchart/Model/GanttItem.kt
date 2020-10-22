package com.apps.ifaldyprayanda.ganttchart.Model

import android.graphics.Point

class GanttItem {
    var isError = false
    var title: String = ""
    var point: Point = Point()
    var isEmpty = false

    //constructor with title and is empty
    constructor(title: String, isEmpty: Boolean)
    {
        this.isEmpty = isEmpty
        this.title = title
    }

    //create constructor with title, error and point
    constructor(isError: Boolean, title: String, point: Point) {
        this.isError = isError
        this.title = title
        this.point = point
    }



}