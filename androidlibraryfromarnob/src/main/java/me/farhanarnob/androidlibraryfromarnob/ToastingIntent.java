package me.farhanarnob.androidlibraryfromarnob;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class ToastingIntent extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_layout_for_toasing);
        Toast.makeText(this, R.string.toast_will_show_here_form_library, Toast.LENGTH_SHORT).show();
    }
}
