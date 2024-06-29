package br.qziul.restful.model;

import jakarta.persistence.*;

@Entity(name = "tb_news")
public class News extends BaseItem {
    public News(){}
    public News(String icon, String description) {
        this.icon = icon;
        this.description = description;
    }
}
