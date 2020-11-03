package net.shybaieva.gameapp.Game;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread{

    SurfaceHolder surfaceHolder;
    boolean isRunning;
    long startTime, loopTime, loopDelay =50;

    final String LOG_TAG = "MY_LOG_TAG";

    public GameThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
    }
    boolean isPumpkinOnTheScreen = false;
    @Override
    public void run() {
        while (isRunning){
            startTime = SystemClock.uptimeMillis();
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if(canvas!=null){
                synchronized (surfaceHolder){
                    AppConstans.getGameEngine().updateAndDrawBackgroundImage(canvas);
                    AppConstans.getGameEngine().drawDragon(canvas);
                    AppConstans.getGameEngine().drawPumpkins(canvas);
                    }
                    surfaceHolder.unlockCanvasAndPost(canvas);

                }
            }

            loopTime = SystemClock.uptimeMillis() - startTime;

            if(loopTime<loopDelay){
                try{
                    Thread.sleep(loopDelay-loopTime);
                }catch (Exception e){ Log.i(LOG_TAG, e.getMessage());}
            }
        }



    public boolean isRunning(){
        return isRunning;
    }

    public void setIsRunning(boolean state){
        isRunning = state;
    }
}
