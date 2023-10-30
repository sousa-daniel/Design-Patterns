package Singleton;

public class TestSingleton {
    
    public static void main(String[] args) {
        
        // The class generates an instance and returns it
        Singleton s = Singleton.getInstance();

        System.out.println(s);

        // An instance was already generated so the same one is returned
        s = Singleton.getInstance();

        System.out.println(s);
    }
}
