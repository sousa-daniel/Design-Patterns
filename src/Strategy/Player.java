package Strategy;

public class Player {
    
    public void move(MovementStrategy strat) {
        strat.move();
    }
}
