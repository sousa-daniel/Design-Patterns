package Builder;

public class ItalianPizzaBuilder extends PizzaBuilder {
    
    public void buildPasta() {
        this.thePizza.setPasta("Soft");
    }

    public void buildSauce() {
        this.thePizza.setSauce("Tomato");
    }

    public void buildFilling() {
        this.thePizza.setFilling("Chorizo");
    }
}
