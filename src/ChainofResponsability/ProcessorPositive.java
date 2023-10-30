package ChainofResponsability;

public class ProcessorPositive extends AbstractProcessor {

    public boolean process(int value) {
        // Do something
        if (value > 0) {
            System.out.println("Accepted by Positive Processor : " + value);
            return true;
        }
        System.out.println("Rejected by Positive Processor");
        return false;
    }
}
