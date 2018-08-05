import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*; // Record Management System for Persistent storage
import java.io.*; // For IO, duh

public class MyApp extends MIDlet implements CommandListener{

    private Display display;
    private Form form;
    private TextField txtSearch;
    private Command cmdSearch, cmdExit;
    private Alert alert;

    // Constructor
    public MyApp() {
        display = Display.getDisplay(this);

        // Create and populate the form
        form = new Form("Phone Numbers");
        txtSearch = new TextField("Name", "", 20, TextField.ANY);
        cmdExit = new Command("Exit", Command.EXIT, 0);
        cmdSearch = new Command("Search", Command.OK, 0);
        form.append(txtSearch);
        form.addCommand(cmdExit);
        form.addCommand(cmdSearch);
        form.setCommandListener(this);

        // Initialize the Alert screen
        alert = new Alert("Message");
        alert.setTimeout(Alert.FOREVER);
    }

    public void startApp() {
        display.setCurrent(form);
        // Initialize mock data
        // Refer to Data.java to understand what it does
        boolean result = Data.initialize();
        if(result) {
            System.out.println("Initialization SUCCESS");
        }
        else {
            System.out.println("Initialization failed");
        }
    }

    public void pauseApp() {
        
    }

    public void destroyApp(boolean flag) {
        // Uncomment this if you'd like to clear the datastore
        // when the app quits
        
    }

    public void commandAction(Command cmd, Displayable d) {
        if(cmd == cmdExit) {
            // Exit the app
            destroyApp(false);
            notifyDestroyed();
        }
        else if(cmd == cmdSearch) {

            // Make sure the text is not empty
            if(txtSearch.getString().equals("")) {
                alert.setString("Error: input is empty");
                display.setCurrent(alert);
                return;
            }

            // Perform search
            String resultText = Data.search(txtSearch.getString());
            if(resultText == null) {
                resultText = "Data not found";
            }
            // ... and display the output
            alert.setString(resultText);
            display.setCurrent(alert);
        }
    }
}
