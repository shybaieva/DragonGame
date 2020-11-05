package net.shybaieva.gameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import net.shybaieva.gameapp.screens.GameActivity;
import net.shybaieva.gameapp.screens.MainGameActivity;
import net.shybaieva.gameapp.screens.WebViewActivity;
import net.shybaieva.gameapp.service.NetworkManager;

public class MainActivity extends AppCompatActivity {

    int isInternetWasConnected;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences=getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        boolean hasVisited = sharedPreferences.getBoolean("hasVisited", false);

        if(!hasVisited){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("hasVisited", true);

            if(NetworkManager.isInternetConnectionAvailable(this)){
                isInternetWasConnected = 1;
            }
            else {
                isInternetWasConnected=0;
            }
            editor.putInt("isInternetWasConnected", isInternetWasConnected);
            editor.commit();
        }
        else {
            isInternetWasConnected=sharedPreferences.getInt("isInternetWasConnected",2);
        }

        if(isInternetWasConnected==1)
            startActivity(new Intent(this, GameActivity.class));
        if(isInternetWasConnected==0)
            startActivity(new Intent(this, WebViewActivity.class));
        if(isInternetWasConnected==2)
            Toast.makeText(this, "SOME PROBLEMS WITH PREFERENCES", Toast.LENGTH_SHORT).show();
        finish();
    }
}