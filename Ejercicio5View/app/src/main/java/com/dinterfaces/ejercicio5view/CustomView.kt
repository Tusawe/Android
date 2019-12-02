package com.dinterfaces.ejercicio5view

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

    var bitmap: Bitmap

    init {
        val ta = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView,0, 0)
        val color = ta.getColor(R.styleable.CustomView_backgroundColor, DEFAULT_BACKGROUNDCOLOR)
        paint.color = color
        ta.recycle()
        bitmap = context.getDrawable(R.drawable.fondo)?.toBitmap(300,400)!!
    }

    var angulo = 0f
    override fun onDraw(canvas: Canvas) {

        var sentido = 1
        if(giro) sentido = velocidad.toInt()/10
        else sentido = -(velocidad.toInt())/10

        canvas.drawRect(0f,0f,width.toFloat(), height.toFloat(), paint)
        canvas.rotate(angulo, width/2f, height/2f)
        canvas.drawBitmap(bitmap, width.toFloat()/2-150f, height.toFloat()/2-200f, null)
        angulo+=sentido
        postInvalidateDelayed(1)
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
        private const val DEFAULT_BACKGROUNDCOLOR = Color.BLACK
        var giro : Boolean = true
        var velocidad : Long = 0
    }

}