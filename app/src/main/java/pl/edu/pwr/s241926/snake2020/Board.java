package pl.edu.pwr.s241926.snake2020;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

class Board
{
    private int  pictureSize;
    private Bitmap imageBackground, leftBorder,rightBorder,upBorder,downBorder,inTheCorner;
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    Board(int pictureSize)
    {
        this.pictureSize=pictureSize;
    }
    void setPicures(Bitmap image_background,Bitmap leftBorder,Bitmap rightBorder,Bitmap upBorder,Bitmap downBorder,Bitmap inTheCorner)
    {
        this.imageBackground=image_background;
        this.leftBorder=leftBorder;
        this.rightBorder=rightBorder;
        this.upBorder=upBorder;
        this.downBorder=downBorder;
        this.inTheCorner=inTheCorner;
    }
    void drawPlayground(Canvas canvas, Paint p, int width, int height)
    {
        for(int i=pictureSize ; i<width-pictureSize ; i+=pictureSize)//for(int i=30 ; i<480-30 ; i+=30)  //wysokosc
        {
            for(int j=pictureSize ; j<height-pictureSize ; j+=pictureSize) //for(int j=30 ; j<480-30 ; j+=30)
            {
                canvas.drawBitmap(imageBackground,i,j,p); // szerokosc // plansza
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////BORDER
        for(int i=0 ; i<width ; i+=pictureSize)             {canvas.drawBitmap(upBorder,i,0,p);}
        for(int i=0 ; i<width ; i+=pictureSize)             {canvas.drawBitmap(downBorder,i,height-pictureSize,p);}
        for(int i=0 ; i<height-pictureSize ; i+=pictureSize){canvas.drawBitmap(leftBorder,0,i,p);}
        for(int i=0 ; i<height-pictureSize ; i+=pictureSize){canvas.drawBitmap(rightBorder,width-pictureSize,i,p);}
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////CORNER
        canvas.drawBitmap(inTheCorner,0,0,p);
        canvas.drawBitmap(inTheCorner,width-pictureSize,0,p);
        canvas.drawBitmap(inTheCorner,0,height-pictureSize,p);
        canvas.drawBitmap(inTheCorner,width-pictureSize,height-pictureSize,p);
    }
}
