package net.shybaieva.gameapp.Game;

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


}