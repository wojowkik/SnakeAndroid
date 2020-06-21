package pl.edu.pwr.s241926.snake2020;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

class AllComponentsController
{
    private Board map;
    private final int pictureSize=40;
    AllComponentsController()
    {
        map = new Board(pictureSize);
    }
    void drawGameComponents(Canvas canvas, Paint p, int width, int height)
    {
        map.drawPlayground(canvas,p, width,height);
    }
    void setPictures(Bitmap image_background, Bitmap leftBorder, Bitmap rightBorder,
                     Bitmap upBorder, Bitmap downBorder, Bitmap inTheCorner)
    {
        map.setPicures(image_background, leftBorder,rightBorder,upBorder,downBorder,inTheCorner);

    }
}
