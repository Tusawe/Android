package com.iesvirgendelcarmen.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
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
        Log.d("CUSTOMVIEW", "Se ejecuta setter")
        invalidate()
    }


//    val paintRectable = Paint().apply {
//        color = Color.BLUE
//        style = Paint.Style.FILL
//    }
//
//    val paintRectableBorder = Paint().apply {
//        color = Color.BLACK
//        style = Paint.Style.STROKE
//        strokeWidth = 50f
//    }
//
//    val paintTriangle = Paint().apply {
//        color = Color.GRAY
//        style = Paint.Style.FILL
//        isAntiAlias = true
//    }
//
//    var bitmap: Bitmap


    init {
        val ta = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView,0, 0)
        val color = ta.getColor(R.styleable.CustomView_backgroundColor, DEFAULT_BACKGROUNDCOLOR)
        paint.color = color
        ta.recycle()
        // bitmap = context.getDrawable(R.drawable.jaen_paraiso)?.toBitmap(200,200)!!
    }




    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(0f,0f,width.toFloat(), height.toFloat(), paint)
        //canvas.drawRect(0f, 0f, width.toFloat() / 2, height.toFloat(), paintRectable)
//        val rect = Rect(0,0, width / 2, height)
//        canvas.drawRect(rect, paintRectable)
//        canvas.drawRect(rect, paintRectableBorder)
//
//
//        canvas.drawLine(0f,0f, width.toFloat(), height.toFloat(), paintRectableBorder)
//
//        val radio = Math.min(width, height) / 2.toFloat()
//
//        canvas.drawCircle(width.toFloat() / 2, height.toFloat() /2, radio, paintRectable)
//
//        canvas.drawBitmap(bitmap, 0f, 0f, null)
//        val src = Rect(0,0, bitmap.width, bitmap.height/2)
//        val dst = Rect(0,0, width, height)
//        canvas.drawBitmap(bitmap, src, dst, null)
//
//        val triangulo = Path()
//        triangulo.reset()
//        triangulo.moveTo(width / 2.toFloat(), 0f)
//        triangulo.lineTo(width.toFloat(), height.toFloat())
//        triangulo.lineTo(0f, height.toFloat())
//
//        canvas.drawPath(triangulo, paintTriangle)
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
        private const val DEFAULT_WIDTH = 500
        private const val DEFAULT_HEIGHT = 200
        private const val DEFAULT_BACKGROUNDCOLOR = Color.BLACK
    }

}