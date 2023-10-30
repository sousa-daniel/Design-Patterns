package Prototype;

import java.util.ArrayList;
import java.util.List;

public abstract class Bill implements Cloneable {

    protected static List<Bill> billsList = new ArrayList<Bill>();
    protected double cost;

    // Other attributes ...

    public abstract void printDescription();
    
    public Bill clone() {

        try {
            Bill theCopy = (Bill) super.clone();
            billsList.add(theCopy);
            return theCopy;
        } catch (CloneNotSupportedException e) {
            return null;
        }

    }
}
