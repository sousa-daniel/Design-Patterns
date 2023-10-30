package Singleton;

public class Singleton {
    
    private static Singleton singInstance;

    private Singleton() {
        // Initialize attributes
        // ...
    }

    public static synchronized Singleton getInstance() {
        if (singInstance == null) {
            singInstance = new Singleton();
            return singInstance;
        }
        return singInstance;
    }

    // An even better improvement would be first checking if the instance is null
    // and only then create a lock using synchronized if necessary.
    /*
    public static Singleton getInstance() {
        if (singInstance == null) doSync();
        return singInstance;
    }

    private static synchronized void doSync() {
        if (singInstance == null) {
            singInstance = new Singleton();
        }
    }
    */
}
