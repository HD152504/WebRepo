package org.dimigo.vo;

public class BulletinVO {

    private String boardname;
    public String getBoardname() {
        return boardname;
    }
    public void setBoardname(String boardname) {
        this.boardname = boardname;
    }
    private String title;
    private String author;
    private String date;
    private String text;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public BulletinVO() {

    }
    public BulletinVO(String boardname, String title, String author, String date, String text) {
        this.title=title;
        this.author=author;
        this.date=date;
        this.text=text;
    }
    public BulletinVO(String title, String author, String date, String text) {

        this.title=title;
        this.author=author;
        this.date=date;
        this.text=text;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


}