package net.shybaieva.gameapp.Game;

import android.graphics.Canvas;
import android.os.Handler;

import java.util.ArrayList;

public class GameEngine {

    BackgroundImage backgroundImage;
    static boolean gameState;

    public GameEngine() {
        backgroundImage = new BackgroundImage();
        gameState = true; //Not started yet
        // 1 - game active
        // 2 - game over
    }


}
