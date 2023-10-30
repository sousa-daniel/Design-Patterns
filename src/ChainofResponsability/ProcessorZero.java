package ChainofResponsability;

public class ProcessorZero extends AbstractProcessor {

    public boolean process(int value) {
        // Do something
        if (value == 0) {
            System.out.println("Accepted by Zero Processor : " + value);
            return true;
        }
        System.out.println("Rejected by Zero Processor");
        return false;
    }
}
