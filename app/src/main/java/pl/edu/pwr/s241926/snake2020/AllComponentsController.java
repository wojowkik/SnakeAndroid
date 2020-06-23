package pl.edu.pwr.s241926.snake2020;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class AllComponentsController
{
    private Board map;
    private Snake snake;
    private final int pictureSize=40;
    private Bitmap upControl, downControl, leftControl, rightControl;
    AllComponentsController()
    {
        map = new Board(pictureSize);
        snake = new Snake(pictureSize);
    }
    void drawGameComponents(Canvas canvas, Paint p, int width, int height)
    {
        p.setColor(Color.BLACK);
        canvas.drawRect(0,0,width,height,p);
        canvas.drawBitmap(leftControl,(width/2)-240,height-260,p);
        canvas.drawBitmap(rightControl,(width/2)+80,height-260,p);
        canvas.drawBitmap(downControl,(width/2)-80,height-160,p);
        canvas.drawBitmap(upControl,(width/2)-80,height-360,p);//wyrysowanie przyciskow kontroli
        width=width/pictureSize;    width=width*pictureSize;
        height=(height-160)/pictureSize;  height=height*pictureSize;//wyrównywanie krawedzi
        p.setColor(Color.RED); p.setTextSize(40);
        canvas.drawText("Wynik: "+snake.getSnakeSize(), width-250, height-100,p);
        map.drawPlayground(canvas,p, width,height-160);
        snake.setBoardSize(width,height-160);
        snake.drawSnake(canvas,p);

    }
    void setPictures(Bitmap image_background, Bitmap leftBorder, Bitmap rightBorder, Bitmap upBorder,
                     Bitmap downBorder, Bitmap inTheCorner, Bitmap imageSnakeHead, Bitmap imageSnakeBody, Bitmap imageFruit,
                     Bitmap upControl,Bitmap downControl,Bitmap leftControl,Bitmap rightControl)
    {
        map.setPicures(image_background, leftBorder,rightBorder,upBorder,downBorder,inTheCorner);
        snake.setPictures(imageSnakeHead,imageSnakeBody,imageFruit);
        this.upControl=upControl; this.downControl=downControl;this.leftControl=leftControl; this.rightControl=rightControl;
    }
    void snakeControl(int controlCode)
    {
        snake.changeDirection(controlCode);
    }
}
