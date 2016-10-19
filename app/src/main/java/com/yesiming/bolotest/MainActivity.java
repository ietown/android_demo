package com.yesiming.bolotest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yesiming.bolotest.constants.Contants;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView tv = null;
    private EditText et = null;
    private Button btn1 = null;
    private Button btn2 = null;
    private Button btn3 = null;
    private Button btn4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText)findViewById(R.id.editText);

        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(listener);

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(listener);

        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(listener);

        btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(listener);

        if(null != savedInstanceState && savedInstanceState.containsKey("content")) {
            //String content = savedInstanceState.getString("content");
            //et.setText(content);
        }
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Button btn = (Button) v;
            switch (btn.getId()) {
                case R.id.button1:
                    Toast.makeText(MainActivity.this, "打电话", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:110"));
                    startActivity(intent);
                    break;
                case R.id.button2:
                    Toast.makeText(MainActivity.this, "发短信", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent();
                    intent2.setAction(Intent.ACTION_SENDTO);
                    intent2.setData(Uri.parse("smsto:13521941707"));
                    intent2.putExtra("sms_body", "Hello world");
                    startActivity(intent2);
                    break;
                case R.id.button3:
                    Toast.makeText(MainActivity.this, "跳转", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent();
                    intent3.setClass(MainActivity.this, SecondActivity.class);
                    //et.getText().toString();

                    intent3.putExtra("k1", et.getText().toString());
                    startActivityForResult(intent3, Contants.RESULT_CODE_ONE);
                    Log.i("", "");
                    break;
                case R.id.button4:
                    Intent intent4 = new Intent();
                    intent4.setClass(MainActivity.this, ThirdActivity.class);
                    startActivity(intent4);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Contants.RESULT_CODE_ONE && resultCode == Contants.RESULT_CODE_ONE) {
            Bundle bundle = data.getExtras();
            String str = (String)bundle.getString("kr1");

            //Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            tv = (TextView)findViewById(R.id.textView);
            tv.setText(str);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("hello", "Main onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("hello", "Main onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("hello", "Main onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("hello", "Main onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("hello", "Main onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("hello", "Main onStop");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String content = et.getText().toString();
        outState.putString("content", content);

    }
}

