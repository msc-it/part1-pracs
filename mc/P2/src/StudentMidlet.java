import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class StudentMidlet extends MIDlet implements CommandListener {

    Display display;
    Form formPersonal, formAcademic, formResults;
    Command cmdNext, cmdBack, cmdExit;

    TextField txtName, txtCity, txtPhone;
    ChoiceGroup cgStream;

    /**
        0 => Personal Info
        1 => Academic Info
        2 => Results
     */
    int currentScreen = 0;

    // Constructor
    public StudentMidlet() {
        display = Display.getDisplay(this);

        cmdNext = new Command("Next", Command.OK, 0);
        cmdBack = new Command("Back", Command.BACK, 0);
        cmdExit = new Command("Exit", Command.EXIT, 0);

        // Form for personal info
        formPersonal = new Form("Personal Info");
        txtName = new TextField("Name", "", 20, TextField.ANY);
        txtCity = new TextField("City", "", 20, TextField.ANY);
        txtPhone = new TextField("Mobile", "", 13, TextField.PHONENUMBER);
        formPersonal.append(txtName);
        formPersonal.append(txtCity);
        formPersonal.append(txtPhone);
        formPersonal.addCommand(cmdNext);
        formPersonal.addCommand(cmdExit);

        formAcademic = new Form("Academic Info");
        cgStream = new ChoiceGroup("Stream", ChoiceGroup.EXCLUSIVE);
        cgStream.append("Arts", null);
        cgStream.append("Science", null);
        cgStream.append("Commerce", null);
        formAcademic.append(cgStream);
        formAcademic.addCommand(cmdNext);
        formAcademic.addCommand(cmdBack);

        formResults = new Form("Results");
        formResults.addCommand(cmdBack);

        // Set command listeners
        formPersonal.setCommandListener(this);
        formAcademic.setCommandListener(this);
        formResults.setCommandListener(this);
    }

    public void startApp() {
        display.setCurrent(formPersonal);
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
        else if(cmd == cmdBack) {
            currentScreen--;
            go_to_screen();
        }
        else if(cmd == cmdNext) {
            currentScreen++;
            go_to_screen();
        }
    }

    // Helper method to go to the screen depending on value of currentScreen
    private void go_to_screen() {
        switch(currentScreen)
        {
            case 0:
                display.setCurrent(formPersonal);
                break;
            case 1:
                display.setCurrent(formAcademic);
                break;
            case 2:
                String info = "Name: " + txtName.getString()
                            + "\nCity: " + txtCity.getString()
                            + "\nMobile: " + txtPhone.getString()
                            + "\nStream: " + cgStream.getString(cgStream.getSelectedIndex());
                formResults.deleteAll();  // remove existing items from the results form
                formResults.append(info); // add the new info string
                display.setCurrent(formResults);
                break;
            default:
                System.out.println("current screen is invalid");
                break;
        }
    }
}