import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class SearchDemo extends MIDlet implements CommandListener{

    private Display display;
    private TextBox txtText, txtSearch;

    private Command cmdNext, cmdSearch;
    private Command cmdBack, cmdExit;

    private Alert alert;

    // Constructor
    public SearchDemo() {
        display = Display.getDisplay(this);
        String text = "MSc IT Part I students are preparing for practical examinations May 2017.";
        txtText = new TextBox("Info", text, 1000, TextField.ANY);
        txtSearch = new TextBox("Search Text", "", 15, TextField.ANY);

        // Create commands for the main text box and add it
        cmdNext = new Command("Next", Command.OK, 0);
        cmdExit = new Command("Exit", Command.EXIT, 0);
        txtText.addCommand(cmdNext);
        txtText.addCommand(cmdExit);

        // Create commands for the search box and add it
        cmdSearch = new Command("Search", Command.OK, 0);
        cmdBack = new Command("Back", Command.BACK, 0);
        txtSearch.addCommand(cmdSearch);
        txtSearch.addCommand(cmdBack);

        // Register the command Listener
        txtText.setCommandListener(this);
        txtSearch.setCommandListener(this);

        alert = new Alert("Search Result");
        alert.setTimeout(Alert.FOREVER);
    }

    public void startApp() {
        // Show the main text box on startup
        display.setCurrent(txtText);
    }

    public void pauseApp() {
        
    }

    public void destroyApp(boolean flag) {

    }

    public void commandAction(Command cmd, Displayable d) {
        if(cmd == cmdExit) {
            // Exit the app
            destroyApp(false);
            notifyDestroyed();
        }
        else if(cmd == cmdNext) {
            // Navigate to the search box
            System.out.println("Navigating to the search text box");
            display.setCurrent(txtSearch);
        }
        else if(cmd == cmdBack) {
            // Navigate to the main text box
            System.out.println("Navigating to main text box");
            display.setCurrent(txtText);
        }
        else if(cmd == cmdSearch) {
            System.out.println("Performing search for string: " + txtSearch.getString());

            // Perform search and show the search result
            alert.setString(perform_search());
            display.setCurrent(alert);
        }
    }

    // Helper method that performs search and returns output string
    private String perform_search() {
        String out = "";

        // Get strings from the TextBoxes
        String fullText = txtText.getString();
        String searchString = txtSearch.getString();

        // Perform search
        int index = fullText.indexOf(searchString);

        // Set output accordingly
        if(index == -1) {
            out = "Text not Found";
        }
        else {
            out = "Text found!";
            out += "\nPosition: " + index;
        }
        return out;
    }
}