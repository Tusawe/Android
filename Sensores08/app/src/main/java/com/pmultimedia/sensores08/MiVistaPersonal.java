package com.pmultimedia.sensores08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class MiVistaPersonal extends View {

    static final int ancho = 100, alto = 100;

    public MiVistaPersonal(Context context) {
        super(context);
        ShapeDrawable mDibujo = new ShapeDrawable(new OvalShape());
        mDibujo.getPaint().setColor(0xff74AC23);
        mDibujo.setBounds(Sensores08.x, Sensores08.y, Sensores08.x + ancho, Sensores08.y + alto);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        RectF oval = new RectF(Sensores08.x, Sensores08.y, Sensores08.x + ancho, Sensores08.y + alto);
        Paint pincel = new Paint();
        pincel.setColor(Color.BLUE);
        canvas.drawOval(oval, pincel);
        invalidate();
    }
}
