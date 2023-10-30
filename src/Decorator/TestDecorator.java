package Decorator;

class TestDecorator {

    public static void main(String[] args) {
        
      Pizza pizza = new Mozzarella(new TomatoSauce(new PlainPizza()));
      System.out.println(pizza.getDescription() + " $" + pizza.getCost());
    }
}