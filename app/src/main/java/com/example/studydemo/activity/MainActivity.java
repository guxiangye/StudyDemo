package com.example.studydemo.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.studydemo.R;
import com.example.studydemo.service.MainService;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    /** 第一次被创建回调 **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 必须指向xml布局文件
    }

    /** 当活动即将可见时触发 **/
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "activity onStart");
    }

    /** 当活动从不可见重新，激活时触发 **/
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "activity onRestart");
    }

    /** 当活动可见时触发 **/
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "activity onResume");
    }

    /** 当其他活动获取焦点时触发 */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "activity onPause");
    }

    /** 当活动不在可见时调用 **/
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "activity onStop");
    }

    /** 当活动被销毁时调用 **/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "activity onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    /** send button **/
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** 开启服务 **/
    public void startService(View view) {
        startService(new Intent(getBaseContext(), MainService.class));
    }

    /** 关闭服务 **/
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MainService.class));
    }
}
