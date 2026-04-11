package org.example;

class FireSauce extends DishDecorator {
    public FireSauce(Dish base) {
        super(base);
    }

    @Override
    public String getName() {
        return base.getName() + " + Соус";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 40;
    }
}
