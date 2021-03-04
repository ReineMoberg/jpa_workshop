package se.lexicon.reinemoberg.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductTest {

    Product testProduct;

    @BeforeEach
    public void setup() {
        testProduct = new Product();
        testProduct.setProductId(1);
        testProduct.setName("Brake disc");
        testProduct.setPrice(1125.00);
    }

    @Test
    @DisplayName("Create product object")
    public void testCreateProduct() {
        Assertions.assertEquals(1, testProduct.getProductId());
        Assertions.assertEquals("Brake disc", testProduct.getName());
        Assertions.assertEquals(1125.00, testProduct.getPrice());
    }

    @Test
    @DisplayName("Equals method")
    public void testEqualsMethod() {
        Product expectedProduct = new Product();
        expectedProduct.setProductId(1);
        expectedProduct.setName("Brake disc");
        expectedProduct.setPrice(1125.00);
        Assertions.assertEquals(expectedProduct, testProduct);
    }

    @Test
    @DisplayName("Hash code method")
    public void testHashCode() {
        Product expectedProduct = new Product();
        expectedProduct.setProductId(1);
        expectedProduct.setName("Brake disc");
        expectedProduct.setPrice(1125.00);
        Assertions.assertEquals(expectedProduct.hashCode(), testProduct.hashCode());
    }

    @Test
    @DisplayName("To string method")
    public void testToString() {
        System.out.println(testProduct.toString());
    }
}
