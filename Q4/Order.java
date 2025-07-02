package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {
    @Id
    private Long id;
    private String item;

    public Order() {}

    public Order(Long id, String item) {
        this.id = id;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
