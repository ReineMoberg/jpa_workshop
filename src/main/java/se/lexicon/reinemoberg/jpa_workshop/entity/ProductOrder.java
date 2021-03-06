package se.lexicon.reinemoberg.jpa_workshop.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ProductOrder {

    @Id                                                 //Primary key for the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Means auto_increment
    private int productOrderId;
    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDateTime orderDateTime;
    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            orphanRemoval = true,
            mappedBy = "productOrder")
    private List<OrderItem> orderItemList;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "app_user_id")
    private AppUser customer;

    public ProductOrder() {
    }

    public ProductOrder(LocalDateTime orderDateTime, AppUser customer) {
        this.orderDateTime = orderDateTime;
        this.customer = customer;
    }

    public ProductOrder(LocalDateTime orderDateTime, List<OrderItem> orderItemList, AppUser customer) {
        this.orderDateTime = orderDateTime;
        this.orderItemList = orderItemList;
        this.customer = customer;
    }

    public ProductOrder(int productOrderId, LocalDateTime orderDateTime, List<OrderItem> orderItemList, AppUser customer) {
        this.productOrderId = productOrderId;
        this.orderDateTime = orderDateTime;
        this.orderItemList = orderItemList;
        this.customer = customer;
    }

    public ProductOrder(int productOrderId, LocalDateTime orderDateTime, AppUser customer) {
        this.productOrderId = productOrderId;
        this.orderDateTime = orderDateTime;
        this.customer = customer;
    }

    public void addOrderItem(OrderItem orderItem) {
        if (orderItemList == null) {
            orderItemList = new ArrayList<>();
        }
        orderItemList.add(orderItem);
        orderItem.setProductOrder(this);
    }

    public void removeOrderItem(OrderItem orderItem) {
        if (orderItemList != null) {
            orderItemList = new ArrayList<>();
        }
        if (orderItem == null) {
            throw new IllegalArgumentException("orderItem is null");
        }
        orderItemList.remove(orderItem);
        orderItem.setProductOrder(null);
    }

    public double totalPrice() {
        return orderItemList.stream()
                .map(OrderItem::price)
                .reduce(0d, Double::sum);
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
