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

public class ShowActivity extends AppCompatActivity {

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
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

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
        delete = (Button) findViewById(R.id.delete);

        Intent intent = getIntent();
        String vocabulary = intent.getStringExtra("vocabulary");

        List<Vocabularyshell> vocabularyshells = LitePal.select("key","UNps","USps","pos1","acceptation1","pos2","acceptation2","pos3","acceptation3","orig1","trans1","orig2","trans2","orig3","trans3")
                .where("key = ?",vocabulary)
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
        if (key.getText().toString() != null) {
            textView1.setVisibility(View.VISIBLE);
            key.setVisibility(View.VISIBLE);
        }
        if (UNps.getText().toString() != null) {
            textView2.setVisibility(View.VISIBLE);
            UNps.setVisibility(View.VISIBLE);
        }
        if(USps.getText().toString() != null) {
            textView3.setVisibility(View.VISIBLE);
            USps.setVisibility(View.VISIBLE);
        }
        if(pos1.getText().toString() != null) {
            textView4.setVisibility(View.VISIBLE);
            pos1.setVisibility(View.VISIBLE);
            acceptation1.setVisibility(View.VISIBLE);
        }
        if(pos2.getText().toString() != null) {
            textView5.setVisibility(View.VISIBLE);
            pos2.setVisibility(View.VISIBLE);
            acceptation2.setVisibility(View.VISIBLE);
        }
        if(pos3.getText().toString() != null) {
            textView6.setVisibility(View.VISIBLE);
            pos3.setVisibility(View.VISIBLE);
            acceptation3.setVisibility(View.VISIBLE);
        }
        if(orig1.getText().toString() != null) {
            textView7.setVisibility(View.VISIBLE);
            orig1.setVisibility(View.VISIBLE);
            trans1.setVisibility(View.VISIBLE);
        }
        if(orig2.getText().toString() != null) {
            textView2.setVisibility(View.VISIBLE);
            orig2.setVisibility(View.VISIBLE);
            trans2.setVisibility(View.VISIBLE);
        }
        if(orig3.getText().toString() != null) {
            textView9.setVisibility(View.VISIBLE);
            orig3.setVisibility(View.VISIBLE);
            trans3.setVisibility(View.VISIBLE);
        }

        modifitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = key.getText().toString();
                Intent intent = new Intent(ShowActivity.this,ModifitationActivity.class);
                intent.putExtra("str",str);
                startActivity(intent);
                Toast.makeText(ShowActivity.this,"进入修改页面！",Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder verify = new AlertDialog.Builder(ShowActivity.this);
                verify.setTitle("删除确认");
                verify.setMessage("您真的要从本地移除该单词并返回搜索页面吗？(此操作无法撤销)");
                verify.setCancelable(false);
                verify.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        LitePal.deleteAll(Vocabularyshell.class,"key = ?",key.getText().toString());
                        Intent intent = new Intent(ShowActivity.this,LocalSearch.class);
                        startActivity(intent);
                    }
                });
                verify.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                verify.show();
            }
        });
    }
}
