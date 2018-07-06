package com.example.talip.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = this.getPreferences(Context.MODE_PRIVATE);
        counter = sp.getInt("clickCounter", 0);

        TextView tv = findViewById(R.id.counterText);
        tv.setText(Integer.toString(counter));
    }

    @Override
    protected void onStop() {

        SharedPreferences sp = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        e.putInt("clickCounter", counter);
        e.apply();

        super.onStop();
    }

    public void onCounterClick(View v) {

        counter++;

        TextView tv = findViewById(R.id.counterText);
        tv.setText(Integer.toString(counter));
    }
}
