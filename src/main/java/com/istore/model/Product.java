package com.istore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer aid;

    @ManyToOne
    @JoinColumn(name = "id")
    private Category category;

    @Column
    private String title;

    @Column
    private Integer amount;

    @Column
    private Double price;

    public Product() {
    }

    public Product(Integer id, Integer aid, Category category, String title, Integer amount, Double price) {
        this.id = id;
        this.aid = aid;
        this.category = category;
        this.title = title;
        this.amount = amount;
        this.price = price;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAid() {
        return this.aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}