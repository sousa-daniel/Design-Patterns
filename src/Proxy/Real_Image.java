package Proxy;

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
