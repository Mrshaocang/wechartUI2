package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity{

    private ImageView imageView;
    private TextView textView1,textView2;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String first = intent.getStringExtra("名字");
        String second = intent.getStringExtra("介绍");
        imageView = findViewById(R.id.news_);
        textView1 = findViewById(R.id.title_);
        textView2 = findViewById(R.id.introduction_);
        button = findViewById(R.id.back_);
        textView1.setText(first);
        textView2.setText(second);
        imageView.setImageResource(intent.getIntExtra("scc",1));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this,first,Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }});
    }
}