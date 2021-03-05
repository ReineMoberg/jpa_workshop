package se.lexicon.reinemoberg.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductOrderTest {

    ProductOrder testProductOrder;
    LocalDateTime currentDateTime;
    List<OrderItem> testOrderItemList;
    AppUser testCustomer;

    Product testProduct1;
    Product testProduct2;
    OrderItem testOrderItem1;
    OrderItem testOrderItem2;

    @BeforeEach
    public void setup() {
        currentDateTime = LocalDateTime.now();

        testCustomer = new AppUser();
        testCustomer.setAppUserId(1);
        testCustomer.setFirstName("Reine");
        testCustomer.setLastName("Moberg");
        testCustomer.setEmail("mail.mail@gmail.com");

        testProduct1 = new Product();
        testProduct1.setProductId(1);
        testProduct1.setName("Brake disc");
        testProduct1.setPrice(1125.00);

        testProduct2 = new Product();
        testProduct2.setProductId(2);
        testProduct2.setName("Brake pads");
        testProduct2.setPrice(600.00);

        testOrderItem1 = new OrderItem();
        testOrderItem1.setOrderItemId(1);
        testOrderItem1.setQuantity(2);
        testOrderItem1.setProduct(testProduct1);
        testOrderItem1.setProductOrder(testProductOrder);

        testOrderItem2 = new OrderItem();
        testOrderItem2.setOrderItemId(2);
        testOrderItem2.setQuantity(1);
        testOrderItem2.setProduct(testProduct2);
        testOrderItem2.setProductOrder(testProductOrder);

        testOrderItemList = new ArrayList<>();
        testOrderItemList.add(testOrderItem1);
        testOrderItemList.add(testOrderItem2);

        testProductOrder = new ProductOrder();
        testProductOrder.setProductOrderId(1);
        testProductOrder.setOrderDateTime(currentDateTime);
        testProductOrder.setCustomer(testCustomer);
        testProductOrder.setOrderItemList(testOrderItemList);
    }

    @Test
    @DisplayName("Create product order object")
    public void testCreateProductOrder() {
        Assertions.assertEquals(1, testProductOrder.getProductOrderId());
        Assertions.assertEquals(testCustomer, testProductOrder.getCustomer());
        Assertions.assertEquals(testOrderItemList, testProductOrder.getOrderItemList());
    }

    @Test
    @DisplayName("Equals method")
    public void testEqualsMethod() {
        ProductOrder expectedProductOrder = new ProductOrder();
        expectedProductOrder.setProductOrderId(1);
        expectedProductOrder.setOrderDateTime(currentDateTime);
        expectedProductOrder.setCustomer(testCustomer);
        expectedProductOrder.setOrderItemList(testOrderItemList);
        Assertions.assertEquals(expectedProductOrder, testProductOrder);
    }

    @Test
    @DisplayName("Hash code method")
    public void testHashCodeMethod() {
        ProductOrder expectedProductOrder = new ProductOrder();
        expectedProductOrder.setProductOrderId(1);
        expectedProductOrder.setOrderDateTime(currentDateTime);
        expectedProductOrder.setCustomer(testCustomer);
        expectedProductOrder.setOrderItemList(testOrderItemList);
        Assertions.assertEquals(expectedProductOrder.hashCode(), testProductOrder.hashCode());
    }

    @Test
    @DisplayName("To string method")
    public void testToStringMethod() {
        System.out.println(testProductOrder.toString());
    }

    @Test
    @DisplayName("Total price")
    public void testTotalPrice() {
        Assertions.assertEquals((2 * 1125) + 600, testProductOrder.totalPrice());
    }

    @Test
    @DisplayName("Remove order item")
    public void testRemoveOrderItem() {
        List<OrderItem> expectedOrderItemList = new ArrayList<>();
        expectedOrderItemList.add(testOrderItem1);
        testProductOrder.removeOrderItem(testOrderItem2);
        Assertions.assertEquals(expectedOrderItemList,testProductOrder.getOrderItemList());
        System.out.println(expectedOrderItemList);
        System.out.println(testProductOrder.getOrderItemList());
    }

    @Test
    @DisplayName("Add order item")
    public void testAddOrderItem() {
        OrderItem testOrderItem3 = new OrderItem();
        testOrderItem3.setOrderItemId(3);
        testOrderItem3.setQuantity(1);
        testOrderItem3.setProduct(testProduct2);
        testOrderItem3.setProductOrder(testProductOrder);
        List<OrderItem> expectedOrderItemList = new ArrayList<>();
        expectedOrderItemList.add(testOrderItem1);
        expectedOrderItemList.add(testOrderItem2);
        expectedOrderItemList.add(testOrderItem3);
        testProductOrder.addOrderItem(testOrderItem3);
        Assertions.assertEquals(expectedOrderItemList, testProductOrder.getOrderItemList());
        Assertions.assertEquals(3, expectedOrderItemList.size());
        Assertions.assertEquals(3, testProductOrder.getOrderItemList().size());

        //Can't print lists after .addOrderItem() call. Infinite reference loop?
        //testProductOrder is null?
        //System.out.println(expectedOrderItemList);
        //System.out.println(testProductOrder.getOrderItemList());
    }
}
