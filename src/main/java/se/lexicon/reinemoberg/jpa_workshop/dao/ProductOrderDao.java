package se.lexicon.reinemoberg.jpa_workshop.dao;

import se.lexicon.reinemoberg.jpa_workshop.entity.ProductOrder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductOrderDao {

    //Basic CRUD
    ProductOrder create(ProductOrder productOrder);

    ProductOrder findById(int id);

    List<ProductOrder> findAll();

    void remove(int id);

    ProductOrder update(ProductOrder productOrder);

    List<ProductOrder> saveAll(List<ProductOrder> productOrders);

    //Custom CRUD
    List<ProductOrder> findByDateTime(LocalDateTime dateTime);

    List<ProductOrder> findByProductId(int productId);

    List<ProductOrder> findByAppUserId(int appUserId);
}
