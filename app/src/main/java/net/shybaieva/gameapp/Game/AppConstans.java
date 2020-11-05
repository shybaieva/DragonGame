package net.shybaieva.gameapp.Game;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import net.shybaieva.gameapp.screens.MainGameActivity;

public class AppConstans {
    static BitMapBank bitMapBank;
    static int lineHeight;
    static int gameBorders;
    Context context;

    static int currentScore;
    static int speed=10;
    static int screenWidth, screenHigh, gravity;


    public static void init(Context context){
        setScreenSize(context);
        bitMapBank = new BitMapBank(context.getResources());
        gameBorders=bitMapBank.getDragonWidth();
        gravity = 100;
        lineHeight=180;
        currentScore=0;
    }

    public static BitMapBank getBitMapBank(){
        return bitMapBank;
    }

    private static void setScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display =wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        int width = 2068;
        int height =1080;

        AppConstans.screenWidth  = width;
        AppConstans.screenHigh = height;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
