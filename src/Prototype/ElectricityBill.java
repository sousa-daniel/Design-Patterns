package Prototype;

public class ElectricityBill extends Bill {

    // Other attributes ...

    public void printDescription() {
        System.out.println("##########  Electricity Bill  #########"
                    + "\n###"
                    + "\n### Cost: " + this.cost + "$\n");
    }
    
}
