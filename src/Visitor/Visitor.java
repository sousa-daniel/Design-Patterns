package Visitor;

import Visitor.Clients.Hospital;
import Visitor.Clients.Hotel;
import Visitor.Clients.Restaurant;

public interface Visitor {
    
    void visit(Restaurant restaurant);
    void visit(Hotel hotel);
    void visit(Hospital hospital);
}
