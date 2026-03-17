package com.adminPanel.app.dao;

import com.adminPanel.app.entity.Product;
import java.util.List;

public interface ProductDao {
    void saveProduct(Product product);
    void deleteProductById(int id);
    void updateProductById(Product product , int id);
    Product getById(int id);
    List<Product> getAllProducts();
}
