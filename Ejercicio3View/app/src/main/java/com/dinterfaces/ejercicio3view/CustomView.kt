package com.dinterfaces.ejercicio3view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle : Int = 0
) : View(context, attrs, defStyle) {

    var paint = Paint().apply {
        color = Color.RED
    }

    set(value) {
        field = value
        invalidate()
    }

    var paintcircle = Paint().apply {
        val colorAletarorio : Int = (Math.random()*3).toInt()
        when(colorAletarorio){
            0 -> color = Color.BLUE
            1 -> color = Color.RED
            2 -> color = Color.YELLOW
            else -> color = Color.WHITE
        }
    }

        set(value) {
            field = value
            invalidate()
        }

    init {
        val ta = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView,0, 0)
        val color = ta.getColor(R.styleable.CustomView_backgroundColor, DEFAULT_BACKGROUNDCOLOR)
        paint.color = color
        ta.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(0f,0f,width.toFloat(), height.toFloat(), paint)
        for (i in 0..200) {
            canvas.drawCircle((Math.random()*width).toFloat(),(Math.random()*height).toFloat(),(Math.random()*50).toFloat(), paintcircle)
        }
    }

//    private fun colorAleatorio(): Paint {
//        var paintcircle = Paint().apply {
//            val colorAletarorio : Int = (Math.random()*3).toInt()
//            when(colorAletarorio){
//                0 -> color = Color.BLUE
//                1 -> color = Color.RED
//                2 -> color = Color.YELLOW
//                else -> color = Color.WHITE
//            }
//        }
//
//        return paintcircle
//    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = getMeasure(widthMeasureSpec, DEFAULT_WIDTH)
        val height = getMeasure(heightMeasureSpec, DEFAULT_HEIGHT)
        setMeasuredDimension(width, height)
    }

    private fun getMeasure(measureSpec: Int, defaultSize: Int) : Int {
        val mode = MeasureSpec.getMode(measureSpec)
        val size = MeasureSpec.getSize(measureSpec)
        when (mode) {
            MeasureSpec.EXACTLY -> return size
            MeasureSpec.AT_MOST -> return Math.min(size, defaultSize)
            MeasureSpec.UNSPECIFIED -> return defaultSize
            else -> return defaultSize
        }
    }

    companion object {
        private const val DEFAULT_WIDTH = 100
        private const val DEFAULT_HEIGHT = 100
        private const val DEFAULT_BACKGROUNDCOLOR = Color.BLACK
    }

}