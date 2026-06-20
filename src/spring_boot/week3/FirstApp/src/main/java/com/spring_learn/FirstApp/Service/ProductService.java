package com.spring_learn.FirstApp.Service;

import com.spring_learn.FirstApp.Model.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Products> products= new ArrayList<>(Arrays.asList(
            new Products(101,"Iphone", 50000),
            new Products(102,"Android", 30000),
            new Products(103,"Lava", 20000)));

    public List<Products> getProducts(){
        return products;
    }

    public Products getProductsById(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId()== prodId)
                .findFirst().orElse(new Products(100, "No Item", 0));
    }

    public void addProducts(Products prod){
        products.add(prod);
    }


}
