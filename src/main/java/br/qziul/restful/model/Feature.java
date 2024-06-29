package br.qziul.restful.model;

import jakarta.persistence.*;

@Entity(name = "tb_feature")
public class Feature extends BaseItem {
    public Feature(){}
    public Feature(String icon, String description) {
        this.icon = icon;
        this.description = description;
    }
}
