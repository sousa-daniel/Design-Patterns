package ChainofResponsability;

/**
 * Processor
 */
public interface Processor {

    void setNextProcessor(Processor processor);
    void process(int value);
}