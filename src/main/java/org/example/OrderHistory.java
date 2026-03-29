package org.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OrderHistory {
    private final List<OrderEntry> entries = new ArrayList<>();

    void add(Dish dish) {
        entries.add(OrderEntry.of(dish));
    }

    List<OrderEntry> all() {
        return Collections.unmodifiableList(entries);
    }
}

record OrderEntry(String time, String name, int price) {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("HH:mm:ss");

    static OrderEntry of(Dish dish) {
        return new OrderEntry(
                LocalTime.now().format(FMT),
                dish.getName(),
                dish.getPrice()
        );
    }

    @Override
    public String toString() {
        return "[%s] %s — %d септимов".formatted(time, name, price);
    }
}
