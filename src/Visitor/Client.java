package Visitor;

public abstract class Client {
    
    private final String name;

    protected Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void accept(Visitor visitor);
}
