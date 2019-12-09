package com.example.danciben;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.danciben.DataBase.Vocabularyshell;

import org.litepal.LitePal;

import java.util.List;

public class ShengCiBengActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheng_ci_beng);

        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        List<Vocabularyshell> vocabularyshells = LitePal.select("key")
                .find(Vocabularyshell.class);
        ll.removeAllViews();
        final Button[] tv = new Button[vocabularyshells.size()];
        int x = 0;
        for (Vocabularyshell v : vocabularyshells) {
            tv[x] = new Button(ShengCiBengActivity.this);
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
                    Intent intent = new Intent(ShengCiBengActivity.this,ShowActivity.class);
                    intent.putExtra("vocabulary",str);
                    startActivity(intent);
                }
            });
            View vi = new View(ShengCiBengActivity.this);
            vi.setMinimumHeight(5);
            vi.setBackgroundColor(Color.parseColor("#22000000"));
            ll.addView(tv[x]);
            ll.addView(vi);
            x++;
        }
    }
}
