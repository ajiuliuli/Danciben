package com.example.danciben;

import com.example.danciben.util.Words;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ContentHandler extends DefaultHandler {
    private String nodeName;
    private Words word;
    private StringBuilder key;
    private StringBuilder ps;
    private StringBuilder pron;
    private StringBuilder pos;
    private StringBuilder acceptation;
    private StringBuilder orig;
    private StringBuilder trans;

    @Override
    public void startDocument() throws SAXException{
        word = new Words();
        key = new StringBuilder();
        ps = new StringBuilder();
        pron = new StringBuilder();
        pos = new StringBuilder();
        acceptation = new StringBuilder();
        orig = new StringBuilder();
        trans = new StringBuilder();
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        nodeName = localName;
    }

    @Override
    public void characters(char[] ch,int start,int length) throws  SAXException {

        String a = new String(ch, start, length).trim();
        if ("key".equals(nodeName))
            key.append(a);

        if ("ps".equals(nodeName))
            ps.append(a);

        if ("pron".equals(nodeName))
            pron.append(a);

        if ("pos".equals(nodeName))
            pos.append(a);

        if ("acceptation".equals(nodeName))
            acceptation.append(a);

        if ("orig".equals(nodeName))
            orig.append(a);

        if ("trans".equals(nodeName))
            trans.append(a);
    }

    @Override
    public void endElement(String uri,String loaclName,String qName) throws SAXException {
        if("key".equals(loaclName)){
            word.setKey(key.toString());
            key.setLength(0);
        }

        if("ps".equals(loaclName)){
            if (word.getUNps() == null) {
                word.setUNps(ps.toString());
                ps.setLength(0);
            }
            else {
                word.setUSps(ps.toString());
                ps.setLength(0);
            }
        }

        if ("pron".equals(loaclName)) {
            if (word.getUNpron() == null) {
                word.setUNpron(pron.toString());
                pron.setLength(0);
            }
            else {
                word.setUSpron(pron.toString());
                pron.setLength(0);
            }
        }

        if ("pos".equals(loaclName)) {
            if (word.getPos1()==null) {
                word.setPos1(pos.toString());
//                Log.d("ContentHandler", "pos1" + word.getPos1());
                pos.setLength(0);
            }
            else if (word.getPos2()==null) {
                word.setPos2(pos.toString());
//                Log.d("ContentHandler", "pos2" + word.getPos2());
                pos.setLength(0);
            }
            else{
                word.setPos3(pos.toString());
//                Log.d("ContentHandler", "pos3" + word.getPos3());
                pos.setLength(0);
            }
        }

        if ("acceptation".equals(loaclName)) {
            if (word.getAcceptation1() == null) {
                word.setAcceptation1(acceptation.toString());
                acceptation.setLength(0);
            }
            else if (word.getAcceptation2() == null) {
                word.setAcceptation2(acceptation.toString());
                acceptation.setLength(0);
            }
            else {
                word.setAcceptation3(acceptation.toString());
                acceptation.setLength(0);
            }
        }

        if ("orig".equals(loaclName)) {

            if (word.getOrig1() == null) {
                word.setOrig1(orig.toString());
//                Log.d("ContentHandler", "orig1" + word.getOrig1());
                orig.setLength(0);
            }
            else if (word.getOrig2() == null) {
                word.setOrig2(orig.toString());
                orig.setLength(0);
            }
            else {
                word.setOrig3(orig.toString());
                orig.setLength(0);
            }
        }

        if("trans".equals(loaclName)){
            if (word.getTrans1() == null) {
                word.setTrans1(trans.toString());
//                Log.d("ContentHandler", "trans1" + trans.toString());
                trans.setLength(0);
            }
            else if (word.getTrans2() == null) {
                word.setTrans2(trans.toString());
                trans.setLength(0);
            }
            else {
                word.setTrans3(trans.toString());
                trans.setLength(0);
            }
        }
    }

    public Words getWords(){
        return word;
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
