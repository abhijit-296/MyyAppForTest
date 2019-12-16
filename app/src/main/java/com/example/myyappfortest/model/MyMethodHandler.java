package com.example.myyappfortest.model;

import android.util.Log;
import android.view.View;

public class MyMethodHandler {

    public void myMethod(View view)
    {
        Log.i("TAG_IN_HANDLER","method called");
    }

    public void noParameterMethod(String ss)
    {
        Log.i("TAG_IN_HANDLER","no parameter method called");


    }
}
