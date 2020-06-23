package pl.edu.pwr.s241926.snake2020;

import java.util.ArrayList;
import java.util.Random;

public class SnakeCalculations
{
    ArrayList<SnakeBody> snakeBody = new ArrayList<>(5);
    private int width=200, height=200, pictureSize, xHeadPosition, yHeadPosition, direction, xFruit, yFruit,snakeSize=3;
    private boolean gameOver=false, snakeCanMove=true;
    private Random randGenerator = new Random();
    private Watek1 w = new Watek1();
    private Thread t1 = new Thread(w);
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    SnakeCalculations(int pictureSize){
        this.pictureSize=pictureSize;
        direction=1; xHeadPosition=1; yHeadPosition=1;
        for(int i=0 ; i<5 ; i++)
        {
            snakeBody.add(new SnakeBody(-2,-2));//sprite inicjowane na początku rysowane poza obszarem ekranu
        }
        randFruit();
        t1.start();
    }
    void setBoardSize(int width, int height){
        this.width=width; this.height=height;
    }
    boolean isGameOver(){
        return gameOver;
    }
    private void increaseSize(){
        snakeSize+=1;}
    private void randFruit(){
        int zmienna; int licznik=1;
        while (licznik>0)
        {
            zmienna=(width/pictureSize)-2;
            xFruit=(randGenerator.nextInt(zmienna))+1;
            zmienna=(height/pictureSize)-2;
            yFruit=(randGenerator.nextInt(zmienna))+1;
            ////////////////////////////////////////////
            for(int i=0 ; i<snakeSize ; i++)
            {
                if(snakeBody.get(i).x==xFruit && snakeBody.get(i).y==yFruit) // zabezpieczenie przed wylosowaniem owocu na wezu
                {
                    licznik+=1; System.out.println("RERAND");
                }
            }
            licznik-=1;
        }
    }
    void changeDirection(int direction){
        if((direction+2)%4 != this.direction && snakeCanMove)
        {
            this.direction=direction;
        }
        snakeCanMove=false;
    }
    private boolean checkSnake(){
        for(int i=snakeSize-3 ; i>1 ; i--)
        {
            if(snakeBody.get(i).x==xHeadPosition && snakeBody.get(i).y==yHeadPosition)
            {
                System.out.println("Game Over - Snake Hit"); return true;
            }
        }
        return false;
    }
    private boolean checkBorder(){
        int tmp;
        tmp=(width/pictureSize)-1;
        if(xHeadPosition==0 || xHeadPosition==tmp)
        {System.out.println("Game Over - Board Hit");return true;}
        tmp=(height/pictureSize)-1;
        if(yHeadPosition==0 || yHeadPosition==tmp)
        {System.out.println("Game Over - Board Hit");return true;}
        return false;
    }
    private void endGame(){
        gameOver=true;
        w.stopme();
    }
    class Watek1 implements Runnable{
        boolean grow=false;
        private volatile boolean running;
        @Override
        public void run()
        {
            running = true;
            while (running)
            {
                try
                {
                    Thread.sleep(200);
                    if(direction==0){
                        xHeadPosition=xHeadPosition+1;
                        snakeBody.add(new SnakeBody(xHeadPosition,yHeadPosition));
                        if(!grow){
                            snakeBody.remove(0);
                        } else
                            grow=false;
                    }
                    if(direction==1){yHeadPosition=yHeadPosition+1;snakeBody.add(new SnakeBody(xHeadPosition,yHeadPosition));
                        if(!grow){snakeBody.remove(0);}else grow=false;}
                    if(direction==2){xHeadPosition=xHeadPosition-1;snakeBody.add(new SnakeBody(xHeadPosition,yHeadPosition)); if(!grow){snakeBody.remove(0);}else grow=false;}
                    if(direction==3){yHeadPosition=yHeadPosition-1;snakeBody.add(new SnakeBody(xHeadPosition,yHeadPosition)); if(!grow){snakeBody.remove(0);}else grow=false;}
                    if(xHeadPosition==xFruit && yHeadPosition==yFruit){increaseSize();randFruit();grow=true;}
                    snakeCanMove=true;
                    if(checkBorder() || checkSnake()){endGame();}
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
        void stopme(){
            running = false;
        }
    }
    int getPictureSize(){return pictureSize;}
    int getxHeadPosition(){return xHeadPosition;}
    int getyHeadPosition(){return yHeadPosition;}
    int getxFruit(){return xFruit;}
    int getyFruit(){return yFruit;}
    int getSnakeSize(){return snakeSize;}
}
