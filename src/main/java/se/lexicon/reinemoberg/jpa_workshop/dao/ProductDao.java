package se.lexicon.reinemoberg.jpa_workshop.dao;

import se.lexicon.reinemoberg.jpa_workshop.entity.Product;

import java.util.List;

public interface ProductDao {

    //Basic CRUD
    Product create(Product product);

    Product findById(int id);

    List<Product> findAll();

    void remove(int id);

    Product merge(Product product);

    List<Product> saveAllProducts(List<Product> products);

    //Custom CRUD
    List<Product> findProductByName(String productName);
}
