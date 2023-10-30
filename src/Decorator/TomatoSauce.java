package Decorator;

class TomatoSauce extends PizzaDecorator {

    public TomatoSauce(Pizza pizza) {
        super(pizza);
    }
    
    public String getDescription() {
        return pizza.getDescription() + ", tomato sauce";
    }

    public double getCost() {
        return pizza.getCost() + 0.35;
    }
  }