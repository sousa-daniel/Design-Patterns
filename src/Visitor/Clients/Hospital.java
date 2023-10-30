package Visitor.Clients;

import Visitor.Client;
import Visitor.Visitor;

public class Hospital extends Client {
    
    private final float capacity;

    public Hospital(String name, float capacity) {
        super(name);
        this.capacity = capacity;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
