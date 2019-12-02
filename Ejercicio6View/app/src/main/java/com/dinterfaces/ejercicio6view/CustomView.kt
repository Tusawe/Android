package com.dinterfaces.ejercicio6view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0 ) : View(context, attrs, defStyle) {

    var touchx = 0f
    var touchy = 0f
    var touching = false

    var paintstroke = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 20f
    }

    var paint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
    }
        set(value) {
            field = value
            invalidate()
        }

    init {
        val ta = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView, 0,0)
        val color = ta.getColor(R.styleable.CustomView_color, DEFAULT_BACKGRAUNDCOLOR)
        paint.color = color
        ta.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        if(touching) {
            canvas.drawCircle(touchx, touchy, 20f, paint)
            canvas.drawCircle(touchx, touchy, 30f, paintstroke)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN -> touching = false
            MotionEvent.ACTION_UP -> touching = true
        }
        touchx = event.x
        touchy = event.y
        invalidate()
        return true
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = getMeasure(widthMeasureSpec, DEFAULT_WIDTH)
        val heigth = getMeasure(heightMeasureSpec, DEFAULT_HEIGHT)
        setMeasuredDimension(width, heigth)
    }

    private fun getMeasure(measureSpec: Int, defaultSize: Int): Int {
        val mode = MeasureSpec.getMode(measureSpec)
        val size = MeasureSpec.getSize(measureSpec)
        when (mode){
            MeasureSpec.EXACTLY -> return size
            MeasureSpec.AT_MOST -> return size
            MeasureSpec.UNSPECIFIED ->  return defaultSize
            else -> return defaultSize
        }
    }

    companion object{
        private const val DEFAULT_WIDTH = 100
        private const val DEFAULT_HEIGHT = 100
        private const val DEFAULT_BACKGRAUNDCOLOR = Color.WHITE
    }
}