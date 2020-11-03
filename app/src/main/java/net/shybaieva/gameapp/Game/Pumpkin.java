package net.shybaieva.gameapp.Game;

import android.util.Log;

import java.util.Random;

public class Pumpkin {
    private int pumpkinX, pumpkinY;

    int lineNumber;
    int amountOfLines = AppConstans.screenHigh/AppConstans.getBitMapBank().getPumpkinHeight();

    public Pumpkin(){
        Random rnd = new Random();
        lineNumber= rnd.nextInt(amountOfLines);

        Log.i("Meow", String.valueOf(lineNumber));

        pumpkinY =lineNumber*AppConstans.getBitMapBank().getDragonHeight();
        pumpkinX = AppConstans.screenWidth-AppConstans.gameBorders;
    }

    public int getPumpkinX() {
        return pumpkinX;
    }

    public void setPumpkinX(int pumpkinX) {
        this.pumpkinX = pumpkinX;
    }

    public int getPumpkinY() {
        return pumpkinY;
    }

    public void setPumpkinY(int pumpkinY) {
        this.pumpkinY = pumpkinY;
    }

    public boolean isCollision(){
        if(pumpkinX==AppConstans.getGameEngine().dragon.getDragonX() && pumpkinY==AppConstans.getGameEngine().dragon.getDragonY())
        return true;
        else
            return false;
    }
}
