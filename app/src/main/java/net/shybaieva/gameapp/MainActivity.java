package net.shybaieva.gameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import net.shybaieva.gameapp.screens.GameActivity;
import net.shybaieva.gameapp.screens.MainGameActivity;
import net.shybaieva.gameapp.screens.WebViewActivity;
import net.shybaieva.gameapp.service.NetworkManager;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    boolean isFirstLaunch = true, isInternetWasConnected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        if(isFirstLaunch){
            if(NetworkManager.isInternetConnectionAvailable(this)){
            //1
                isInternetWasConnected = true;
                startActivity(new Intent(this, WebViewActivity.class));
            }
            else {
            //0
                isInternetWasConnected=false;
                startActivity(new Intent(this, GameActivity.class));

            }
            finish();
        }
        else{
        }
    }

    private void init(){
        tv=findViewById(R.id.textCheck);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onStart() {
        super.onStart();
       // isFirstLaunch = pref.getBoolean("isFirstLaunch", )
    }
}