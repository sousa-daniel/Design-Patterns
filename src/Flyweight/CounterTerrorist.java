package Flyweight;

public class CounterTerrorist implements Player {
    
    // Intrinsic attribute
    private final String TASK;

    // Extrinsic attribute
    private String weapon;

    public CounterTerrorist() {
        TASK = "DIFFUSE BOMB!";
    }

    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void mission() {
        System.out.println("Counter Terrorist with weapon " + weapon + "| Task is " + TASK);
    }

}