package me.farhanarnob.learnmultimodule;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();
    private ShareActionProvider mShareActionProvider;

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
//                Intent newIntent = new Intent(MainActivity.this, SettingsActivity.class);
//                startActivity(newIntent);
                String location = PreferenceManager.getDefaultSharedPreferences(MainActivity.this)
                        .getString(getString(R.string.pref_location_key),
                                getString(R.string.pref_location_default));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                Uri geoLocation = Uri.parse("geo:0,0").buildUpon()
                        .appendQueryParameter("q", location)
                        .build();
                mapIntent.setData(geoLocation);
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Log.d(LOG_TAG, "Couldn't call " + location + ", no receiving apps installed");
                }
            }
        });
        setLocationValue();

        final Button shareButton = (Button) findViewById(R.id.share);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello");
                startActivity(Intent.createChooser(shareIntent, "Share Using"));
            }
        });

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
