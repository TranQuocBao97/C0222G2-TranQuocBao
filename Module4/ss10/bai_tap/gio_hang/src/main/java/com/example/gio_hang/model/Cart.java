package com.example.gio_hang.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product,Integer> products) {
        this.products = products;
    }

    public Map<Product,Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }
    public void minusProduct(Product product){
        if(selectItemInCart(product).getValue().equals(0)){
            products.remove(product);
        }
        else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() - 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }

    public Double countTotalPrice(){
        double totalPrice = 0d;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }
    public Double countTotalEachProductById(Integer id){
        double totalPriceByProduct = 0d;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(id)){
                totalPriceByProduct += entry.getKey().getPrice() * entry.getValue();
                break;
            }
        }
        return totalPriceByProduct;
    }
}