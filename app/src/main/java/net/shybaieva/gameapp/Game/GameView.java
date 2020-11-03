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
     final String LOG_TAG = "MY_LOG_TAG";
     private ArrayList<Pumpkin> pumpkins = new ArrayList<>();

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
            GameEngine.gameState=1;
            AppConstans.getGameEngine().dragon.setVelocity(AppConstans.gravity= (int) event.getY());

            Log.i("Meow", String.valueOf(event.getY()) + "Touch");
        }
        return true;
    }

}
