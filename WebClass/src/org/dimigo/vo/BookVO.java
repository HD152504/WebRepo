package org.dimigo.vo;

public class BookVO extends NaverVO {
    public String title;
    public String link;
    public String image;
    public String author;
    public String price;

    public BookVO(String title, String link, String image, String author, String price) {
        this.title = title;
        this.link = link;
        this.image = image;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "BookVO{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", image='" + image + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
