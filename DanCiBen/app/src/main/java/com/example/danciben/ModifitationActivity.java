package com.example.danciben;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danciben.DataBase.Vocabularyshell;

import org.litepal.LitePal;

import java.util.List;

public class ModifitationActivity extends AppCompatActivity {

    TextView textView1;
    EditText key;
    TextView textView2;
    EditText UNps;
    TextView textView3;
    EditText USps;
    TextView textView4;
    EditText pos1;
    EditText acceptation1;
    TextView textView5;
    EditText pos2;
    EditText acceptation2;
    TextView textView6;
    EditText pos3;
    EditText acceptation3;
    TextView textView7;
    EditText orig1;
    EditText trans1;
    TextView textView8;
    EditText orig2;
    EditText trans2;
    TextView textView9;
    EditText orig3;
    EditText trans3;
    Button modifitation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifitation);

        textView1 = (TextView) findViewById(R.id.textView1);
        key = (EditText) findViewById(R.id.key);
        textView2 = (TextView) findViewById(R.id.textView2);
        UNps = (EditText) findViewById(R.id.UNps);
        textView3 = (TextView) findViewById(R.id.textView3);
        USps = (EditText) findViewById(R.id.USps);
        textView4 = (TextView) findViewById(R.id.textView4);
        pos1 = (EditText) findViewById(R.id.pos1);
        acceptation1 = (EditText) findViewById(R.id.acceptation1);
        textView5 = (TextView) findViewById(R.id.textView5);
        pos2 = (EditText) findViewById(R.id.pos2);
        acceptation2 = (EditText) findViewById(R.id.acceptation2);
        textView6 = (TextView) findViewById(R.id.textView6);
        pos3 = (EditText) findViewById(R.id.pos3);
        acceptation3 = (EditText) findViewById(R.id.acceptation3);
        textView7 = (TextView) findViewById(R.id.textView7);
        orig1 = (EditText) findViewById(R.id.orig1);
        trans1 = (EditText) findViewById(R.id.trans1);
        textView8 = (TextView) findViewById(R.id.textView8);
        orig2 = (EditText) findViewById(R.id.orig2);
        trans2 = (EditText) findViewById(R.id.trans2);
        textView9 = (TextView) findViewById(R.id.textView9);
        orig3 = (EditText) findViewById(R.id.orig3);
        trans3 = (EditText) findViewById(R.id.trans3);
        modifitation = (Button) findViewById(R.id.modification);

        Intent intent = getIntent();
        final String str = intent.getStringExtra("str");

        List<Vocabularyshell> vocabularyshells = LitePal.select("key","UNps","USps","pos1","acceptation1","pos2","acceptation2","pos3","acceptation3","orig1","trans1","orig2","trans2","orig3","trans3")
                .where("key = ?",str)
                .find(Vocabularyshell.class);

        for(Vocabularyshell v:vocabularyshells) {
            key.setText(v.getKey());
            UNps.setText(v.getUNps());
            USps.setText(v.getUSps());
            pos1.setText(v.getPos1());
            acceptation1.setText(v.getAcceptation1());
            pos2.setText(v.getPos2());
            acceptation2.setText(v.getAcceptation2());
            pos3.setText(v.getPos3());
            acceptation3.setText(v.getAcceptation3());
            orig1.setText(v.getOrig1());
            trans1.setText(v.getTrans1());
            orig2.setText(v.getOrig2());
            trans2.setText(v.getTrans2());
            orig3.setText(v.getOrig3());
            trans3.setText(v.getTrans3());
        }

        modifitation.setOnClickListener(new View.OnClickListener() {
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
                    vocabularyshell.updateAll("key = ?",str);

                    AlertDialog.Builder verify = new AlertDialog.Builder(ModifitationActivity.this);
                    verify.setTitle("修改成功！");
                    verify.setMessage("是否返回查询界面？");
                    verify.setCancelable(false);
                    verify.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(ModifitationActivity.this,LocalSearch.class);
                            startActivity(intent);
                        }
                    });
                    verify.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    verify.show();
                } catch (Exception e) {
                    Toast.makeText(ModifitationActivity.this,"修改失败!",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
