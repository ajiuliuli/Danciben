package com.example.danciben.DataBase;

import org.litepal.crud.LitePalSupport;

public class Vocabularyshell extends LitePalSupport {
    private int id;                         //主键
    private String key;                     //单词
    private String UNps;                    //英式音标
    private String UNpron;                  //英式发音网址
    private String USps;                    //美式音标
    private String USpron;                  //美式发音网址
    private String pos1;                    //词性1
    private String acceptation1;            //词义1
    private String pos2;                    //词性2
    private String acceptation2;            //词义2
    private String pos3;                    //词性3
    private String acceptation3;            //词义3
    private String orig1;                   //例句1
    private String trans1;                  //例句翻译1
    private String orig2;                   //例句2
    private String trans2;                  //例句翻译2
    private String orig3;                   //例句3
    private String trans3;                  //例句翻译3

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUNps() {
        return UNps;
    }

    public void setUNps(String UNps) {
        this.UNps = UNps;
    }

    public String getUNpron() {
        return UNpron;
    }

    public void setUNpron(String UNpron) {
        this.UNpron = UNpron;
    }

    public String getUSps() {
        return USps;
    }

    public void setUSps(String USps) {
        this.USps = USps;
    }

    public String getUSpron() {
        return USpron;
    }

    public void setUSpron(String USpron) {
        this.USpron = USpron;
    }

    public String getPos1() {
        return pos1;
    }

    public void setPos1(String pos1) {
        this.pos1 = pos1;
    }

    public String getAcceptation1() {
        return acceptation1;
    }

    public void setAcceptation1(String acceptation1) {
        this.acceptation1 = acceptation1;
    }

    public String getPos2() {
        return pos2;
    }

    public void setPos2(String pos2) {
        this.pos2 = pos2;
    }

    public String getAcceptation2() {
        return acceptation2;
    }

    public void setAcceptation2(String acceptation2) {
        this.acceptation2 = acceptation2;
    }

    public String getPos3() {
        return pos3;
    }

    public void setPos3(String pos3) {
        this.pos3 = pos3;
    }

    public String getAcceptation3() {
        return acceptation3;
    }

    public void setAcceptation3(String acceptation3) {
        this.acceptation3 = acceptation3;
    }

    public String getOrig1() {
        return orig1;
    }

    public void setOrig1(String orig1) {
        this.orig1 = orig1;
    }

    public String getTrans1() {
        return trans1;
    }

    public void setTrans1(String trans1) {
        this.trans1 = trans1;
    }

    public String getOrig2() {
        return orig2;
    }

    public void setOrig2(String orig2) {
        this.orig2 = orig2;
    }

    public String getTrans2() {
        return trans2;
    }

    public void setTrans2(String trans2) {
        this.trans2 = trans2;
    }

    public String getOrig3() {
        return orig3;
    }

    public void setOrig3(String orig3) {
        this.orig3 = orig3;
    }

    public String getTrans3() {
        return trans3;
    }

    public void setTrans3(String trans3) {
        this.trans3 = trans3;
    }
}

