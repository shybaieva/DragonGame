package net.shybaieva.gameapp.Game;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import net.shybaieva.gameapp.R;

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

    @SuppressLint("ResourceAsColor")
    public void endGameBackground(Canvas canvas, int score){
        Paint paint =new Paint();
        Paint paint1 = new Paint();
        paint.setTextSize(100);
        paint.getShader();
        paint.setFakeBoldText(true);
        paint.setColor(Color.parseColor("#EF6C00"));

        paint1.setColor(Color.WHITE);
        paint1.getShader();
        paint1.setTextSize(60);
        paint1.setFakeBoldText(true);

        canvas.drawBitmap(AppConstans.getBitMapBank().getBackground(), 0, 0, null);
        canvas.drawText("Game over\n",AppConstans.screenWidth/2-250, AppConstans.screenHigh/2, paint);
        canvas.drawText("Your score: "+score, AppConstans.screenWidth/2-300, AppConstans.screenHigh/2-200, paint);
        canvas.drawText("Your high score: "+score, AppConstans.screenWidth/2-400, AppConstans.screenHigh/2+200, paint);
        canvas.drawText("Tap screen to play again", AppConstans.screenWidth/2-350, AppConstans.screenHigh-100, paint1);
    }
}