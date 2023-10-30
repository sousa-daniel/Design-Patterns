package Builder;

public class Pizza {
    
    private String pasta;
    private String sauce;
    private String filling;

    public void setPasta(String pasta) {
        this.pasta = pasta;
    }
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
    public void setFilling(String filling) {
        this.filling = filling;
    }

    public void getDescription() {
        System.out.println("Pasta: " + pasta + " / Sauce: " + sauce + " / Filling: " + filling);
    }
    
}
