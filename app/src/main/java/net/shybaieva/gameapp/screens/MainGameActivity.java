package net.shybaieva.gameapp.screens;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import net.shybaieva.gameapp.Game.GameView;

public class MainGameActivity extends Activity {

    GameView gameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);

    }
}
