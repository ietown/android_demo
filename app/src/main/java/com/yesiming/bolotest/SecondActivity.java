package com.yesiming.bolotest;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yesiming.bolotest.constants.Contants;

public class SecondActivity extends AppCompatActivity {

    private TextView tv = null;

    private Button finishBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String str = (String)bundle.getString("k1");

        tv = (TextView) findViewById(R.id.textView2);
        tv.setText(str);

        finishBtn = (Button)findViewById(R.id.finishBtn);
        finishBtn.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("kr1", "安卓,我来了!");
            setResult(Contants.RESULT_CODE_ONE, intent);
            finish(); // 结束activity,并且返回到调用这个activity的activity
        }
    };



    @Override
    protected void onStart() {
        super.onStart();
        Log.i("hello", "Second onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("hello", "Second onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("hello", "Second onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("hello", "Second onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("hello", "Second onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("hello", "Second onStop");
    }
}
