package Flyweight;

public class Terrorist implements Player {
    
    // Intrinsic attribute
    private final String TASK;

    // Extrinsic attribute
    private String weapon;

    public Terrorist() {
        TASK = "PLANT A BOMB!";
    }

    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void mission() {
        System.out.println("Terrorist with weapon " + weapon + "| Task is " + TASK);
    }

}
