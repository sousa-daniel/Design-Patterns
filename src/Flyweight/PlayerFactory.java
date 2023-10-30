package Flyweight;

import java.util.HashMap;

public class PlayerFactory {
    
    private static HashMap<String, Player> hm = new HashMap<String, Player>();

    public static Player getPlayer(String type) {
        Player p = null;

        if(hm.containsKey(type)) {
            p = hm.get(type);
        } else {
            switch (type) {
                case "Terrorist":
                    p = new Terrorist();
                    System.out.println("Terrorist created!");
                    break;
                case "CounterTerrorist":
                    p = new CounterTerrorist();
                    System.out.println("Counter Terrorist created!");
                    break;
                default:
                    break;
            }
            hm.put(type, p);
        }
        return p;
    }
}
