package com.adminPanel.app.service;

import com.adminPanel.app.entity.Product;

import java.util.List;

public interface ProductService {
    void saveProduct(Product product);
    void deleteProduct(int id);
    void updateProduct(Product product,int id);
    Product getProduct(int id);
    List<Product> getProducts();
}
