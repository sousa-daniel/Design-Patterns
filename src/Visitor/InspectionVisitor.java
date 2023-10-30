package Visitor;

import java.util.List;

import Visitor.Clients.Hospital;
import Visitor.Clients.Hotel;
import Visitor.Clients.Restaurant;

public class InspectionVisitor implements Visitor {

    public void sendReports(List<Client> clients) {
        for (Client client : clients) {
            client.accept(this);
        }
    }

    @Override
    public void visit(Restaurant restaurant) {
        System.out.println("Sending report of the latest inspection to the Restaurant: " + restaurant.getName());
        
    }

    @Override
    public void visit(Hotel hotel) {
        System.out.println("Sending report of the latest inspection to the Hotel: " + hotel.getName());
        
    }

    @Override
    public void visit(Hospital hospital) {
        System.out.println("Sending report of the latest inspection to the Hospital: " + hospital.getName());
        
    }
}
