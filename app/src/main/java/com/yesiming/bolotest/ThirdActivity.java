package com.yesiming.bolotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("hello", "Third onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("hello", "Third onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("hello", "Third onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("hello", "Third onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("hello", "Third onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("hello", "Third onStop");
    }
}
