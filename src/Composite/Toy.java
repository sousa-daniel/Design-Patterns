package Composite;

public class Toy extends Product {
    
    public Toy(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice() {
        return getPrice();
    }
}