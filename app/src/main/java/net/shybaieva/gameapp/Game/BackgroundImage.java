package net.shybaieva.gameapp.Game;

import android.graphics.Canvas;

public class BackgroundImage {

    private int backgroundX, backgroundY, backgroundVelocity;

    public BackgroundImage() {
        backgroundX = 0;
        backgroundY = 0;
        backgroundVelocity = 5;
    }

    public int getX(){
        return backgroundX;
    }

    public void setX(int x){
        this.backgroundX = x;
    }

    public int getY(){
        return backgroundY;
    }

    public void setY(int y){
        this.backgroundY = y;
    }

    public int getVelocity(){
        return backgroundVelocity;
    }

    public void updateAndDrawBackgroundImage(Canvas canvas){
        setX(getX() - getVelocity());
        if(getX()< -AppConstans.getBitMapBank().getBackgroundWidth()){
            setX(0);
        }
        canvas.drawBitmap(AppConstans.getBitMapBank().getBackground(), getX(), getY(), null);
        if(getX() < -(AppConstans.getBitMapBank().getBackgroundWidth() - AppConstans.screenWidth)){
            canvas.drawBitmap(AppConstans.getBitMapBank().getBackground(), getX()+
                            AppConstans.getBitMapBank().getBackgroundWidth(),
                    getY(), null);
        }
    }
}