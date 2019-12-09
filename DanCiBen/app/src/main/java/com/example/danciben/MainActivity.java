package com.example.danciben;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;


public class MainActivity extends AppCompatActivity {
    Button button1 ;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LocalSearch.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"您已进入本地查询！",Toast.LENGTH_SHORT).show();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShengCiBengActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"您已进入生词本！",Toast.LENGTH_SHORT).show();
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EnterActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"您已进入单词添加页面！",Toast.LENGTH_SHORT).show();
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,APISearch.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"您已进入API查询",Toast.LENGTH_SHORT).show();
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    LitePal.getDatabase();
                    Toast.makeText(MainActivity.this,"创建成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,"创建失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
