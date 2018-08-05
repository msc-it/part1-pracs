import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class LoginMIDlet extends MIDlet implements CommandListener {
    
    private Display display;

    private Form formLogin;
    private TextField txtUsername, txtPassword;
    private Command cmdLogin, cmdExit;

    // Constructor
    public LoginMIDlet() {
        
        // Get the current display
        display = Display.getDisplay(this);

        // Initialize the login form and its elements
        formLogin = new Form("Login");
        txtUsername = new TextField("Username", "", 10, TextField.ANY);
        txtPassword = new TextField("Password", "", 10, TextField.PASSWORD);
        cmdLogin = new Command("Login", Command.OK, 1);
        cmdExit = new Command("Close", Command.EXIT, 1);
        // Add the login form elements to the login form
        formLogin.append(txtUsername);
        formLogin.append(txtPassword);
        // Add the commands to the form
        formLogin.addCommand(cmdLogin);
        formLogin.addCommand(cmdExit);
        // Set the command listener
        formLogin.setCommandListener(this);
    }

    public void startApp() {
        display.setCurrent(formLogin);
    }

    public void pauseApp() {
        
    }

    public void destroyApp(boolean flag) {

    }

    public void commandAction(Command cmd, Displayable d) {
        if(cmd == cmdExit) {
            // Exit the app
            System.out.println("Exiting");
            destroyApp(false);
            notifyDestroyed();
        }
        if(cmd == cmdLogin) {
            System.out.println("Login pressed");
            // Perform validation logic here
            if(validate_creds(txtUsername.getString(), txtPassword.getString())) {
                // If validation succeeded
                System.out.println("Login success!");
                show_services();
            }
            else {
                System.out.println("Invalid username or password");
            }
        }
    }

    // Helper method to validate credentials
    private boolean validate_creds(String username, String password) {
        return username.equals("mscit") && password.equals("part1");
    }

    // helper method to show list of services
    private void show_services() {
        List services = new List("Select service", Choice.EXCLUSIVE);
        services.append("Inbox", null);
        services.append("Compose", null);
        services.append("Drafts", null);
        services.append("Contacts", null);
        services.append("Options", null);
        services.append("Logout", null);
        services.addCommand(cmdExit); // make it possible to exit from here
        services.setCommandListener(this);
        display.setCurrent(services); // navigate to this screen now
    }
}
