import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;

public class Ball {

    // Random number generator
    // Static so that all the balls use the same instance
    private static Random rand = new Random();

    int x, y; // Position
    int radius = 15;
    int r, g, b; // Color
    int dx, dy; // Speed & Direction

    int screenWidth, screenHeight;

    // Constructor
    public Ball(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        // Set random values for colors, coordinates
        x = Math.abs(rand.nextInt() % (screenWidth - radius));
        y = Math.abs(rand.nextInt() % (screenHeight - radius));
        r = Math.abs(rand.nextInt() % 255);
        g = Math.abs(rand.nextInt() % 255);
        b = Math.abs(rand.nextInt() % 255);

        dx = rand.nextInt() > 0 ? 2 : -2;
        dy = rand.nextInt() > 0 ? 2 : -2;
    }

    // Contains the logic to update the balls state
    public void update() {
        // If the x position is greater than the screen width
        // Change the x direction
        if(x >= screenWidth || x <= 0) {
            dx *= -1;
        }
        // Do the same for y
        if(y >= screenHeight || y <= 0) {
            dy *= -1;
        }

        // Update the x and y positions
        x += dx;
        y += dy;
    }

    // Contains the logic to draw the ball
    public void draw(Graphics g) {
        // Set the color to the ball's color
        g.setColor(r, this.g, b);

        // Draw the ball
        g.fillArc(x, y, radius, radius, 0, 360);
    }
}