package com.example.hx.myapplication.model;

/**
 * Created by hx on 2016/7/25.
 */
public class Mp3Info {
    private String id;
    private String mp3Name;
    private String mp3Size;
    private String IrcSize;
    private String IrcName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMp3Name() {
        return mp3Name;
    }

    public void setMp3Name(String mp3Name) {
        this.mp3Name = mp3Name;
    }

    public String getMp3Size() {
        return mp3Size;
    }

    public void setMp3Size(String mp3Size) {
        this.mp3Size = mp3Size;
    }

    public String getIrcSize() {
        return IrcSize;
    }

    public void setIrcSize(String ircSize) {
        IrcSize = ircSize;
    }

    public String getIrcName() {
        return IrcName;
    }

    public void setIrcName(String ircName) {
        IrcName = ircName;
    }

    public Mp3Info(String id, String mp3Name, String mp3Size, String ircSize, String ircName) {
        this.id = id;
        this.mp3Name = mp3Name;
        this.mp3Size = mp3Size;
        IrcSize = ircSize;
        IrcName = ircName;
    }

    public Mp3Info() {

    }

    @Override
    public String toString() {
        return "Mp3Info{" +
                "id='" + id + '\'' +
                ", mp3Name='" + mp3Name + '\'' +
                ", mp3Size='" + mp3Size + '\'' +
                ", IrcSize='" + IrcSize + '\'' +
                ", IrcName='" + IrcName + '\'' +
                '}';
    }
}
