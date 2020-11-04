package net.shybaieva.gameapp.Game;

import android.graphics.Canvas;

import net.shybaieva.gameapp.Game.AppConstans;

public class Drago {

    private int dragonX, dragonY, currentFrame, velocity;
    public static int maxFrame;
    private int moveLine;
    private static int frameWidth;

    public Drago(){
        dragonX =100;
        this.dragonY =360;
        frameWidth = AppConstans.getBitMapBank().getDragonWidth();
        currentFrame=0;
        maxFrame=3;
        velocity=0;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getMoveLine() {
        return moveLine;
    }

    public void setMoveLine(int moveLine) {
        this.moveLine = moveLine;
    }

    public int getCurrentFrame(){
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrameNumber){
        this.currentFrame = currentFrameNumber;
    }

    public int getDragonX(){
        return dragonX;
    }

    public void setDragonX(int dragonNewX){
        this.dragonX = dragonNewX;
    }

    public int getDragonY(){
        return dragonY;
    }

    public void setDragonY(int dragonNewY){
        this.dragonY = dragonNewY;
    }

    public int getMaxFrame(){
        return maxFrame;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void drawDragon(Canvas canvas){
        //borders
        if(getDragonY() + 20< (AppConstans.screenHigh - 20)) {
            setDragonY(getVelocity());
        }

        int currentFrame = getCurrentFrame();
        canvas.drawBitmap(AppConstans.getBitMapBank().getDragon(currentFrame),
                getDragonX(), getDragonY(), null);
        currentFrame++;

        if(currentFrame > getMaxFrame()){
            currentFrame = 0;
        }

        setCurrentFrame(currentFrame);
    }

}
