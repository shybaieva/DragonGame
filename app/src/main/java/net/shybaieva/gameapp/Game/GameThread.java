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
    Pumpkin pumpkin = new Pumpkin();
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
                    pumpkin.draw(canvas);
                    gameState = checkCollision();
                    setScore();

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
       // Log.i("Meow", String.valueOf(drago.getDragonX()) + " DRAGON X");
        //Log.i("Meow", pumpkin.getPumpkinX()+ " PUMPKIN X");

            if( drago.getDragonX()+drago.getFrameWidth()-10>=pumpkin.getPumpkinX()&& drago.getDragonY()==pumpkin.getPumpkinY()){
                gameState = false;
                isRunning=false;
                return false;
        }
            return true;
    }

    public void setScore(){

        /*if(drago.getDragonY()==food.getFoodY() && drago.getDragonX()==food.getFoodX()){
           // appConstans.setCurrentScore(appConstans.getCurrentScore()+10);
            appConstans.setCurrentScore(appConstans.getCurrentScore()+10);
            Log.i("Meow", appConstans.getCurrentScore()+ " PUMPKIN X");

        }*/
    }

    public boolean isRunning(){
        return isRunning;
    }

    public void setIsRunning(boolean state){
        isRunning = state;
    }
}
