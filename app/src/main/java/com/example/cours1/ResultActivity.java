package com.example.cours1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    public static final String EXTRA_RESULT = "EXTRA_RESULT";
    private int result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = getIntent().getIntExtra(EXTRA_RESULT, 0);
        initView();
    }

    private void initView() {
        ((TextView)findViewById(R.id.AR_counter_tv)).setText(String.valueOf(result));
    }
}