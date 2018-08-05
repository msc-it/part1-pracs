import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MyApp extends MIDlet {

    public void startApp() {
        // Get current display
        Display display = Display.getDisplay(this);

        // Use it to instantiate our StopWatchCanvas
        // and show it on startup
        display.setCurrent(new StopWatchCanvas(display));
    }

    public void pauseApp() {
        
    }

    public void destroyApp(boolean flag) {

    }
}