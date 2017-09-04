package me.farhanarnob.learnmultimodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intent intent = new Intent(this, ToastingIntent.class);
        // startActivity(intent);
        String[] forcastArray = {
                "no",
                "yes",
                "maybe"
        };

        List<String> weekForecast = new ArrayList<>(
                Arrays.asList(forcastArray)
        );
        Button settings_btn = (Button) findViewById(R.id.settings);
        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(newIntent);
            }
        });

    }
}
