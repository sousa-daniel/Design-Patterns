package Visitor.Clients;

import Visitor.Client;
import Visitor.Visitor;

public class Hotel extends Client {
    
    private final float capacity;

    public Hotel(String name, float capacity) {
        super(name);
        this.capacity = capacity;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
