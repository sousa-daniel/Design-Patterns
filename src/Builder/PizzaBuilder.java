package Builder;

public abstract class PizzaBuilder {
    
    protected Pizza thePizza;

    public void createNewPizza() {
        thePizza = new Pizza();
    }

    public abstract void buildPasta();
    public abstract void buildSauce();
    public abstract void buildFilling();

    public Pizza getResult() {
        return thePizza;
    }
}
