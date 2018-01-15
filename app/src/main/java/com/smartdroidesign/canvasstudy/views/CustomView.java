package com.smartdroidesign.canvasstudy.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.smartdroidesign.canvasstudy.R;



public class CustomView extends View {

    
    private static final int SQUARE_SIZE_DEF = 200;



    private RectF mRectSquare;
    private Paint mPaintSquare;
    private int mSquareColor;
    private int mSquareSize;
    private Paint mPaintCircle;
    private Path mPath;
    
    public CustomView(Context context) {
        super(context);

        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set){

        mRectSquare = new RectF();
        mPath = new Path();
        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintSquare.setStrokeWidth(3);
        mPaintSquare.setStyle(Paint.Style.STROKE);

        mPaintCircle = new Paint();
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setStyle(Paint.Style.STROKE);
        mPaintCircle.setColor(Color.parseColor("#00ccff"));

        mPath.addArc(mRectSquare, 20, 10);


        if(set == null)
            return;

        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.CustomView);

        mSquareColor = ta.getColor(R.styleable.CustomView_square_color, Color.GREEN);
        mSquareSize = ta.getDimensionPixelSize(R.styleable.CustomView_square_size, SQUARE_SIZE_DEF);
        mPaintSquare.setColor(mSquareColor);

        ta.recycle();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*mRectSquare.set(55,55,150,150);
        canvas.drawRoundRect(mRectSquare, 10, 10, mPaintSquare);
        mPaintSquare.setStrokeWidth(5);*/



        //mRectSquare.set(65,65,175,175);
        //canvas.drawRoundRect(mRectSquare, 20, 20, mPaintSquare);


        mRectSquare.left = 50;
        mRectSquare.top = 50;
        mRectSquare.right = mRectSquare.left + mSquareSize;
        mRectSquare.bottom = mRectSquare.top + mSquareSize;
        canvas.drawRoundRect(mRectSquare, 20, 20, mPaintSquare);
        canvas.drawArc(mRectSquare,90,360,false, mPaintCircle);
        canvas.drawLine(20,20,0,100,mPaintSquare);


        float cx, cy;
        float radius = 100f;

        cx = getWidth() - radius - 150f;
        cy = mRectSquare.top + (mRectSquare.height() / 2);

        canvas.drawCircle(cx, cy, radius, mPaintCircle);
    }
}
