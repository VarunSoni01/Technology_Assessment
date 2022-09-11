package com.example.technologyassessment.Models;

import java.util.List;

public class Model {
    List<Articles> articles;

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public Model(List<Articles> articles) {
        this.articles = articles;
    }
}
