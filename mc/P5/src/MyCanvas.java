import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MyCanvas extends Canvas implements CommandListener {

    int width, height;
    boolean isRunning = true;
    Command cmdStop, cmdStart;
    Ball[] balls;

    // Constructor
    public MyCanvas() {
        // Set the screen width & height
        width = getWidth();
        height = getHeight();

        // Initialize commands and add it to the canvas
        cmdStop = new Command("Stop", Command.CANCEL, 0);
        cmdStart = new Command("Start", Command.OK, 0);
        this.addCommand(cmdStop);
        this.addCommand(cmdStart);
        this.setCommandListener(this);

        // Create an array of 50 balls
        balls = new Ball[50];
        // Initialize all the balls in the array by looping through it
        for(int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(width, height);
        }
    }

    public void paint(Graphics g) {

        if(isRunning) {
            // Update the balls' states only if it's running
            for(int i = 0; i < balls.length; i++) {
                balls[i].update();
            }
        }

        // Clear the screen with white
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, width, height);

        // Draw the balls
        for(int i = 0; i < balls.length; i++) {
            balls[i].draw(g);
        }

        // Wait for a while
        try {
            Thread.sleep(50);        
        } catch (Exception e) { }

        // repeat
        repaint();
    }

    public void commandAction(Command cmd, Displayable d) {
        if(cmd == cmdStop) {
            isRunning = false;
        }
        else if(cmd == cmdStart) {
            isRunning = true;
        }
    }
}