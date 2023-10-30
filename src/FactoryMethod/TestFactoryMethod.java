package FactoryMethod;

public class TestFactoryMethod {
    
    public static void main(String[] args) {

        BeefBurgerRestaurant bbr = new BeefBurgerRestaurant();
        Burger burger = bbr.orderBurger();
    }
}
