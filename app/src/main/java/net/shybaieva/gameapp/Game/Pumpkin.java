package net.shybaieva.gameapp.Game;

import android.graphics.Canvas;
import android.util.Log;
import java.util.Random;

public class Pumpkin {
    private int pumpkinX, pumpkinY=360;
    int moveLine;

    public Pumpkin(){
        Log.i("Meow", String.valueOf(pumpkinY + "PUMPKIN y"));
        pumpkinX=AppConstans.screenWidth;
    }

    public int getPumpkinX() {
        return pumpkinX;
    }

    public void setPumpkinX(int pumpkinX) {
        this.pumpkinX = pumpkinX -10;
    }

    public int getPumpkinY() {
        return pumpkinY;
    }

    public void setPumpkinY(int y) {
        this.pumpkinY =y*180;
    }

    public int getRandomLine(){
        Random random = new Random();
        return random.nextInt(4);
    }

    public int getMoveLine() {
        return moveLine;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(AppConstans.getBitMapBank().getPumpkin(), pumpkinX, pumpkinY , null);
        setPumpkinX( getPumpkinX());
        if(pumpkinX<=AppConstans.gameBorders){
            setPumpkinY(0);
            setPumpkinX(AppConstans.screenWidth);
            setPumpkinY(getRandomLine());
            getPumpkinY();
        }
    }
}
