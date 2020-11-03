package net.shybaieva.gameapp.Game;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstans {

    static BitMapBank bitMapBank;
    static GameEngine gameEngine;
    static int gameBorders = 120;
    static int screenWidth, screenHigh, gravity;


    public static void init(Context context){
        setScreenSize(context);
        bitMapBank = new BitMapBank(context.getResources());
        gameEngine = new GameEngine();
        gravity = 30;
    }

    public static BitMapBank getBitMapBank(){
        return bitMapBank;
    }

    public static GameEngine getGameEngine(){
        return gameEngine;
    }

    private static void setScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display =wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        int width = metrics.widthPixels;
        int height =metrics.heightPixels;

        AppConstans.screenWidth  = width;
        AppConstans.screenHigh = height;

    }



}
