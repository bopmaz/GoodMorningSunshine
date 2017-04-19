package com.bopmaster.goodmorningsunshine;

import android.app.Activity;
import android.os.Bundle;

import com.bopmaster.goodmorningsunshine.Adapter.CallAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;

public class StartScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_start_screen);
        CallAdapter info = new CallAdapter();
        info.getPost();
    }
}
