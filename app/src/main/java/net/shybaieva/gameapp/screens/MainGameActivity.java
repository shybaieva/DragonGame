package net.shybaieva.gameapp.screens;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import net.shybaieva.gameapp.Game.AppConstans;
import net.shybaieva.gameapp.Game.GameThread;
import net.shybaieva.gameapp.Game.GameView;

public class MainGameActivity extends Activity {

    GameView gameView;
    public int SCREEN_WIDTH;
    public int SCREEN_HEIGHT;
    GameThread gameThread;
    public int maxScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Display display = getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);
        SCREEN_WIDTH = size.x;
        SCREEN_HEIGHT = size.y;

        gameView = new GameView(this);
        setContentView(gameView);


    }

}
