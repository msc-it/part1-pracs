import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MyApp extends MIDlet {

    Display display;

    // Constructor
    public MyApp() {
        display = Display.getDisplay(this);
    }

    public void startApp() {
        display.setCurrent(new MyCanvas());
    }

    public void pauseApp() {
        
    }

    public void destroyApp(boolean flag) {

    }

}