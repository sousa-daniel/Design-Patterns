package Command;

public class Light {
    
    boolean lightOn;
    String room;

    public Light(String room) {
        lightOn = false;
        this.room = room;
    }

    public void on() {
        lightOn = true;
        System.out.println(room + " light is On!");
    }

    public void off() {
        lightOn = false;
        System.out.println(room + " light is Off!");
    }
}
