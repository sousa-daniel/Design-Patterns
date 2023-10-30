package Prototype;

public class TestPrototype {
    
    public static void main(String[] args) {
        
        Bill eb = BillRegistry.getElectricityBill().clone();
        eb.cost = 120;

        eb.printDescription();
    }
}
