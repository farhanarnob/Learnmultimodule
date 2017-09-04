package me.farhanarnob.learnmultimodule;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        setLocationValue();


    }

    @Override
    protected void onStart() {
        super.onStart();
        setLocationValue();
    }

    private void setLocationValue() {
        // preference value showing ( location)
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String location = pref.getString(getString(R.string.pref_location_key),
                getString(R.string.pref_location_default));

        TextView newText = (TextView) findViewById(R.id.text_view);
        newText.setText(location);
    }
}
