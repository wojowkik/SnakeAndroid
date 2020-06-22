package pl.edu.pwr.s241926.snake2020;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Snake
{
    private Bitmap imageSnakeHead, imageSnakeBody, imageFruit;
    private int width=1000, height=1000;
    private SnakeCalculations calc;
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    Snake(int pictureSize)
    {
        calc = new SnakeCalculations(pictureSize);
    }
    void setBoardSize(int width, int height)
    {
        this.width=width; this.height=height;
    }

    void setPictures(Bitmap imageSnakeHead,Bitmap imageSnakeBody,Bitmap imageFruit)
    {
        this.imageSnakeHead=imageSnakeHead; this.imageSnakeBody=imageSnakeBody; this.imageFruit=imageFruit;
    }
    void drawSnake(Canvas canvas, Paint p)
    {
        calc.setBoardSize(width,height);
        canvas.drawBitmap(imageFruit,(calc.getxFruit()*calc.getPictureSize()),(calc.getyFruit()*calc.getPictureSize()),p);//sprawdzic czy this tez ciala zamiast p
        for (int i=2;i<=calc.getSnakeSize();i++)
        {
            canvas.drawBitmap(imageSnakeBody,(calc.snakeBody.get(i).x*calc.getPictureSize()),(calc.snakeBody.get(i).y*calc.getPictureSize()),p);///Dodać gettery
        }
        canvas.drawBitmap(imageSnakeHead,(calc.getxHeadPosition()*calc.getPictureSize()),(calc.getyHeadPosition()*calc.getPictureSize()),p);
    }
    void changeDirection(int controlCode){calc.changeDirection(controlCode);}
    int getSnakeSize() {return calc.getSnakeSize();}
    boolean gameOver() {return calc.isGameOver(); }

}
