package com.example.myapplicationauthhulk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        process();

    }

    public void process() {

        Call<modelclass> call = ApiController.getInstance().getApi().getdata();

        call.enqueue(new Callback<modelclass>() {
            @Override
            public void onResponse(Call<modelclass> call, Response<modelclass> response) {
                Log.d("tag", "hi");
                modelclass data = response.body();
                final String s = response.body().toString();
                Log.d(TAG, "onResponse: " + s);
                String k = data.getNonce();


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        tv.setText(k);
                    }
                });
            }

            @Override
            public void onFailure(Call<modelclass> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}