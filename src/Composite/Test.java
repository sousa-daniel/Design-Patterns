package Composite;

/*
 * The Composite design pattern only makes sense if our model can be represented as a tree.
 * 
 * The core idea is creating a an interface, common to our objects.
 * 
 * In the example below we have products and boxes, which have a common interface Box. The benefit of doing this, is that we
 * don't have to care whether an object is just a product or a box.
 * 
 */

public class Test {
    
    public static void main(String[] args) {
        
        // Create composite box with all the contents
        CompositeBox finalBox = new CompositeBox(
                new CompositeBox(
                    new Book("HP1", 25)
                ),
                new CompositeBox(
                    new Book("HP2",30)
                ),
                new Toy("Airplane", 15)
        );

        // Calculate price
        System.out.println("The total price of the contents in the box is: " + finalBox.calculatePrice());
    }
}
