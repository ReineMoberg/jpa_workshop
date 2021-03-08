package se.lexicon.reinemoberg.jpa_workshop.entity;

import javax.persistence.*;
import java.text.NumberFormat;
import java.util.Objects;

@Entity  //Define class as database entity (Table)
public class Product {

    @Id                                                 //Primary key for the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Means auto_increment
    private int productId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Double.compare(product.price, price) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price);
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + numberFormat.format(price) +
                '}';
    }
}
