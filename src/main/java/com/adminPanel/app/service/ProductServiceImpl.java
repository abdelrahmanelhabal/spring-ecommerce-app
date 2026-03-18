package com.adminPanel.app.service;

import com.adminPanel.app.dao.ProductDao;
import com.adminPanel.app.dao.ProductDaoImpl;
import com.adminPanel.app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    ProductDao  productDao ;

    @Autowired
    public ProductServiceImpl(ProductDao productDao){
        this.productDao = productDao ;
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        Product product = productDao.getById(id);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        productDao.deleteProductById(id);
    }

    @Override
    public void updateProduct(Product product , int id) {
        Product oldProduct = productDao.getById(id);
        String oldPhoto = oldProduct.getProductDetails().getPhoto();
        String newPhoto = product.getProductDetails().getPhoto();
        if(newPhoto == null || newPhoto.trim().isEmpty()){
            product.getProductDetails().setPhoto(oldPhoto);
        }
        productDao.updateProductById(product,id);
    }
    @Override
    public void saveOrUpdate(Product product){
        if(product.getId() == 0){
            saveProduct(product);
        }
        else{
            updateProduct(product,product.getId());
        }
    }

    @Override
    public Product getProduct(int id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> getProducts() {
        return productDao.getAllProducts();
    }

}
