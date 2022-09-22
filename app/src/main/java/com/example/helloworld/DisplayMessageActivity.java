package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout`s TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("DisplayMessageActivity_onDestroy");
    }

    /*standard 启动模式
    * 默认启动模式，每次激活activity时，都创建activity实例，并放入任务栈
    * */
    public void standard(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }

    /*singleTop 启动模式（栈顶情况）
    * 如果某个activity自己激活自己，即任务栈栈顶是该activity，则不需要创建，其余情况都要创建activity
    * */
    public void singleTop(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }

    /*singleTask 启动模式（非栈顶情况）
    * 如果要激活的activity在任务栈中，则不需要创建，只需要把这个activity放入栈顶，并把该activity以上的activity实例都出栈
    * */
    public void singleTask(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }

    /*singleInstance 启动模式
    * 只有一个实例，并且这个实例独立运行在一个task中，这个task只有这个实例，不允许有别的activity存在
    * */
    public void singleInstance(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }
}