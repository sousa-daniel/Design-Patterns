package Command;

public class Test {

    public static void main(String[] args) {
        
        // Define house lights
        Light kitchenLight = new Light("Kitchen");
        Light livingLight = new Light("Living room");

        // Define commands
        LightOn_Command kitchenOn = new LightOn_Command(kitchenLight);
        LightOff_Command kitchenOff = new LightOff_Command(kitchenLight);
        LightOn_Command livingOn = new LightOn_Command(livingLight);
        LightOff_Command livingOff = new LightOff_Command(livingLight);

        // Execute commands
        kitchenOn.execute();
        livingOff.execute();
        livingOn.execute();
        kitchenOff.execute();

    }

}
