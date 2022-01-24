package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService;

    @BeforeEach
    void init() {
        orderService = new OrderService();

        Product p1 = new Product("Tv", "IT", 2000);
        Product p2 = new Product("Laptop", "IT", 2400);
        Product p3 = new Product("Phone", "IT", 400);
        Product p4 = new Product("Lord of The Rings", "Book", 20);
        Product p5 = new Product("Harry Potter Collection", "Book", 120);

        Order o1 = new Order("pending", LocalDate.of(2021, 06, 07));
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.addProduct(p5);

        Order o2 = new Order("on delivery", LocalDate.of(2021, 06, 01));
        o2.addProduct(p3);
        o2.addProduct(p1);
        o2.addProduct(p2);
        o2.addProduct(p4);
        o2.addProduct(p4);

        Order o3 = new Order("pending", LocalDate.of(2021, 06, 07));
        o3.addProduct(p1);
        o3.addProduct(p2);
        o3.addProduct(p5);

        Order o4 = new Order("on delivery", LocalDate.of(2021, 06, 01));
        o4.addProduct(p3);
        o4.addProduct(p1);
        o4.addProduct(p2);

        Order o5 = new Order("pending", LocalDate.of(2021, 06, 07));
        o5.addProduct(p1);
        o5.addProduct(p2);
        o5.addProduct(p5);

        orderService.saveOrder(o1);
        orderService.saveOrder(o2);
        orderService.saveOrder(o3);
        orderService.saveOrder(o4);
        orderService.saveOrder(o5);
    }

    @Test
    void testFilterOrderByStatus() {
        assertEquals(3, orderService.filterOrderByStatus("pending").size());
        assertEquals(2, orderService.filterOrderByStatus("on delivery").size());
    }

    @Test
    void testCountOrdersByStatus() {
        assertEquals(3, orderService.countOrdersByStatus("pending"));
        assertEquals(2, orderService.countOrdersByStatus("on delivery"));
    }

    @Test
    void testFindOrdersBetweenDates() {
        assertEquals(3, orderService.findOrdersBetweenDates(LocalDate.parse("2021-06-02"), LocalDate.parse("2021-06-10")).size());
        assertEquals(2, orderService.findOrdersBetweenDates(LocalDate.parse("2021-05-02"), LocalDate.parse("2021-06-03")).size());
    }

    @Test
    void testIsThereLessProduct() {
        assertTrue(orderService.isThereLessProduct(4));
        assertFalse(orderService.isThereLessProduct(2));
    }

    @Test
    void testFindOrderWithMostProduct() {
        assertEquals(orderService.getOrders().get(1), orderService.findOrderWithMostProduct());
        assertNotEquals(orderService.getOrders().get(0), orderService.findOrderWithMostProduct());
    }

    @Test
    void testFindOrdersWithProduct() {
        assertEquals(4, orderService.findOrdersWithProductCategory("Book").size());
        assertEquals(5, orderService.findOrdersWithProductCategory("IT").size());
    }
}