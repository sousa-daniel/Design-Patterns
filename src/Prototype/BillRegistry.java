package Prototype;

public abstract class BillRegistry {
    
    private static Bill electricityBill = new ElectricityBill();


    public static Bill getElectricityBill() {
        return electricityBill;
    }
}
