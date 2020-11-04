package net.shybaieva.gameapp.Game;

import android.graphics.Canvas;

import java.util.Random;

public class Food {
    private int foodX, foodY;
    int moveLine;

    public Food() {
        foodX = AppConstans.screenWidth;
        foodY = 3*AppConstans.lineHeight;
    }

    public int getFoodX() {
        return foodX;
    }

    public void setFoodX(int foodX) {
        this.foodX = foodX - AppConstans.speed;
    }

    public int getFoodY() {
        return foodY;
    }

    public void setFoodY(int moveLine) {
        this.foodY = getRandomLine()*AppConstans.lineHeight;
    }


    public void setMoveLine(int moveLine) {
        this.moveLine = moveLine;
    }

    public int getRandomLine(){
        Random random = new Random();
        return random.nextInt(4);
    }

    public void draw (Canvas canvas){
        canvas.drawBitmap(AppConstans.getBitMapBank().getFood(), foodX, foodY, null);
        setFoodX( getFoodX());
        if(foodX<=AppConstans.gameBorders){
            setFoodY(0);
            setFoodX(AppConstans.screenWidth);
            setFoodY(getRandomLine());
            getFoodY();
            AppConstans.speed++;
            AppConstans.currentScore+=10;
        }
    }
}
