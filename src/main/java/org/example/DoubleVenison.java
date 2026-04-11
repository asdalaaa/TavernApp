package org.example;

class DoubleVenison extends DishDecorator {
    public DoubleVenison(Dish base) {
        super(base);
    }

    @Override
    public String getName() {
        return base.getName() + " + Оленина";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 20;
    }
}
