package Command;

public class LightOn_Command implements Command {
    
    Light light;

    public LightOn_Command(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
