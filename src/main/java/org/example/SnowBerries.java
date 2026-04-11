package org.example;

class SnowBerries extends DishDecorator {
    public SnowBerries(Dish base) {
        super(base);
    }

    @Override
    public String getName() {
        return base.getName() + " + Ягоды";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 6;
    }
}
