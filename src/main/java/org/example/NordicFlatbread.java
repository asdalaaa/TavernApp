package org.example;

class NordicFlatbread extends DishDecorator {
    public NordicFlatbread(Dish base) {
        super(base);
    }

    @Override
    public String getName() {
        return base.getName() + " + Лепёшка";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 7;
    }
}
