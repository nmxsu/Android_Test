package com.example.hx.myapplication.xml;

import com.example.hx.myapplication.model.Mp3Info;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

/**
 * Created by hx on 2016/7/25.
 */
public class Mp3ListContentHandler extends DefaultHandler {
    public List<Mp3Info> getInfos() {
        return infos;
    }

    public void setInfos(List<Mp3Info> infos) {
        this.infos = infos;
    }

    public Mp3ListContentHandler(List<Mp3Info> infos) {
        this.infos = infos;
    }

    private List<Mp3Info> infos = null;
    private Mp3Info mp3Info = null;
    private String tagName = null;

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String temp = new String(ch, start, length);
        if (tagName.equals("id")) {
            mp3Info.setId(temp);
        } else if (tagName.equals("mp3.name")) {
            mp3Info.setMp3Name(temp);
        } else if (tagName.equals("mp3.size")) {
            mp3Info.setMp3Size(temp);
        } else if (tagName.equals("Irc.name")) {
            mp3Info.setIrcName(temp);
        } else if (tagName.equals("Irc.size")) {
            mp3Info.setIrcSize(temp);
        }

    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("-------");
        if (qName.equals("resource")) {
            System.out.println("aaaaaaaaa");
            infos.add(mp3Info);
        }
        tagName = "";
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        this.tagName = localName;
        if (tagName.equals("resource")) {
            mp3Info = new Mp3Info();
        }
    }
}
