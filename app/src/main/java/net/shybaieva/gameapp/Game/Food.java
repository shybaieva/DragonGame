package net.shybaieva.gameapp.Game;

import android.graphics.Canvas;

import java.util.Random;

public class Food {
    private int foodX, foodY;

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

    public int getRandomLine(){
        Random random = new Random();
        return random.nextInt(4);
    }

    public void draw (Canvas canvas){
        canvas.drawBitmap(AppConstans.getBitMapBank().getFood(), foodX, foodY, null);
        setFoodX( getFoodX());
        if(foodX+AppConstans.getBitMapBank().getFoodWidth()<=0){
            setFoodY(0);
            setFoodX(AppConstans.screenWidth);
            setFoodY(getRandomLine());
            getFoodY();
            AppConstans.speed++;
        }
        else AppConstans.currentScore+=10;
    }
}
