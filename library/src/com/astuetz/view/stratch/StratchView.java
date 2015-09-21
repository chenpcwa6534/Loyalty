package com.astuetz.view.stratch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MTel on 2015/9/17.
 */
public class StratchView extends View{
    private String TAG = StratchView.class.getSimpleName();

    private boolean isMove = false;
    private Bitmap bitmap = null;
    private Bitmap frontBitmap = null;
    private Path path;
    private Canvas mCanvas;
    private Paint mPaint;
    private StratchViewCallback mListener;
    private int DECIDEPOINTCOUNT = 5;
    private int BORDER = 100;
    private ArrayList<Map<String,Object>> mDecidePointList = new ArrayList<Map<String,Object>>();
    private boolean isDecide = false;

    private String tag_DecidePoint_X = "DecidePoint_X";
    private String tag_DecidePoint_Y = "DecidePoint_Y";
    private String tag_isTouch = "isTouch";

    private int mViewWidth = 0;
    private int mViewHeight = 0;

    public interface StratchViewCallback{
        void onStratchFinish();
        void onMoveLocation(float x, float y);
    }

    public StratchView(Context context) {
        super(context);
    }

    public StratchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StratchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ax = event.getX();
        float ay = event.getY();
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            isMove = false;
            path.reset();
            path.moveTo(ax,ay);
            invalidate();
            return true;
        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            isMove = true;
            path.lineTo(ax,ay);
            mListener.onMoveLocation(ax,ay);
            if(DecidePoint(ax,ay)){
                mListener.onStratchFinish();
            }
            invalidate();
            return true;
        }else if(event.getAction() == MotionEvent.ACTION_UP){

        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mViewWidth = getWidth();
        mViewHeight = getHeight();
        if(mCanvas == null){
            stratchBitmap();
        }
        if(mDecidePointList.size() == 0){
            CreateDecidePoint();
        }
        canvas.drawBitmap(bitmap, 0, 0 ,null);
        mCanvas.drawPath(path, mPaint);
        super.onDraw(canvas);
    }

    public void setCallback(StratchViewCallback listener){
        this.mListener = listener;
        isDecide =true;
    }

    private void stratchBitmap(){
        bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
        frontBitmap = CreateBitmap(Color.GRAY, getWidth(), getHeight());

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(50);

        path = new Path();

        mCanvas = new Canvas(bitmap);
        mCanvas.drawBitmap(frontBitmap, 0, 0 , null);
    }

    private Bitmap CreateBitmap(int color, int width, int height){
        int[] rgb = new int[width * height];
        for(int i=0; i<rgb.length; i++){
            rgb[i] = color;
        }
        return Bitmap.createBitmap(rgb, width, height, Bitmap.Config.ARGB_4444);
    }

    private boolean DecidePoint(float x, float y){
        boolean isTouch_all = true;
        if(isDecide){
            for(int i=0; i<DECIDEPOINTCOUNT; i++){
                Map<String,Object> map = mDecidePointList.get(i);
                float cx = Float.parseFloat(map.get(tag_DecidePoint_X).toString());
                float cy = Float.parseFloat(map.get(tag_DecidePoint_Y).toString());

                if((x >= cx - 20 && x <= cx +20) && (y >= cy - 20 && y <= cy +20)){
                    mDecidePointList.get(i).put(tag_isTouch, true);
                }
                if(!(boolean) mDecidePointList.get(i).get(tag_isTouch)) isTouch_all = false;
            }
        }
        return isTouch_all;
    }

    private void CreateDecidePoint(){
        if(isDecide){
            for(int i=0; i<DECIDEPOINTCOUNT; i++){
                Map<String,Object> hashMap = new HashMap<String,Object>();
                hashMap.put(tag_DecidePoint_X,RandoRuleInspection_X(Math.random() * mViewWidth));
                hashMap.put(tag_DecidePoint_Y,RandoRuleInspection_Y(Math.random() * mViewHeight));
                hashMap.put(tag_isTouch,false);
                mDecidePointList.add(hashMap);
            }
        }
    }

    private double RandoRuleInspection_X(double x){
        float result;
        if(x<= BORDER){
            result = BORDER;
        }else if(x>= mViewWidth - BORDER){
            result = mViewWidth - BORDER;
        }else{
            result = (float) x;
        }
        return result;
    }

    private double RandoRuleInspection_Y(double y){
        float result;
        if(y<= BORDER){
            result = BORDER;
        }else if(y>= mViewHeight - BORDER){
            result = mViewHeight - BORDER;
        }else{
            result = (float) y;
        }
        return result;
    }
}
