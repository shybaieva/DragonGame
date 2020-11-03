package net.shybaieva.gameapp.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import net.shybaieva.gameapp.R;
import net.shybaieva.gameapp.Game.AppConstans;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton startGameBtn;
    boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        init();

        AppConstans.init(this.getApplicationContext());

        startGameBtn.setOnClickListener(this);

    }

    private void init (){
        startGameBtn = findViewById(R.id.startGameBtn);
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