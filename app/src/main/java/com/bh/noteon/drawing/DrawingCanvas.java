package com.bh.noteon.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class DrawingCanvas extends View {

    private int mColor = Color.BLACK;
    private Paint.Style mStyle = Paint.Style.STROKE;
    private float x1 = 0, x2 = 0, y1 = 0, y2 = 0;
    public DrawingCanvas(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(mColor);
        p.setStyle(mStyle);
        p.setStrokeWidth(1);
        canvas.drawRect(x1, y1, x2, y2, p);
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO
        return true;
    }

}
