package ChainofResponsability;

public class ProcessorNegative extends AbstractProcessor{
    
    public boolean process(int value) {
        // Do something
        if (value < 0) {
            System.out.println("Accepted by Negative Processor : " + value);
            return true;
        }
        System.out.println("Rejected by Negative Processor");
        return false;
    }
}
