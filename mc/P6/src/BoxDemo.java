import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class BoxDemo extends MIDlet implements CommandListener {

    private Display display;
    private List listMenu;

    Command cmdSelect, cmdExit, cmdBack;

    Form formEdit, formRadio, formCheck;

    // Constructor
    public BoxDemo() {
        display = Display.getDisplay(this);

        // Create the main menu and add items to it
        listMenu = new List("Menu", Choice.IMPLICIT);
        listMenu.append("Edit Box", null);
        listMenu.append("Radio Buttons", null);
        listMenu.append("Check Boxes", null);

        cmdSelect = new Command("Select", Command.OK, 0);
        cmdExit = new Command("Exit", Command.EXIT, 0);
        cmdBack = new Command("Back", Command.BACK, 0);

        // Add select and exit commands to main list menu
        listMenu.addCommand(cmdSelect);
        listMenu.addCommand(cmdExit);

        // Create the form with Text Fields
        formEdit = new Form("Edit Form");
        formEdit.append(new TextField("Name", "", 20, TextField.ANY));
        formEdit.append(new TextField("Age", "", 20, TextField.NUMERIC));
        formEdit.append(new TextField("Phone", "", 20, TextField.PHONENUMBER));
        formEdit.append(new TextField("Address", "", 120, TextField.ANY));
        // Add the back command to the form
        formEdit.addCommand(cmdBack);

        // Create form with Radio Buttons
        formRadio = new Form("Radio Form");
        ChoiceGroup cgRadio = new ChoiceGroup("Sport", Choice.EXCLUSIVE);
        cgRadio.append("Cricket", null);
        cgRadio.append("Football", null);
        cgRadio.append("Hocket", null);
        cgRadio.append("Tennis", null);
        cgRadio.append("Badminton", null);
        cgRadio.append("Volley ball", null);
        formRadio.append(cgRadio);
        // Add the back command to the form
        formRadio.addCommand(cmdBack);

        // Create form with Radio Buttons
        formCheck = new Form("Radio Form");
        ChoiceGroup cgCheck = new ChoiceGroup("Car Brand", Choice.MULTIPLE);
        cgCheck.append("Honda", null);
        cgCheck.append("Toyota", null);
        cgCheck.append("Ford", null);
        cgCheck.append("Mazda", null);
        cgCheck.append("Tata", null);
        cgCheck.append("Hyndai", null);
        formCheck.append(cgCheck);
        // Add the back command to the form
        formCheck.addCommand(cmdBack);

        // Set the command listener
        listMenu.setCommandListener(this);
        formEdit.setCommandListener(this);
        formRadio.setCommandListener(this);
        formCheck.setCommandListener(this);
    }

    public void startApp() {
        // Show the main menu while starting the app
        display.setCurrent(listMenu);
    }

    public void pauseApp() {
        
    }

    public void destroyApp(boolean flag) {

    }

    public void commandAction(Command cmd, Displayable d) {
        if(cmd == cmdExit) {
            // Close the app
            destroyApp(false);
            notifyDestroyed();
        }
        if(cmd == cmdSelect) {
            System.out.println("Select clicked");
            // Go to the appropriate form
            int selectedItem = listMenu.getSelectedIndex();
            System.out.println("Item #" + selectedItem + " selected." );
            switch(selectedItem) {
                case 0:
                    display.setCurrent(formEdit);
                break;
                case 1:
                    display.setCurrent(formRadio);
                break;
                case 2:
                    display.setCurrent(formCheck);
                break;
                default:
                    System.out.println("Function not implemented / Invalid function selected" );
                break;
            }
        }
        if(cmd == cmdBack) {
            // Go back to the main list
            display.setCurrent(listMenu);
        }
    }
}