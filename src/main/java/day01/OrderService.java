package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public List<Order> filterOrderByStatus(String status) {
        return orders.stream()
                .filter(o -> o.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public long countOrdersByStatus(String status) {
        return orders.stream()
                .filter(o -> o.getStatus().equals(status))
                .count();
    }

    public List<Order> findOrdersBetweenDates(LocalDate from, LocalDate to) {
        return orders.stream()
                .filter(o -> (o.getOrderDate().isAfter(from) && o.getOrderDate().isBefore(to)))
                .collect(Collectors.toList());
    }

    public boolean isThereLessProduct(int number) {
        return orders.stream()
                .anyMatch(o -> o.getProducts().size() < number);
    }

    public Order findOrderWithMostProduct() {
        return orders.stream()
                .max((o1, o2) -> o1.getProducts().size() - o2.getProducts().size())
                .orElseThrow();
    }

    public List<Order> findOrdersWithProductCategory(String category) {
        return orders.stream()
                .filter(o -> (o.getProducts().stream()
                        .anyMatch(p -> category.equals(p.getCategory())))
                ).collect(Collectors.toList());
    }
}
