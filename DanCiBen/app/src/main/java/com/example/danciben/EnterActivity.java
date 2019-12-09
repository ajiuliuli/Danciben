package com.example.danciben;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.danciben.DataBase.Vocabularyshell;

import org.litepal.LitePal;

public class EnterActivity extends AppCompatActivity {

    EditText key ;
    EditText UNps;
    EditText USps;
    EditText pos1;
    EditText acceptation1;
    EditText pos2;
    EditText acceptation2;
    EditText pos3;
    EditText acceptation3;
    EditText orig1;
    EditText trans1;
    EditText orig2;
    EditText trans2;
    EditText orig3;
    EditText trans3;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        key = (EditText) findViewById(R.id.key);
        UNps = (EditText) findViewById(R.id.UNps);
        USps = (EditText) findViewById(R.id.USps);
        pos1 = (EditText) findViewById(R.id.pos1);
        acceptation1 = (EditText) findViewById(R.id.acceptation1);
        pos2 = (EditText) findViewById(R.id.pos2);
        acceptation2 = (EditText) findViewById(R.id.acceptation2);
        pos3 = (EditText) findViewById(R.id.pos3);
        acceptation3 = (EditText) findViewById(R.id.acceptation3);
        orig1 = (EditText) findViewById(R.id.orig1);
        trans1 = (EditText) findViewById(R.id.trans1);
        orig2 = (EditText) findViewById(R.id.orig2);
        trans2 = (EditText) findViewById(R.id.trans2);
        orig3 = (EditText) findViewById(R.id.orig3);
        trans3 = (EditText) findViewById(R.id.trans3);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Vocabularyshell vocabularyshell = new Vocabularyshell();
                    vocabularyshell.setKey(key.getText().toString());
                    vocabularyshell.setUNps(UNps.getText().toString());
                    vocabularyshell.setUSps(USps.getText().toString());
                    vocabularyshell.setPos1(pos1.getText().toString());
                    vocabularyshell.setAcceptation1(acceptation1.getText().toString());
                    vocabularyshell.setPos2(pos2.getText().toString());
                    vocabularyshell.setAcceptation2(acceptation2.getText().toString());
                    vocabularyshell.setPos3(pos3.getText().toString());
                    vocabularyshell.setAcceptation3(acceptation3.getText().toString());
                    vocabularyshell.setOrig1(orig1.getText().toString());
                    vocabularyshell.setTrans1(trans1.getText().toString());
                    vocabularyshell.setOrig2(orig2.getText().toString());
                    vocabularyshell.setTrans2(trans2.getText().toString());
                    vocabularyshell.setOrig3(orig3.getText().toString());
                    vocabularyshell.setTrans3(trans3.getText().toString());
                    vocabularyshell.save();
                    Toast.makeText(EnterActivity.this,"数据添加成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(EnterActivity.this,"数据创建失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
