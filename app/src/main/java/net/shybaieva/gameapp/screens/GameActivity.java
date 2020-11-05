package net.shybaieva.gameapp.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import net.shybaieva.gameapp.R;
import net.shybaieva.gameapp.Game.AppConstans;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton startGameBtn;
    boolean isClicked = false;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game);


        init();

        AppConstans.init(this.getApplicationContext());

        startGameBtn.setOnClickListener(this);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }

    private void init (){
        startGameBtn = findViewById(R.id.startGameBtn);
        mediaPlayer = MediaPlayer.create(this, R.raw.back_music);
        mediaPlayer.start();
    }



    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.startGameBtn){
            isClicked = true;
            Log.i("Meow", "clicked ");
            Intent i = new Intent(this, MainGameActivity.class);
            startActivity(i);
            finish();
        }

    }
}