import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MyCanvas extends Canvas {

    // Width and height of the canvas component
    private int width;
    private int height;

    // The image to display
    private Image image;

    // Constructor
    public MyCanvas() {
        // Assign the width/height
        width = this.getWidth();
        height = this.getHeight();

        // Load the image
        try {
            image = Image.createImage("/security_query.png");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void paint(Graphics g) {
        // Clear the screen
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, 255, 255);

        // Draw the image we loaded
        g.drawImage(image, width/2, height/2, Graphics.VCENTER | Graphics.HCENTER);
    }

}