package pl.edu.pwr.s241926.snake2020;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawGame extends View
{
    private Paint p;
    private int xCor=10, yCor=10;
    RepaintThread repaint = new RepaintThread();
    Thread t1 = new Thread(repaint);
    AllComponentsController controller;
    public DrawGame(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
        controller = new AllComponentsController(); setImages();
        p=new Paint(Paint.ANTI_ALIAS_FLAG);
        t1.start();
    }
    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        controller.drawGameComponents(canvas,p,getWidth(),getHeight());
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        xCor++;yCor++;
        return true;
    }
    class RepaintThread implements Runnable
    {
        private volatile boolean running;
        @Override
        public void run()
        {
            running = true;
            while (running)
            {
                try
                {
                    Thread.sleep(25);
                    invalidate();
                }
                catch (InterruptedException e)
                {e.printStackTrace();}
            }
        }
        void stopme()
        {
            running = false;
        }
    }
    public void setImages()
    {
        Bitmap image_background = BitmapFactory.decodeResource(getResources(),R.drawable.tlo);
        Bitmap leftBorder = BitmapFactory.decodeResource(getResources(),R.drawable.w_prawo);
        Bitmap  rightBorder = BitmapFactory.decodeResource(getResources(),R.drawable.w_lewo);
        Bitmap  upBorder = BitmapFactory.decodeResource(getResources(),R.drawable.w_dol);
        Bitmap  downBorder = BitmapFactory.decodeResource(getResources(),R.drawable.w_gore);
        Bitmap  inTheCorner = BitmapFactory.decodeResource(getResources(),R.drawable.jablko);
        Bitmap  imageSnakeHead = BitmapFactory.decodeResource(getResources(),R.drawable.cialo);
        Bitmap  imageSnakeBody = BitmapFactory.decodeResource(getResources(),R.drawable.cialo);
        Bitmap  imageFruit = BitmapFactory.decodeResource(getResources(),R.drawable.jablko);
        controller.setPictures(image_background, leftBorder,rightBorder,upBorder,downBorder,inTheCorner,imageSnakeHead, imageSnakeBody, imageFruit);
    }
}
