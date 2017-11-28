package org.dimigo.vo;

public class MovieVO extends NaverVO {
    public String title;
    public String pubDate;
    public String director;
    public String link;

    public MovieVO(String title, String pubDate, String director, String link) {
        this.title = title;
        this.pubDate = pubDate;
        this.director = director;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getDirector() {
        return director;
    }

    public String getLink() {
        return link;
    }

    @Override

    public String toString() {
        return "MovieVO{" +
                "title='" + title + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", director='" + director + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
