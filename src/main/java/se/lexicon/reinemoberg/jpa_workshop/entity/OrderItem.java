package se.lexicon.reinemoberg.jpa_workshop.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity //Define class as database entity (Table)
public class OrderItem {

    @Id                                                 //Primary key for the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Means auto_increment
    private int orderItemId;
    @Column(nullable = false, columnDefinition = "integer default 0")
    private int quantity;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "product_order_id")
    private ProductOrder productOrder;

    public OrderItem() {
    }

    public double price() {
        return (quantity * product.getPrice());
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderItemId == orderItem.orderItemId && quantity == orderItem.quantity && Objects.equals(product, orderItem.product) && Objects.equals(productOrder, orderItem.productOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemId, quantity, product, productOrder);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", quantity=" + quantity +
                ", product=" + product +
                ", productOrder=" + productOrder +
                '}';
    }
}
