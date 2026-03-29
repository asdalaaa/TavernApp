package org.example;

public abstract class IngredientDecorator implements Dish {

    private final Dish dish;

    protected IngredientDecorator(Dish dish) {
        this.dish = dish;
    }

    protected String baseName() {
        return dish.getName();
    }

    protected int basePrice() {
        return dish.getPrice();
    }
}
