package Proxy;

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
