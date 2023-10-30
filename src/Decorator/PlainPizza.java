package Decorator;

class PlainPizza implements Pizza {

    public String getDescription() {
        return "Thin dough";
    }
    public double getCost() {
        return 4.00;
    }
}