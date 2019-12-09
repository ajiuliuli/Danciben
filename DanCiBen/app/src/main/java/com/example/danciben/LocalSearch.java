package com.example.danciben;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.danciben.DataBase.Vocabularyshell;

import org.litepal.LitePal;

import java.util.List;

public class LocalSearch extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_search);

        final EditText key = (EditText) findViewById(R.id.key);
        key.addTextChangedListener(new TextWatcher() {
            LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    key.setHint("请输入需要查询的单词！");
                    ll.removeAllViews();
                } else {
                    List<Vocabularyshell> vocabularyshells = LitePal.select("key")
                            .where("key like ?", "%" + charSequence.toString() + "%")
                            .find(Vocabularyshell.class);
                    ll.removeAllViews();
                    final Button[] tv = new Button[vocabularyshells.size()];
                    int x = 0;
                    for (Vocabularyshell v : vocabularyshells) {
                        tv[x] = new Button(LocalSearch.this);
                        tv[x].setId(x);
                        tv[x].setHeight(100);
                        tv[x].setBackgroundColor(Color.parseColor("#ffffff"));
                        tv[x].setText(v.getKey());
                        tv[x].setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
                        tv[x].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                int i = view.getId();
                                String str = tv[i].getText().toString();
                                Intent intent = new Intent(LocalSearch.this,ShowActivity.class);
                                intent.putExtra("vocabulary",str);
                                startActivity(intent);
                            }
                        });
                        View vi = new View(LocalSearch.this);
                        vi.setMinimumHeight(5);
                        vi.setBackgroundColor(Color.parseColor("#22000000"));
                        ll.addView(tv[x]);
                        ll.addView(vi);
                        x++;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }
}
