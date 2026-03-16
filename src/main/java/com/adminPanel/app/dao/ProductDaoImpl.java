package com.adminPanel.app.dao;

import com.adminPanel.app.entity.Product;
import com.adminPanel.app.entity.ProductDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
    SessionFactory sessionFactory ;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory ;
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveProduct(Product product) {
        getCurrentSession().persist(product);
    }

    @Override
    public void deleteProductById(int id) {
        Product product = getCurrentSession().get(Product.class , id);
        if(product != null){
            getCurrentSession().delete(product);
        }
    }

    @Override
    public void updateProductById(Product newProduct, int id) {
        Product product = getCurrentSession().get(Product.class , id);
        if(product != null){
            product.setName(newProduct.getName());

            ProductDetails oldDetails = product.getProductDetails();
            ProductDetails newDetails = newProduct.getProductDetails();

            oldDetails.setExpiration_date(newDetails.getExpiration_date());
            oldDetails.setPrice(newDetails.getPrice());
            oldDetails.setPhoto(newDetails.getPhoto());
            oldDetails.setManufacturer(newDetails.getManufacturer());
            oldDetails.setAvailable(oldDetails.isAvailable());
        }
    }

    @Override
    public Product getById(int id) {
        return getCurrentSession().get(Product.class,id);
    }

    @Override
    public List<Product> getAllProducts() {
        Query<Product> query =
                getCurrentSession().createQuery("from Product", Product.class);
        return query.getResultList();
    }
}
