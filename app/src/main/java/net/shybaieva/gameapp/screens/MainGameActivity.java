package net.shybaieva.gameapp.screens;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import net.shybaieva.gameapp.Game.GameView;

public class MainGameActivity extends Activity {

    GameView gameView;
    public int SCREEN_WIDTH;
    public int SCREEN_HEIGHT;

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

        Log.i("Meow", String.valueOf(SCREEN_WIDTH) + "WIDTH SCREEN");
        Log.i("Meow", String.valueOf(SCREEN_HEIGHT) + "HEIGHT SCREEN");
        gameView = new GameView(this);
        setContentView(gameView);

    }


    public int getSCREEN_WIDTH() {
        return SCREEN_WIDTH;
    }

    public int getSCREEN_HEIGHT() {
        return SCREEN_HEIGHT;
    }

}
