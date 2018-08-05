import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MyDialog extends MIDlet implements CommandListener{

    private Display display;
    private Form formStudent;
    private Form formResult;
    Command cmdSave, cmdExit;

    public MyDialog() {

        // Initialize the display
        display = Display.getDisplay(this);

        // Create a student form with text fields for ID & Name
        // And radio buttons (choice group) for Gender
        // And two buttons: Save & Exit
        formStudent = new Form("STUDENT"); // Create a student form
        // Create two text fields
        TextField txtId = new TextField("ID", "", 20, TextField.ANY);
        TextField txtName = new TextField("Name", "", 20, TextField.ANY);
        // Create a choice group with male and female choices
        ChoiceGroup cgGender = new ChoiceGroup("Gender", Choice.EXCLUSIVE); // EXCLUSIVE => only one can be selected
        cgGender.append("MALE", null);  // Since we don't need to show an image, we just pass null
        cgGender.append("FEMALE", null);
        // Create two commands
        cmdExit = new Command("EXIT", Command.EXIT, 0);
        cmdSave = new Command("SAVE", Command.SCREEN, 1);
        // Add the text boxes and the choice group to the form
        formStudent.append(txtId);
        formStudent.append(txtName);
        formStudent.append(cgGender);
        // Add the two commands to the form
        formStudent.addCommand(cmdExit);
        formStudent.addCommand(cmdSave);

        // Create a second empty form to show results
        formResult = new Form("RESULT");
        formResult.addCommand(cmdExit);

        // Set command listeners to both forms
        formStudent.setCommandListener(this);
        formResult.setCommandListener(this);
    }

    public void startApp() {
        // Show the student form when the app is started
        display.setCurrent(formStudent);
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
        else if(cmd == cmdSave) {
            // Add text to the result form
            formResult.append("Record saved");
            // Navigate to the result form
            display.setCurrent(formResult);
        }
    }
}