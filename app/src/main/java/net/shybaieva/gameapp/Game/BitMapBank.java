package net.shybaieva.gameapp.Game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import net.shybaieva.gameapp.R;

public class BitMapBank {

    Bitmap background;
    Bitmap [] dragon;
    Bitmap pumpkin;
    Bitmap food;

    public BitMapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background_game);
        background = scaleImg(background);

        pumpkin = BitmapFactory.decodeResource(res, R.drawable.pumpkin);
        food = BitmapFactory.decodeResource(res, R.drawable.food);

        dragon = new Bitmap[4];

        dragon[0] = BitmapFactory.decodeResource(res, R.drawable.move_straight1);
        dragon[1] = BitmapFactory.decodeResource(res, R.drawable.move_straight2);
        dragon[2] = BitmapFactory.decodeResource(res, R.drawable.move_straight3);
        dragon[3] = BitmapFactory.decodeResource(res, R.drawable.move_straight4);

    }

    public Bitmap getDragon(int move){
        return dragon[move];
    }

    public int getDragonWidth(){
        return dragon[0].getWidth();
    }

    public int getDragonHeight(){
        return dragon[0].getHeight();
    }

    public Bitmap getPumpkin(){return pumpkin;}

    public int getPumpkinWidth(){
        return pumpkin.getWidth();
    }

    public int getFoodWidth(){
        return food.getWidth();
    }

    public int getPumpkinHeight(){
        return pumpkin.getHeight();
    }

    public Bitmap getFood() {
        return food;
    }


    public void setFood(Bitmap food) {
        this.food = food;
    }

    public  Bitmap getBackground(){
        return background;
    }

    public int getBackgroundWidth(){
        return  background.getWidth();
    }

    public int getBackgroundHeight(){
        return background.getHeight();
    }

    public Bitmap scaleImg(Bitmap bitmap){
        float imgLoop = getBackgroundWidth() / getBackgroundHeight() - 3;
        int backgroundScaleWidth = (int) imgLoop * AppConstans.screenWidth;

        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstans.screenHigh, false);
    }
}
