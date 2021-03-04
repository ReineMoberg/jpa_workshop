package se.lexicon.reinemoberg.jpa_workshop.entity;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

//@Entity
public class ProductOrder {

    private int productOrderId;
    LocalDateTime orderDateTime;
    List<OrderItem> orderItemList;
    AppUser customer;

    public ProductOrder() {
    }

    public int getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(int productOrderId) {
        this.productOrderId = productOrderId;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public AppUser getCustomer() {
        return customer;
    }

    public void setCustomer(AppUser customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrder that = (ProductOrder) o;
        return productOrderId == that.productOrderId && Objects.equals(orderDateTime, that.orderDateTime) && Objects.equals(orderItemList, that.orderItemList) && Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productOrderId, orderDateTime, orderItemList, customer);
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "productOrderId=" + productOrderId +
                ", orderDateTime=" + orderDateTime +
                ", orderItemList=" + orderItemList +
                ", customer=" + customer +
                '}';
    }
}
