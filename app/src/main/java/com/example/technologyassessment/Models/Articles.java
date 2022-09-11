package com.example.technologyassessment.Models;

public class Articles {

    String author,title,discription,url,urlToImage,publishedAt,content;
    Source source;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return urlToImage;
    }

    public void setImage(String image) {
        this.urlToImage = image;
    }

    public String getPubat() {
        return publishedAt;
    }

    public void setPubat(String pubat) {
        this.publishedAt = pubat;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
