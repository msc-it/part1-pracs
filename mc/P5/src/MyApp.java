import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MyApp extends MIDlet {

    // Constructor
    public MyApp() {

    }

    public void startApp() {
        Display display = Display.getDisplay(this);
        display.setCurrent(new MyCanvas());
    }

    public void pauseApp() {
        
    }

    public void destroyApp(boolean flag) {

    }
}