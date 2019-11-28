package com.dinterfaces.ejercicio6view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.drawable.toBitmap

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

    var paintLine = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.STROKE
        strokeWidth = 15f
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

    var angulo = 0f
    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(0f,0f,width.toFloat(), height.toFloat(), paint)
    }

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
        private const val DEFAULT_BACKGROUNDCOLOR = Color.WHITE
    }

}