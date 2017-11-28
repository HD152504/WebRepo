package org.dimigo.User;

public class Music {
    public String singer;
    public String song;
    public String albumname;
    public int currentRank;

    public Music(String singer, String song, String albumname, int currentRank) {
        this.singer = singer;
        this.song = song;
        this.albumname = albumname;
        this.currentRank = currentRank;
    }

    public String getSinger() {
        return singer;
    }

    public String getSong() {
        return song;
    }

    public String getAlbumname() {
        return albumname;
    }

    public int getCurrentRank() {
        return currentRank;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public void setCurrentRank(int currentRank) {
        this.currentRank = currentRank;
    }

    @Override
    public String toString() {

        return "Music{" +
                "singer=" + singer +
                ", song='" + song + '\'' +
                ", albumname='" + albumname + '\'' +
                ", currentRank=" + currentRank +
                '}';
    }
}
