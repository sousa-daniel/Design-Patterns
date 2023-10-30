package Proxy;

public class TestProxy {
    
    public static void main(String[] args) {

        // Real Image is loaded at instantiation even though it isn't even displayed
        Real_Image ri = new Real_Image("Beach.png");
        
        // Image proxy is created but image isn't loaded.
        Proxy_Image pi = new Proxy_Image("Island.png");

        // Do some other actions ...
        pi.display();
    }
}
