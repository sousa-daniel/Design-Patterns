package Builder;

public class TestBuilder {
    
    public static void main(String[] args) {
        
        Pizza pizza = null;
        PizzaDirector dir = new PizzaDirector();
        dir.setPizzaBuilder(new ItalianPizzaBuilder());
        
        dir.buildPizza_step1();
        dir.buildPizza_step2();
        pizza = dir.fetchPizza();

        pizza.getDescription();
    }
}
