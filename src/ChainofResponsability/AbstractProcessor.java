package ChainofResponsability;

public abstract class AbstractProcessor {
    
    private AbstractProcessor next = null;

    public void setNext(AbstractProcessor processor) {
        next = processor;
    }

    protected abstract boolean process(int value);

    public final boolean start(int value) {
        boolean processed = this.process(value);
        if ((!processed) && (next != null)) {
            processed = next.start(value);
        }
        return processed;
    }
}
