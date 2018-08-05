import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class StopWatchCanvas extends Canvas {

    private Display display;
    int degree = 0;
    private Image buffer;

    // Constructor
    public StopWatchCanvas(Display display) {
        this.display = display;
        buffer = Image.createImage(getWidth(), getHeight());
    }

    public void paint(Graphics g) {
        // Update state
        // Increase by 6 degrees every second (6 * 60secs = 360degrees)
        // Take mod by 366 to ensure the value is in range [0, 360] i.e. 61 seconds
        degree = (degree + 6) % 366;
        if (degree == 0) {
            degree = 6; // to adjust for the one extra second
        }

        // Do the actual drawing on the buffer
        drawClock(buffer.getGraphics());
        // Now draw the buffer to the screen
        g.drawImage(buffer, 0, 0, Graphics.TOP | Graphics.LEFT);

        // Wait for 1 second
        try {
            Thread.sleep(1000);
        } catch(Exception e) { }

        // Repeat
        repaint();
    }

    private void drawClock(Graphics g) {
        // Clear the screen with white
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw a circle, and a filled arc
        int diameter = getWidth() - 20;
        g.setColor(0, 0, 0);
        g.drawArc(10, (getHeight() - getWidth()) / 2, diameter, diameter, 0, 360);
        g.fillArc(10, (getHeight() - getWidth()) / 2, diameter, diameter, 90, -degree);
        // Variables have been adjusted above to center the clock
        // You may simplify as required.
        // Do the math and plot it, to understand whats happening
    }
}