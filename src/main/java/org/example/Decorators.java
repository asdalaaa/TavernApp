package org.example;

abstract class Ingredient implements Dish {
    protected Dish base;
    Ingredient(Dish base) { this.base = base; }
}

class FireSauce extends Ingredient {
    FireSauce(Dish base) { super(base); }
    public String getName() { return base.getName() + " + Соус"; }
    public int getPrice() { return base.getPrice() + 40; }
}

class DoubleVenison extends Ingredient {
    DoubleVenison(Dish base) { super(base); }
    public String getName() { return base.getName() + " + Оленина"; }
    public int getPrice() { return base.getPrice() + 20; }
}

class SnowBerries extends Ingredient {
    SnowBerries(Dish base) { super(base); }
    public String getName() { return base.getName() + " + Ягоды"; }
    public int getPrice() { return base.getPrice() + 6; }
}

class NordicFlatbread extends Ingredient {
    NordicFlatbread(Dish base) { super(base); }
    public String getName() { return base.getName() + " + Лепёшка"; }
    public int getPrice() { return base.getPrice() + 7; }
}
