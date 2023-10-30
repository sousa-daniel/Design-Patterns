package FactoryMethod;

public class BeefBurgerRestaurant extends Restaurant {
    
    public Burger createBurger() {
        return new BeefBurger();
    }
}
