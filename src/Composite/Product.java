package Composite;

public abstract class Product implements Box {
    protected String name;
    protected double price;

    protected Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    
}
