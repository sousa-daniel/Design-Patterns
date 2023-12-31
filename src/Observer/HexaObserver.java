package Observer;

public class HexaObserver extends Observer {
    
    public HexaObserver(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()));
    }
}
