package net.shybaieva.gameapp.Game;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

import net.shybaieva.gameapp.screens.EndGameActivity;
import net.shybaieva.gameapp.screens.MainGameActivity;

import java.util.ArrayList;

public class GameThread extends Thread{

    SurfaceHolder surfaceHolder;
    Paint paint = new Paint();
    Canvas canvas;
    boolean isRunning;
    static boolean gameState;
    long startTime, loopTime, loopDelay =250;
    int currentTime=0;
    public int score;
    final int timeForNewElement = 50;
    Pumpkin pumpkin1 = new Pumpkin();
    Pumpkin pumpkin2 = new Pumpkin();
    Pumpkin pumpkin3 = new Pumpkin();
    Drago drago = new  Drago();
    Food food = new Food();
    BackgroundImage backgroundImage = new BackgroundImage();


    ArrayList<Pumpkin> pumpkins = new ArrayList<>();

    final String LOG_TAG = "MY_LOG_TAG";

    public GameThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        paint.setElegantTextHeight(true);

        pumpkins.add(pumpkin1);
        pumpkins.add(pumpkin2);
        pumpkins.add(pumpkin3);
        score=0;
        AppConstans.speed=10;
    }

    @Override
    public void run() {
        while (isRunning){
            startTime = SystemClock.uptimeMillis();
            canvas = surfaceHolder.lockCanvas(null);
            if(canvas!=null){
                synchronized (surfaceHolder){
                    backgroundImage.updateAndDrawBackgroundImage(canvas);
                    drago.drawDragon(canvas);
                    food.draw(canvas);

                    for (Pumpkin pumpkin: pumpkins
                         ) {
                        pumpkin.draw(canvas);
                    }
                    checkIfNewPumpkin();
                    checkCollision();
                    increaseScore();
                    canvas.drawText("Score: "+ score,
                            60,
                            80, paint);
                }
                    surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
            loopTime = SystemClock.uptimeMillis() - startTime;

            if(loopTime<loopDelay) {
                try {
                    Thread.sleep(loopDelay - loopTime);
                } catch (Exception e) {
                    Log.i(LOG_TAG, e.getMessage());
                }
            }
        }

    private boolean checkCollision(){

        for (Pumpkin pumpkin: pumpkins
        ) {
            if( drago.getDragonX()+drago.getFrameWidth()-15>=pumpkin.getPumpkinX()&& drago.getDragonY()==pumpkin.getPumpkinY()){
                gameState = false;
                isRunning=false;
                AppConstans.currentScore=score;
                try {
                    sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                backgroundImage.endGameBackground(canvas, score);
                return false;
            }
        }
            return true;
    }



    private void increaseScore(){
            if( drago.getDragonX()+drago.getFrameWidth()-15>=food.getFoodX()&& drago.getDragonY()==food.getFoodY()){
              score+=10;
              AppConstans.speed+=1;
              food.setFoodX(AppConstans.screenWidth);
               Log.i("Meow", String.valueOf(score));
            }
    }

    private void checkIfNewPumpkin(){
        if(currentTime >= timeForNewElement  && pumpkins.size()<=4){
            Pumpkin pumpkin= new Pumpkin();
            pumpkins.add(pumpkin);
            currentTime = 0;
        }else{
            currentTime ++;
        }
    }

    public boolean isRunning(){
        return isRunning;
    }

    public void setIsRunning(boolean state){
        isRunning = state;
    }
}
