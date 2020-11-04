package net.shybaieva.gameapp.Game;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import net.shybaieva.gameapp.screens.MainGameActivity;

public class AppConstans {

    static BitMapBank bitMapBank;
    static int cell = 300;
    static int gameBorders;
    static int screenWidth, screenHigh, gravity;

    public static void init(Context context){
        setScreenSize(context);
        bitMapBank = new BitMapBank(context.getResources());
        gameBorders=bitMapBank.getDragonWidth();
        gravity = 100;
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

}
