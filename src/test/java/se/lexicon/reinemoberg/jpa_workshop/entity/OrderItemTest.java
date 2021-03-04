package se.lexicon.reinemoberg.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderItemTest {

    OrderItem testOrderItem;
    Product testProduct;
    ProductOrder testProductOrder;

    @BeforeEach
    public void setup() {
        testProduct = new Product();
        testProduct.setProductId(1);
        testProduct.setName("Brake disc");
        testProduct.setPrice(1125.00);
        testProductOrder = null;
        testOrderItem = new OrderItem();
        testOrderItem.setOrderItemId(1);
        testOrderItem.setQuantity(2);
        testOrderItem.setProduct(testProduct);
        testOrderItem.setProductOrder(testProductOrder);
    }

    @Test
    @DisplayName("Create order item object")
    public void testCreateOrderItem() {
        Assertions.assertEquals(1, testOrderItem.getOrderItemId());
        Assertions.assertEquals(2, testOrderItem.getQuantity());
        Assertions.assertEquals(testProduct, testOrderItem.getProduct());
        Assertions.assertEquals(testProductOrder, testOrderItem.getProductOrder());
    }

    @Test
    @DisplayName("Equals method")
    public void testEqualsmethod() {
        OrderItem expectedOrderItem = new OrderItem();
        expectedOrderItem.setOrderItemId(1);
        expectedOrderItem.setQuantity(2);
        expectedOrderItem.setProduct(testProduct);
        expectedOrderItem.setProductOrder(testProductOrder);
        Assertions.assertEquals(expectedOrderItem, testOrderItem);
    }

    @Test
    @DisplayName("Hash code method")
    public void testHashCodeMethod() {
        OrderItem expectedOrderItem = new OrderItem();
        expectedOrderItem.setOrderItemId(1);
        expectedOrderItem.setQuantity(2);
        expectedOrderItem.setProduct(testProduct);
        expectedOrderItem.setProductOrder(testProductOrder);
        Assertions.assertEquals(expectedOrderItem.hashCode(), testOrderItem.hashCode());
    }

    @Test
    @DisplayName("To string method")
    public void testToStringMethod() {
        System.out.println(testOrderItem.toString());
    }

    @Test
    @DisplayName("Price method")
    public void testPriceMethod() {
        Assertions.assertEquals((1125.00 * 2), testOrderItem.price());
    }
}
