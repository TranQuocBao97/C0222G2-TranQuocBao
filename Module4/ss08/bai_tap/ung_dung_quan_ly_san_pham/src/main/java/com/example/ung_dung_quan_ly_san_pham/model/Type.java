package com.example.ung_dung_quan_ly_san_pham.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer id;
    private String name;

    public Type() {
    }

    public Type(Integer id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Type(Integer id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "type")
    private List<Product> products;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
