package net.shybaieva.gameapp.Game;

import android.graphics.Canvas;
import android.util.Log;
import java.util.Random;

public class Pumpkin {
    private float pumpkinX, pumpkinY;

    int moveLine;
    int amountOfLines = 6;
    float minSpeed = (float) 0.1;
    float maxSpeed = (float) 0.5;

    float speed;

    float cellHeight = 1080;

    public Pumpkin(){
        Random random = new Random();
        moveLine= random.nextInt(amountOfLines);
        Log.i("Meow", String.valueOf(moveLine + "PUMPKIN"));
        pumpkinY =moveLine*cellHeight;
        pumpkinX = AppConstans.screenWidth-AppConstans.gameBorders;
        speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat();
    }

    public float getPumpkinX() {
        return pumpkinX;
    }

    public void setPumpkinX(float pumpkinX) {
        this.pumpkinX = pumpkinX -10;
    }

    public float getPumpkinY() {
        return pumpkinY;
    }

    public void setPumpkinY() {
        this.pumpkinY = getRandomLine();
    }

    public int getRandomLine(){
        Random random = new Random();
        return random.nextInt(6);
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(AppConstans.getBitMapBank().getPumpkin(), getPumpkinX(), getPumpkinY(), null);
        setPumpkinX(getPumpkinX());
        if(getPumpkinX()<AppConstans.gameBorders - 70){
            setPumpkinX(AppConstans.screenWidth);
            setPumpkinY();
        }
    }
}
