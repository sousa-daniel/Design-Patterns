package Decorator;

class Mozzarella extends PizzaDecorator {

    public Mozzarella(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", mozzarella";
    }

    public double getCost() {
        return pizza.getCost() + 0.50;
    }
}