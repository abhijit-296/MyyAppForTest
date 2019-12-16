package com.example.myyappfortest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myyappfortest.R;
import com.example.myyappfortest.databinding.ActivityMainBinding;
import com.example.myyappfortest.model.MyMethodHandler;
import com.example.myyappfortest.model.MyPojo;
import com.example.myyappfortest.model.MyPojoArray;
import com.example.myyappfortest.model.MyUnClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btn;
    MyService myService;
    List<String> items;
    MyUnClass myUnClass;
    Integer aa = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        MyPojo myPojo = new MyPojo();
        myUnClass = new MyUnClass();
        myPojo.setBody("Hello All");
        MyMethodHandler myMethodHandler = new MyMethodHandler();
        activityMainBinding.setMyhandler(myMethodHandler);
        activityMainBinding.setMypojo(myPojo);
        activityMainBinding.setHey(new String("Hello"));
        activityMainBinding.setUnitem(myUnClass);


        /*setContentView(R.layout.activity_main);
        et = findViewById(R.id.etvalue);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BActivity.class));
              //  startWebCall();
            }
        });*/

    }

    public void myMethods(View view)
    {
        Log.i("TAG_IN_HANDLER","method called");
        myUnClass.un.set("I got set");
        myUnClass.mp.put("first","string");
        myUnClass.al.add(aa+1);

    }
    /*public class MyMethodHandler {

        public void myMethod(View view)
        {
            Log.i("TAG_IN_HANDLER","method called");
        }
    }*/


    /*@Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("value",et.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null)
        {
            et.setText(savedInstanceState.getString("value"));
        }
    }*/

    public void startWebCall()
    {
        Retrofit rr = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(GsonConverterFactory.create()).build();
        myService = rr.create(MyService.class);
        myService.getUlist().enqueue(new Callback<List<MyPojo>>() {
            @Override
            public void onResponse(Call<List<MyPojo>> call, Response<List<MyPojo>> response) {
                Toast.makeText(MainActivity.this,"Response Found",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<MyPojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error Found",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
