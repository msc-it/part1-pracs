import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MyCanvas extends Canvas {

    // Constructor
    public MyCanvas() {

    }

    public void paint(Graphics g) {

        // Clear the screen with white
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw a rectangle with some random color
        g.setColor(new java.util.Random().nextInt());
        g.fillRect(50, 50, 100, 100);

        // Wait for a second and then repaint
        try {
            Thread.sleep(1000);        
        } catch (Exception e) { }
        repaint();
    }

}