# Design Patterns

- Design Patterns
  - [Strategy](#strategy)
  - [Singleton](#singleton)
  - [Flyweight](#flyweight)
  - [Factory Method](#factory-method)
  - [Prototype](#prototype)
  - [Builder](#builder)
  - [Decorator](#decorator)
  - [Observer](#observer)
  - [Chain of Responsability](#chain-of-responsability)
  - [Composite](#composite)
  - [Visitor](#visitor)
  - [Adapter](#adapter)
  - [Command](#command)
  - [Proxy](#proxy)

## Strategy 
[(Source Code)](./Strategy/)

Consists of having an interface that will be implemented by multiple classes. Other classes can then refer to that type of behaviour by just referencing the interface instead of a specific class. This allows the client to choose the desired strategy.

```c
public interface MovementStrategy {
    public void move();
}
---
public class WalkStrategy implements MovementStrategy {
    
    public void move() {
        System.out.println("The player is now walking.");
    }
}
---
public class RunningStrategy implements MovementStrategy {
    
    public void move() {
        System.out.println("The player is now running.");
    }
}
---
public class Player {
    
    public void move(MovementStrategy strat) {
        strat.move();
    }
}
---
public static void main(String[] args) {
        
    Player player = new Player();

    // Player walks
    player.move(new WalkStrategy());
    // Player Runs
    player.move(new RunningStrategy());
}
```

## Singleton
[(Source Code)](./Singleton/)

Consists of only allowing one instance of a class to be created by privatizing its constructor and instead creating a function that verifies whether an instance has been created already or not.

```c
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
```

## Flyweight
[(Source Code)](./Flyweight/)

Credits for source code: [GeeksforGeeks - Flyweight DP](https://www.geeksforgeeks.org/flyweight-design-pattern/)

## Factory Method
[(Source Code)](./FactoryMethod/)

The factory design pattern defines an interface ( A java interface or an abstract class) for creating object and let the subclasses decide which class to instantiate. The factory method in the interface lets a class defers the instantiation to one or more concrete subclasses.

```c
public abstract class Restaurant {
    Burger orderBurger() {
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    public abstract Burger createBurger(); // This is the factory method
}
---
public class BeefBurgerRestaurant extends Restaurant {
    
    public Burger createBurger() {
        return new BeefBurger();
    }
}
---
public static void main(String[] args) {

        BeefBurgerRestaurant bbr = new BeefBurgerRestaurant();
        Burger burger = bbr.orderBurger();
}
```

## Prototype
[(Source Code)](./Prototype/)

Consists of cloning an already existing object and customizing it to your needs instead of creating an object from scratch. A registry contains all the cloneable objects.

```c
public abstract class Bill implements Cloneable {

    protected static List<Bill> billsList = new ArrayList<Bill>();
    protected double cost;

    public abstract void printDescription();
    
    public Bill clone() {
        try {
            Bill theCopy = (Bill) super.clone();
            billsList.add(theCopy);
            return theCopy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
---
public class ElectricityBill extends Bill {...}

---
// The Registry class contains a list of all cloneable variations of Bill
public abstract class BillRegistry {
    
    private static Bill electricityBill = new ElectricityBill();
//  private static Bill waterBill = new waterBill();

    public static Bill getElectricityBill() {
        return electricityBill;
    }
}
---
public static void main(String[] args) {
        
        Bill eb = BillRegistry.getElectricityBill().clone();
        eb.cost = 120;
        eb.printDescription();
    }
```

## Builder
[(Source Code)](./Builder/)

The Builder pattern suggests that you extract the object construction code out of its own class and move it to separate objects called builders. The director class defines the order in which to execute the building steps, while the builder provides the implementation for those steps.

Having a director class in your program isn’t strictly necessary. You can always call the building steps in a specific order directly from the client code. However, the director class might be a good place to put various construction routines so you can reuse them across your program.

```c
public class Pizza {
    
    private String pasta;
    private String sauce;
    private String filling;

    public void setPasta(String pasta) {...}
    public void setSauce(String sauce) {...}
    public void setFilling(String filling) {...}
}
---
public abstract class PizzaBuilder {
    
    protected Pizza thePizza;

    public void createNewPizza() {
        thePizza = new Pizza();
    }

    public abstract void buildPasta();
    public abstract void buildSauce();
    public abstract void buildFilling();

    public Pizza getResult() {
        return thePizza;
    }
}
---
public class ItalianPizzaBuilder extends PizzaBuilder {
    
    public void buildPasta() {
        this.thePizza.setPasta("Soft");
    }

    public void buildSauce() {
        this.thePizza.setSauce("Tomato");
    }

    public void buildFilling() {
        this.thePizza.setFilling("Chorizo");
    }
}
---
public class PizzaDirector {
    
    private PizzaBuilder pizzaBuilder = null;
    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public void buildPizza_step1() {
        pizzaBuilder.createNewPizza();
        pizzaBuilder.buildPasta();
    }

    public void buildPizza_step2() {
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildFilling();
    }

    public Pizza fetchPizza() {
        return pizzaBuilder.thePizza;
    }
}
---
public static void main(String[] args) {
        
        Pizza pizza = null;
        PizzaDirector dir = new PizzaDirector();
        dir.setPizzaBuilder(new ItalianPizzaBuilder());
        
        dir.buildPizza_step1();
        dir.buildPizza_step2();
        pizza = dir.fetchPizza();

        pizza.getDescription();
    }
```


## Decorator
[(Source Code)](./Decorator/)

Decorator design pattern is used to modify the functionality of an object at runtime. At the same time other instances of the same class will not be affected by this, so individual object gets the modified behavior.

```c
interface Pizza {
    public String getDescription();
    public double getCost();
}
---
class PlainPizza implements Pizza {

    public String getDescription() {...}
    public double getCost() {...}
}
---
abstract class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription();
    }

    public double getCost() {
        return pizza.getCost();
    }
}
---
class Mozzarella extends PizzaDecorator {

    public Mozzarella(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", mozzarella";
    }

    public double getCost() {
        return pizza.getCost() + 0.50;
    }
}
---
public static void main(String[] args) {
        
      Pizza pizza = new Mozzarella(new TomatoSauce(new PlainPizza()));
      System.out.println(pizza.getDescription() + " $" + pizza.getCost());
    }
```

## Observer
[(Source Code)](./Observer/)

**Observer Pattern** is one of the **behavioral design pattern**. It is useful when you are interested in the state of an object and want to get notified whenever there is any change. In observer pattern, the object that watch on the state of another object are called Observer and the object that is being watched is called Subject.

```c
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers(); // Goes through all observers subscribed and updates them
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }   
}
---
public class BinaryObserver extends Observer {
    
    public BinaryObserver(Subject subject) { // When an observer is created it chooses what subject it subscribes
        this.subject = subject;              // This can be remade to allow multiple subscriptions and unsubscription method.
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
---
public static void main(String[] args) {
        
        Subject product = new Subject(); // New product

        new BinaryObserver(product); // Each observer subscribes to a subject that will
        new HexaObserver(product);   // notify them if there is any change

        product.setState(15); // Upon the change, the subject updates all the observers in its list
    }
```

## Chain of Responsability
[(Source Code)](./ChainofResponsability/)

**Chain of Responsibility** is ***behavioral design pattern*** that allows passing request along the chain of potential handlers until one of them handles request.

```c
// Abstract Handler
public abstract class AbstractProcessor {
    
    private AbstractProcessor next = null;

    public void setNext(AbstractProcessor processor) {
        next = processor;
    }

    protected abstract boolean process(int value);

    public final boolean start(int value) {
        boolean processed = this.process(value);
        if ((!processed) && (next != null)) {
            processed = next.start(value);
        }
        return processed;
    }
}
---
// Example of Specific Handler, this only needs to implement handling behaviour, all else is done by its super class
public class ProcessorNegative extends AbstractProcessor{
    
    public boolean process(int value) {
        // Do something
        if (value < 0) {
            System.out.println("Accepted by Negative Processor : " + value);
            return true;
        }
        System.out.println("Rejected by Negative Processor");
        return false;
    }
}
---
public static void main(String[] args) {
        
        // Create Handlers
        AbstractProcessor p1 = new ProcessorPositive();
        AbstractProcessor p2 = new ProcessorNegative();
        AbstractProcessor p3 = new ProcessorZero();
        
        // Define Chain of handlers
        p1.setNext(p2);
        p2.setNext(p3);

        p1.start(0);
    }
```

## Composite
[(Source Code)](./Composite/)

Composite is a structural design pattern that allows composing objects into a tree-like structure and work with the it as if it was a singular object.

```c
// Define an abstract class for any product
public abstract class Product implements Box {
    protected String name;
    protected double price;

    protected Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
---
// Example of product
public class Toy extends Product {
    
    public Toy(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice() {
        return getPrice();
    }
}
---
// Node can take other nodes or leaves
public class CompositeBox implements Box{

    private List<Box> children = new ArrayList<Box>();
    
    public CompositeBox(Box... boxes) {
        children.addAll(Arrays.asList(boxes));
    }

    @Override
    public double calculatePrice() {
        return children.stream()
                    .mapToDouble(Box::calculatePrice)
                    .sum();
    }
}
---
// A box with 2 boxes and 1 product
public static void main(String[] args) {
        
    // Create composite box with all the contents
    CompositeBox finalBox = new CompositeBox(
            new CompositeBox(
                new Book("HP1", 25)
            ),
            new CompositeBox(
                new Book("HP2",30)
            ),
            new Toy("Airplane", 15)
    );

    // Calculate price
    System.out.println("The total price of the contents in the box is: " + finalBox.calculatePrice());
}
```

## Visitor
[(Source Code)](./Visitor/)

Visitor pattern is used when we have to perform an operation on a group of similar kind of Objects. With the help of visitor pattern, we can move the operational logic from the objects to another class.
A visitor requests to be accepted by the entity it wants to visit. If the entity decides that the given visitor meets the requirements then it accepts the visitor. The visitor can then performed its preconfigured tasks for that kind of entity.

```c
// Example of client/entity to be visited
public class Hotel extends Client {
    
    private final float capacity;

    public Hotel(String name, float capacity) {
        super(name);
        this.capacity = capacity;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
---
// Example of Visitor
public class InspectionVisitor implements Visitor {

    public void sendReports(List<Client> clients) {
        for (Client client : clients) {
            client.accept(this);
        }
    }

    @Override
    public void visit(Restaurant restaurant) {...}

    @Override
    public void visit(Hotel hotel) {...}

    @Override
    public void visit(Hospital hospital) {...}
}
```

## Adapter
[(Source Code)](./Adapter/)

The Adapter is a structural design pattern that allows objects with imcompatible interfaces to collaborate with each other.
In the following example LinkedList doesnt behave (doesn't have the same method names) as Stack. Therefore we create a LinkedList Adapter that can be called/treated as a Stack.

```c
public class LinkedList {
    
    LinkedList() {
        // Constructor
    }

    void insertHead(Object o) {...}
    void removeHead() {...}
    Object getHead() {...}
}
---
public interface Stack {
    boolean push(Object o);
    Object pop();
    Object top();
}
---
// Method simply has to implement the interface of what it wants to adapt to.
public class LinkedListAdapter implements Stack {
    
    LinkedList list;

    LinkedListAdapter() {
        list = new LinkedList();
    }

    public boolean push(Object o) {
        // Method implementation
    }

    public Object pop() {
        // Method implementation
    }

    public Object top() {
        // Method implementation
    }
}
```

## Command
[(Source Code)](./Command/)

The Command is a behavioral design pattern that turns a request or a behaviour into a stand-alone object that contains everything about that request. Encapsulates all the relevant information to perform an action or trigger an event. Decouples the classes that invoke an operation from the classes that perform these operations.

```c
// Interface common to all commands
public interface Command {
    public void execute();
}
---
// The command itself stores what operations to perform and where
public class LightOn_Command implements Command {
    
    Light light;

    public LightOn_Command(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}
---
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
```

## Proxy
[(Source Code)](./Proxy/)

Proxy is a structural design pattern that provides an object that acts as a substitute for a real service object used by a client. A proxy receives client requests, does some work (access control, caching, etc.) and then passes the request to a service object.

Another clear example besides the one shown below would be a downloader and a proxy where the proxy can perform caching. Instead of having the downloader download each time a request is made, the proxy caches the contents (until they are deleted again) so that instead if a request is made and the content requested is already available at the proxy it will be sent instead of being redownloaded.

```c
public class Real_Image implements Image {
    
    String imageFileName;

    public Real_Image(String fileName) {
        imageFileName = fileName;
        loadImage(imageFileName);
    }

    public void loadImage(String fileName) {
        System.out.println("Loading very large image file: " + fileName);
    }

    public void display() {
        System.out.println("Displaying " + imageFileName);
    }
}
---
public class Proxy_Image implements Image {
    
    String imageFileName;
    private Real_Image image = null;

    public Proxy_Image(String fileName) {
        imageFileName = fileName;
    }

    public void display() {
        if(image == null) {
            image = new Real_Image(imageFileName);
        }
        image.display();
    }
}
---
public static void main(String[] args) {

    // Real Image is loaded at instantiation even though it isn't even displayed
    Real_Image ri = new Real_Image("Beach.png");
    
    // Image proxy is created but image isn't loaded.
    Proxy_Image pi = new Proxy_Image("Island.png");

    // Do some other actions ...
    pi.display();
}
```
