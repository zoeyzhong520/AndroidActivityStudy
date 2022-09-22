package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.helloworld.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("MainActivity_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActivity_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("MainActivity_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("MainActivity_onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("MainActivity_onDestroy");
    }

    /*Called when the user taps the Send button*/
    public void sendMessage(View view) {
        /*显示启动*/
        // Intent intent = new Intent(this, DisplayMessageActivity.class); // class跳转

        // Intent intent = new Intent();
        // intent.setClassName(this, "com.example.helloworld.DisplayMessageActivity"); // 包名、类名跳转

        // Intent intent = new Intent();
        // ComponentName componentName = new ComponentName(this, DisplayMessageActivity.class); // ComponentName跳转
        // intent.setComponent(componentName);

        /*隐式启动
        * 如果自己定义的某个action要通过隐式启动，在AndroidManifest.xml中必须加上android.intent.category.DEFAULT，否则不起作用
        * */
        // Intent intent = new Intent("helloworld.DisplayMessageActivity"); // 直接输入action name

        Intent intent = new Intent();
        intent.setAction("helloworld.DisplayMessageActivity");

        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /*开启拨号界面*/
    public void callPhone(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    /*开启短信界面*/
    public void sendSMS(View view) {
        Intent intent = new Intent();
        Uri sms = Uri.parse("smsto:" + "10086");
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(sms);
        intent.putExtra("sms body", "服务满分xxxxxxx");
        startActivity(intent);
    }

    /*开启相机界面*/
    public void takePhoto(View view) {
        // Intent intent = new Intent();
        // intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
        // startActivity(intent);

        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }
}