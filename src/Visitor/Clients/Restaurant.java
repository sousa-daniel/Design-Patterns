package Visitor.Clients;

import Visitor.Client;
import Visitor.Visitor;

public class Restaurant extends Client {
    
    private final float rating;

    public Restaurant(String name, float rating) {
        super(name);
        this.rating = rating;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
