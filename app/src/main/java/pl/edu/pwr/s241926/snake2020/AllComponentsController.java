package pl.edu.pwr.s241926.snake2020;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

class AllComponentsController
{
    private Board map;
    private Snake snake;
    private final int pictureSize=40;
    AllComponentsController()
    {
        map = new Board(pictureSize);
        snake = new Snake(pictureSize);
    }
    void drawGameComponents(Canvas canvas, Paint p, int width, int height)
    {
        map.drawPlayground(canvas,p, width,height);
        snake.setBoardSize(width,height);
        snake.drawSnake(canvas,p);
    }
    void setPictures(Bitmap image_background, Bitmap leftBorder, Bitmap rightBorder, Bitmap upBorder,
                     Bitmap downBorder, Bitmap inTheCorner, Bitmap imageSnakeHead, Bitmap imageSnakeBody, Bitmap imageFruit)
    {
        map.setPicures(image_background, leftBorder,rightBorder,upBorder,downBorder,inTheCorner);
        snake.setPictures(imageSnakeHead,imageSnakeBody,imageFruit);
    }
}
