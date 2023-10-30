package Observer;

public class TestObserver {
    
    public static void main(String[] args) {
        
        Subject product = new Subject();

        new BinaryObserver(product); // Receives notification change in binary code
        new HexaObserver(product);   // Receives notification change in hex code

        System.out.println("First product price change: 15$");
        product.setState(15);
    }
}
