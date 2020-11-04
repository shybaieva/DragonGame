package net.shybaieva.gameapp.Game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

import java.util.ArrayList;

public class GameThread extends Thread{

    SurfaceHolder surfaceHolder;
    Paint paint = new Paint();
    boolean isRunning;
    static boolean gameState;
    long startTime, loopTime, loopDelay =50;
    Pumpkin pumpkin1 = new Pumpkin();
    Pumpkin pumpkin2 = new Pumpkin();
    Pumpkin pumpkin3 = new Pumpkin();
    Drago drago = new  Drago();
    Food food = new Food();
    AppConstans appConstans = new AppConstans();
    BackgroundImage backgroundImage = new BackgroundImage();
    boolean isSpeedRaised=false;


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
    }

    @Override
    public void run() {
        while (isRunning){
            startTime = SystemClock.uptimeMillis();
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if(canvas!=null){
                synchronized (surfaceHolder){
                    backgroundImage.updateAndDrawBackgroundImage(canvas);
                    drago.drawDragon(canvas);
                    food.draw(canvas);
                    for (Pumpkin pumpkin:pumpkins
                         ) {
                        pumpkin.draw(canvas);

                    }
                    gameState = checkCollision();
                    setScore();
                    //setSpeed();
                    canvas.drawText("Score: "+ appConstans.getCurrentScore(),
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
            if(drago.getDragonY()==pumpkin.getPumpkinY() && drago.getDragonX()+drago.getFrameWidth()==pumpkin.getPumpkinX()){
                gameState = false;
                isRunning=false;
                return false;
            }
        }

            return true;
    }

   /* public void setSpeed(){
        if(appConstans.currentScore!= 0 && appConstans.getCurrentScore()%15==0){
            isSpeedRaised=true;
            if(isSpeedRaised){
                pumpkin.setSpeed(pumpkin.getSpeed()+3);
                isSpeedRaised=false;
            }
        }
    }*/

    public void setScore(){
        if(drago.getDragonY()==food.getFoodY() && drago.getDragonX()+drago.getFrameWidth()==food.getFoodX()){
            appConstans.setCurrentScore(appConstans.getCurrentScore()+10);

        }
    }

    public boolean isRunning(){
        return isRunning;
    }

    public void setIsRunning(boolean state){
        isRunning = state;
    }
}
