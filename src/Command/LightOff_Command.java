package Command;

public class LightOff_Command implements Command {

    Light light;

    public LightOff_Command(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
    
}
