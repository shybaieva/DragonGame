package net.shybaieva.gameapp.Game;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

import java.util.ArrayList;

public class GameThread extends Thread{

    SurfaceHolder surfaceHolder;
    boolean isRunning;
    static boolean gameState;
    long startTime, loopTime, loopDelay =50;
    Pumpkin pumpkin = new Pumpkin();
    Drago drago = new  Drago();
    BackgroundImage backgroundImage = new BackgroundImage();
    ArrayList<Pumpkin> pumpkins = new ArrayList<>();

    final String LOG_TAG = "MY_LOG_TAG";

    public GameThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
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
                    pumpkin.draw(canvas);
                    gameState = checkCollision();
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

        Log.i("Meow", String.valueOf(drago.getDragonX())+" DRAGON");
        Log.i("Meow", String.valueOf(pumpkin.getPumpkinX()) +" PUMPKIN");

            if(drago.getDragonY()==pumpkin.getPumpkinY() && drago.getDragonX()+drago.getFrameWidth()==pumpkin.getPumpkinX()){
                gameState = false;
                isRunning=false;
                Log.i("Meow", String.valueOf(drago.getMoveLine())+" DRAGON");
                Log.i("Meow", String.valueOf(pumpkin.getMoveLine()) +" PUMPKIN");
                Log.i("Meow", "DONE");
                // TODO добавить анимацию взрыва
                return false;
        }
            return true;
    }

    public boolean isRunning(){
        return isRunning;
    }

    public void setIsRunning(boolean state){
        isRunning = state;
    }
}
