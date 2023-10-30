package Strategy;

public class TestStrategy {
    
    public static void main(String[] args) {
        
        Player player = new Player();

        // Player walks
        player.move(new WalkStrategy());
        // Player Runs
        player.move(new RunningStrategy());
    }
}
