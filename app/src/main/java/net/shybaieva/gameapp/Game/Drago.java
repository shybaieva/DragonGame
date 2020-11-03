package net.shybaieva.gameapp.Game;

import net.shybaieva.gameapp.Game.AppConstans;

public class Drago {

    private int dragonX, dragonY, currentFrame, velocity;
    public static int maxFrame;
   // public static int frameHeight;

    public Drago(){
        dragonX = AppConstans.gameBorders;
        dragonY = AppConstans.screenHigh/2 - AppConstans.getBitMapBank().getDragonHeight()/2;
        currentFrame=0;
        maxFrame=3;
        velocity=0;
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

}
