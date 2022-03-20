package com.company;

public class PlayList {
    private String Title;
    private String Singer;

    public PlayList(String Title, String singer){
        this.Title = Title;
        this.Singer = singer;
    }

    public String getSong() {
        return this.Title;
    }

    @Override
    public String toString() {
        return Title +" - "+ Singer;
    }
}
