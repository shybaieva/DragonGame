package net.shybaieva.gameapp.Game;

import android.graphics.Canvas;
import android.os.Handler;

import java.util.ArrayList;

public class GameEngine {

    BackgroundImage backgroundImage;
    Drago dragon;
    Pumpkin pumpkin;
    static boolean gameState;

    public GameEngine() {
        backgroundImage = new BackgroundImage();
        dragon = new Drago();
        pumpkin  = new Pumpkin();
        //pumpkinArrayList = new ArrayList<>();
        gameState = true; //Not started yet
        // 1 - game active
        // 2 - game over
    }

    public void updateAndDrawBackgroundImage(Canvas canvas){
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if(backgroundImage.getX()< -AppConstans.getBitMapBank().getBackgroundWidth()){
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstans.getBitMapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);

        if(backgroundImage.getX() < -(AppConstans.getBitMapBank().getBackgroundWidth() - AppConstans.screenWidth)){
            canvas.drawBitmap(AppConstans.getBitMapBank().getBackground(), backgroundImage.getX()+
                    AppConstans.getBitMapBank().getBackgroundWidth(),
                    backgroundImage.getY(), null);
        }

    }

    public void drawDragon(Canvas canvas){
        //borders
        if(dragon.getDragonY() + 20< (AppConstans.screenHigh - 20)) {
            dragon.setVelocity(AppConstans.gravity);
            dragon.setDragonY(dragon.getVelocity());
        }

        int currentFrame = dragon.getCurrentFrame();
        canvas.drawBitmap(AppConstans.getBitMapBank().getDragon(currentFrame),
                dragon.getDragonX(), dragon.getDragonY(), null);
        currentFrame++;

        if(currentFrame > dragon.getMaxFrame()){
            currentFrame = 0;
        }

        dragon.setCurrentFrame(currentFrame);
    }

}
