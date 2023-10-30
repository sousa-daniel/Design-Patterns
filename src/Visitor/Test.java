package Visitor;

/*
 * The Visitor design pattern that lets you separate algorithms from the objects on which they operate.
 * 
 * It enables us to add functionalities without modifying the structure itself.
 * 
 * Instead of storing operations in the client classes themselves, we keep them in the visitors. Each visitor
 * can have a different operation to execute when they visit a client and they have access to all the info
 * through the client object that is passed as param. 
 */

import java.util.ArrayList;
import java.util.List;

import Visitor.Clients.Hospital;
import Visitor.Clients.Hotel;
import Visitor.Clients.Restaurant;

public class Test {
    

    public static void main(String[] args) {
        
        // Initialize Clients
        Restaurant restaurant = new Restaurant("3Rings", 20);
        Hotel hotel = new Hotel("Mirage", 500);
        Hospital hospital = new Hospital("Saint Mary", 350);

        List<Client> clients = new ArrayList<Client>();

        clients.add(restaurant);
        clients.add(hotel);
        clients.add(hospital);

        // Initialize visitors
        InspectionVisitor inspector = new InspectionVisitor();

        inspector.sendReports(clients);
    }
}
