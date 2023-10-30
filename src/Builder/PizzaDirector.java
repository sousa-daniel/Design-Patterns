package Builder;

public class PizzaDirector {
    
    private PizzaBuilder pizzaBuilder = null;
    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public void buildPizza_step1() {
        pizzaBuilder.createNewPizza();
        pizzaBuilder.buildPasta();
    }

    public void buildPizza_step2() {
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildFilling();
    }

    public Pizza fetchPizza() {
        return pizzaBuilder.thePizza;
    }
}
