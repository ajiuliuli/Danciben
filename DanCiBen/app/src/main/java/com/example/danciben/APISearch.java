package com.example.danciben;

import androidx.appcompat.app.AppCompatActivity;
import com.example.danciben.DataBase.Vocabularyshell;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APISearch extends AppCompatActivity {
    EditText responseText;
    ContentHandler handler = new ContentHandler();
    private boolean isButton = true;

    Button sendRequest;
    Button show;
    TextView testview2;
    EditText UNps;
    TextView testview3;
    EditText USps;
    TextView testview4;
    EditText pos1;
    EditText acceptation1;
    TextView testview5;
    EditText pos2;
    EditText acceptation2;
    TextView testview6;
    EditText pos3;
    EditText acceptation3;
    TextView testview7;
    EditText orig1;
    EditText trans1;
    TextView testview8;
    EditText orig2;
    EditText trans2;
    TextView testview9;
    EditText orig3;
    EditText trans3;
    Button send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apisearch);

        testview2 = (TextView) findViewById(R.id.textView2);
        UNps = (EditText) findViewById(R.id.UNps);
        testview3 = (TextView) findViewById(R.id.textView3);
        USps = (EditText) findViewById(R.id.USps);
        testview4 = (TextView) findViewById(R.id.textView4);
        pos1 = (EditText) findViewById(R.id.pos1);
        acceptation1 = (EditText) findViewById(R.id.acceptation1);
        testview5 = (TextView) findViewById(R.id.textView5);
        pos2 = (EditText) findViewById(R.id.pos2);
        acceptation2 = (EditText) findViewById(R.id.acceptation2);
        testview6 = (TextView) findViewById(R.id.textView6);
        pos3 = (EditText) findViewById(R.id.pos3);
        acceptation3 = (EditText) findViewById(R.id.acceptation3);
        testview7 = (TextView) findViewById(R.id.textView7);
        orig1 = (EditText) findViewById(R.id.orig1);
        trans1 = (EditText) findViewById(R.id.trans1);
        testview8 = (TextView) findViewById(R.id.textView8);
        orig2 = (EditText) findViewById(R.id.orig2);
        trans2 = (EditText) findViewById(R.id.trans2);
        testview9 = (TextView) findViewById(R.id.textView9);
        orig3 = (EditText) findViewById(R.id.orig3);
        trans3 = (EditText) findViewById(R.id.trans3);

        sendRequest = (Button) findViewById(R.id.send_request);
        show = (Button) findViewById(R.id.show);
        send = (Button) findViewById(R.id.send);
        responseText = (EditText) findViewById(R.id.response_text);
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sendRequestWithOkHttp();        //将XML文件发送至文件处理系统
                    Toast.makeText(APISearch.this,"查询成功，请点击“显示结果！",Toast.LENGTH_SHORT).show();
                    show.setVisibility(View.VISIBLE);
                    send.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    Toast.makeText(APISearch.this,"查询失败！",Toast.LENGTH_SHORT).show();
                    show.setVisibility(View.GONE);
                    send.setVisibility(View.GONE);
                }
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UNps.setText(handler.getWords().getUNps());
                USps.setText(handler.getWords().getUSps());
                pos1.setText(handler.getWords().getPos1());
                acceptation1.setText(handler.getWords().getAcceptation1());
                pos2.setText(handler.getWords().getPos2());
                acceptation2.setText(handler.getWords().getAcceptation2());
                pos3.setText(handler.getWords().getPos3());
                acceptation3.setText(handler.getWords().getAcceptation3());
                orig1.setText(handler.getWords().getOrig1());
                trans1.setText(handler.getWords().getTrans1());
                orig2.setText(handler.getWords().getOrig2());
                trans2.setText(handler.getWords().getTrans2());
                orig3.setText(handler.getWords().getOrig3());
                trans3.setText(handler.getWords().getTrans3());
                if (isButton) {
                    if (handler.getWords().getUNps() != null) {
                        testview2.setVisibility(View.VISIBLE);
                        UNps.setVisibility(View.VISIBLE);
                    }
                    if (handler.getWords().getUSps() != null) {
                        testview3.setVisibility(View.VISIBLE);
                        USps.setVisibility(View.VISIBLE);
                    }
                    if (handler.getWords().getPos1() != null && handler.getWords().getAcceptation1() != null) {
                        testview4.setVisibility(View.VISIBLE);
                        pos1.setVisibility(View.VISIBLE);
                        acceptation1.setVisibility(View.VISIBLE);
                    }
                    if (handler.getWords().getPos2() != null && handler.getWords().getAcceptation2() != null) {
                        testview5.setVisibility(View.VISIBLE);
                        pos2.setVisibility(View.VISIBLE);
                        acceptation2.setVisibility(View.VISIBLE);
                    }
                    if (handler.getWords().getPos3() != null && handler.getWords().getAcceptation3() != null) {
                        testview6.setVisibility(View.VISIBLE);
                        pos3.setVisibility(View.VISIBLE);
                        acceptation3.setVisibility(View.VISIBLE);
                    }
                    if (handler.getWords().getOrig1() != null && handler.getWords().getTrans1() != null) {
                        testview7.setVisibility(View.VISIBLE);
                        orig1.setVisibility(View.VISIBLE);
                        trans1.setVisibility(View.VISIBLE);
                    }
                    if (handler.getWords().getOrig2() != null && handler.getWords().getTrans2() != null) {
                        testview8.setVisibility(View.VISIBLE);
                        orig2.setVisibility(View.VISIBLE);
                        trans2.setVisibility(View.VISIBLE);
                    }
                    if (handler.getWords().getOrig3() != null && handler.getWords().getTrans3() != null) {
                        testview9.setVisibility(View.VISIBLE);
                        orig3.setVisibility(View.VISIBLE);
                        trans3.setVisibility(View.VISIBLE);
                    }

                    isButton = false;
                }
                else {
                    testview2.setVisibility(View.GONE);
                    UNps.setVisibility(View.GONE);
                    testview3.setVisibility(View.GONE);
                    USps.setVisibility(View.GONE);
                    testview4.setVisibility(View.GONE);
                    pos1.setVisibility(View.GONE);
                    acceptation1.setVisibility(View.GONE);
                    testview5.setVisibility(View.GONE);
                    pos2.setVisibility(View.GONE);
                    acceptation2.setVisibility(View.GONE);
                    testview6.setVisibility(View.GONE);
                    pos3.setVisibility(View.GONE);
                    acceptation3.setVisibility(View.GONE);
                    testview7.setVisibility(View.GONE);
                    orig1.setVisibility(View.GONE);
                    trans1.setVisibility(View.GONE);
                    testview8.setVisibility(View.GONE);
                    orig2.setVisibility(View.GONE);
                    trans2.setVisibility(View.GONE);
                    testview9.setVisibility(View.GONE);
                    orig3.setVisibility(View.GONE);
                    trans3.setVisibility(View.GONE);
                    isButton = true;
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Vocabularyshell> vocabulary = LitePal.select("key")
                        .where("key = ?",responseText.getText().toString())
                        .find(Vocabularyshell.class);

                if (vocabulary.size() == 0) {
                    try {
                        Vocabularyshell vocabularyshell = new Vocabularyshell();
                        vocabularyshell.setKey(responseText.getText().toString());
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
                        Toast.makeText(APISearch.this,"数据添加成功",Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(APISearch.this,"数据添加失败",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(APISearch.this,"该单词以存在，请勿重复添加！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://dict-co.iciba.com/api/dictionary.php?w=" + responseText.getText().toString() +"&key=2DCDF16EF699E290BABE3BB8383769B8")
                            .get()
                            .build();
                    final Call call = client.newCall(request);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Response response = call.execute();
                                String responseData = response.body().string();
                                parseXMLWithSAX(responseData);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
            }
        }).start();
    }

    private void parseXMLWithSAX (String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


