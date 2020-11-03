package net.shybaieva.gameapp.Game;

import android.graphics.Canvas;
import android.os.Handler;

public class GameEngine {

    BackgroundImage backgroundImage;
    Drago dragon;
    Pumpkin pumpkin;
    Handler handler;
    Runnable runnable;
    static int gameState;

    public GameEngine() {
        backgroundImage = new BackgroundImage();
        dragon = new Drago();
        //pumpkin = new Pumpkin();
        pumpkin  = new Pumpkin();
        gameState = 0; //Not started yet
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
        if(dragon.getDragonY() + AppConstans.gameBorders< (AppConstans.screenHigh - AppConstans.gameBorders)) {
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

    public void drawPumpkins(Canvas canvas){
            canvas.drawBitmap(AppConstans.getBitMapBank().getPumpkin(), pumpkin.getPumpkinX(), pumpkin.getPumpkinY(), null);
            pumpkin.setPumpkinX(pumpkin.getPumpkinX()-25);


    }
}
