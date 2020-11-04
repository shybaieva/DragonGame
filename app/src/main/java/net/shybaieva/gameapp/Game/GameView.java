package net.shybaieva.gameapp.Game;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import net.shybaieva.gameapp.Game.Pumpkin;
import androidx.annotation.NonNull;

import java.util.ArrayList;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

     GameThread gameThread;
    public static float unitW = 0; // пикселей в юните по горизонтали
    public static float unitH = 0;
     final String LOG_TAG = "MY_LOG_TAG";

    public GameView(Context context) {
        super(context);
        initView();
    }


    void initView(){
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

        setFocusable(true);
        gameThread = new GameThread(holder);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        if(!gameThread.isRunning()){
            gameThread = new GameThread(surfaceHolder);
            gameThread.start();
        }
        else{
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        if(gameThread.isRunning()){
            gameThread.setIsRunning(false);
            boolean retryGameThread = true;
            while(retryGameThread){
                try{
                    gameThread.join();
                    retryGameThread = false;
                }catch (Exception e){
                    Log.i(LOG_TAG, e.getMessage());
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // int action = event.getAction();
        if(event.getAction() == MotionEvent.ACTION_UP){
            int moveLine = (int) (event.getY()/180);
            gameThread.drago.setVelocity(moveLine*180);
            //drago.setVelocity( );


            //AppConstans.getGameEngine().dragon.setDragonY((int) event.getY());
            //  Log.i("Meow", String.valueOf(AppConstans.getGameEngine().dragon.getMoveLine())+ "DRAGON");
        }
        return true;
    }

}
