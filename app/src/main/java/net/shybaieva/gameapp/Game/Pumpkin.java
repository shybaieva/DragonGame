package net.shybaieva.gameapp.Game;

import android.graphics.Canvas;
import android.util.Log;
import java.util.Random;

public class Pumpkin {
    private int pumpkinX, pumpkinY;

    int countPumpkinOnScreen=0;
    public Pumpkin(){
        Log.i("Meow", String.valueOf(pumpkinY + "PUMPKIN y"));
        pumpkinY=2*AppConstans.lineHeight;
        this.pumpkinX=AppConstans.screenWidth;
    }


    public int getPumpkinX() {
        return pumpkinX;
    }


    public void setPumpkinX(int pumpkinX) {
        this.pumpkinX = pumpkinX - AppConstans.speed;
    }

    public int getPumpkinY() {
        return pumpkinY;
    }

    public void setPumpkinY(int y) {
        this.pumpkinY =y*AppConstans.lineHeight;
    }

    public int getRandomLine(){
        Random random = new Random();
        return random.nextInt(4);
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(AppConstans.getBitMapBank().getPumpkin(), pumpkinX, pumpkinY , null);
        setPumpkinX( getPumpkinX());
        countPumpkinOnScreen++;
        if(pumpkinX+AppConstans.getBitMapBank().getPumpkinWidth()<=0){
            setPumpkinY(0);
            setPumpkinX(AppConstans.screenWidth);
            setPumpkinY(getRandomLine());
            getPumpkinY();
        }
    }
}
