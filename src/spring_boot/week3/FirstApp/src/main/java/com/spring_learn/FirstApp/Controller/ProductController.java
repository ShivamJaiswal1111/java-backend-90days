package com.spring_learn.FirstApp.Controller;

import com.spring_learn.FirstApp.Model.Products;
import com.spring_learn.FirstApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/products")
    public List<Products> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    public Products getProductsById(@PathVariable int prodId){
        return service.getProductsById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Products prod){
        service.addProducts(prod);
    }
}
