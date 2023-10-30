package ChainofResponsability;

public class Test {
    
    public static void main(String[] args) {
        
        // Create Handlers
        AbstractProcessor p1 = new ProcessorPositive();
        AbstractProcessor p2 = new ProcessorNegative();
        AbstractProcessor p3 = new ProcessorZero();
        
        // Define Chain of handlers
        p1.setNext(p2);
        p2.setNext(p3);

        p1.start(0);
    }
}
