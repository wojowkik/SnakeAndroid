package pl.edu.pwr.s241926.snake2020;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
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
    public DrawGame(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
        p=new Paint(Paint.ANTI_ALIAS_FLAG);
        t1.start();
    }
    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        p.setColor(Color.RED);
        canvas.drawRect(xCor,yCor,getWidth(),getHeight(),p);
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
}
