package com.example.iontophoresis

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.view.View

class shadow(view: View) : View.DragShadowBuilder(view) {
    private val shadowPaint = Paint().apply {
        color = Color.RED
        alpha = 100
    }

    override fun onProvideShadowMetrics(outShadowSize: Point, outShadowTouchPoint: Point) {
        val width: Int = view.width
        val height: Int = view.height

        outShadowSize.set(width, height)
        outShadowTouchPoint.set(width / 2, height / 2)
    }

    override fun onDrawShadow(canvas: Canvas) {
        canvas.drawRect(0f, 0f, view.width.toFloat(), view.height.toFloat(), shadowPaint)
    }
}