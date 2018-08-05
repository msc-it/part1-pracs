import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MyCanvas extends Canvas implements CommandListener {

    private String pressedKey = "";
    private Command cmdArc, cmdLine, cmdRectangle, cmdExit;
    private MyApp app; // The midlet app that uses this canvas

    /**
        0 => Nothing
        1 => Draw Arc
        2 => Draw Line
        3 => Draw Rectangle
     */
    private int action = 0;

    // Constructor
    public MyCanvas(MyApp app) {

        this.app = app;

        // Initialize the commands
        cmdExit = new Command("Exit", Command.EXIT, 0);
        cmdArc = new Command("Draw Arc", Command.SCREEN, 1);
        cmdLine = new Command("Draw Line", Command.SCREEN, 1);
        cmdRectangle = new Command("Draw Rectangle", Command.SCREEN, 1);

        // Add the commands to the canvas and set the listener
        this.addCommand(cmdExit);
        this.addCommand(cmdArc);
        this.addCommand(cmdLine);
        this.addCommand(cmdRectangle);

        this.setCommandListener(this);
    }

    protected void keyPressed(int keyCode) {
        pressedKey = (char)keyCode + "";
        repaint();
    }

    public void commandAction(Command command, Displayable d) {
        if(command == cmdExit) {
            // Exit the app
            app.destroyApp(false);
            app.notifyDestroyed();
        }
        else if(command == cmdArc) {
            action = 1;
        }
        else if(command == cmdLine) {
            action = 2;
        }
        else if(command == cmdRectangle) {
            action = 3;
        }

        // Paint the canvas
        repaint();
    }

    public void paint(Graphics g) {
        // Clear the screen with white
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Show the pressed key on screen
        g.setColor(0, 0, 0);
        g.drawString(pressedKey, 20, 20, Graphics.TOP | Graphics.HCENTER);

        switch(action) {
            case 1:
                // Draw arc
                g.drawArc(40, 70, 80, 80, 90, 180);
                break;
            case 2:
                // Draw Line
                g.drawLine(40, 40, 140, 40);
                break;
            case 3:
                // Draw Rectangle
                g.fillRect(40, 40, 100, 100);
                break;
        }

        // Appropriate action performed, reset action flag
        action = 0;
    }
}