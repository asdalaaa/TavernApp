package org.example;

abstract class DishDecorator implements Dish {
    protected Dish base;
    public DishDecorator(Dish base) {
        this.base = base;
    }
    @Override
    public String getName() {
        return base.getName();
    }
    @Override
    public int getPrice() {
        return base.getPrice();
    }
}
