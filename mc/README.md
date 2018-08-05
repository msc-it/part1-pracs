# Mobile Computing Practical Exercises

1. [Practical Index](#practical-index)
1. [Required Software](#required-software)
1. [Bundled Help](#bundled-help)
1. [Quick Start](#quick-start)
1. [Creating a basic MIDlet application](#creating-a-basic-midlet-application)

## Practical Index



| #  | Title      | Level     |
|----|------------|-----------|
| 1  | Create an application to draw a simple text and perform various operations: (1) Draw a simple text in a device screen (2) Change the background color (3) Change the text color (4) Change the font style and font size of displayed text `incomplete` | Moderate |
| 2  | Create an application to handle multiple forms to accept student info. Every form should have a Command Button to navigate.| Easy |
| 3  | Create an application to demonstrate timers. Draw a filled rectangle and change its color after an interval of time. | V. Easy |
| 4  | Create an application to demonstrate double-buffering. | Moderate  |
| 5  | Create an application to demonstrate draw bouncing balls. Add start and stop options. | Long      |
| 6  | Create an application to demonstrate input boxes: EditBox, Buttons, Radio button, Checkbox, ListBox  | Easy   |
| 7  | Create an application to demonstrate a dialog box. | V. Easy   |
| 8  | Create an application to display a bitmap image.   | V. Easy   |
| 9  | Create an application to demonstrate event types: 1. keypress 2. button click |Moderate           |
| 10 | Create application to demonstrate word search. | Easy      |
| 11 | Create an application to demonstrate persistent storage   | Difficult |
| 12 | Create an application to demonstrate a simple login form. | V. Easy   |
| 13 | Create an application to test different GUI components. `incomplete`  | Easy      |

## Required Software

1. 32-bit Java 1.6 `jdk-6u45-windows-i586.exe` | [Download Link](http://www.oracle.com/technetwork/java/javase/downloads/java-archive-downloads-javase6-419409.html)
1. Sun Java Wireless Toolkit `2.5.2_01` for CDLC | [Download Link](http://www.oracle.com/technetwork/java/download-135801.html) | [Google Drive Link](https://drive.google.com/open?id=0B5Yb3LKMG9MPZmlwOWprNWNnUjg)

Make sure Java 1.6 is installed in the default directory, else WTK won't be able to find it.

## Bundled help

To access the help bundled with the toolkit:

1. Go to Help &rarr; Documentation
1. A browser will open (works offline). Click on the `MIDP 2.1 (JSR 118)` link.
1. Click on the package you need help for in the top left pane. Eg. `javax.microedition.lcdui`
1. Click on the approriate class you're looking for in the bottom left pane. Eg. `Command`

_This is clearly a really old software. Give it sometime and you'll find your way around it._

## Quick Start

### Packages to import

All programs make use of definitions from two packages that can be imported as follows:

```java
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
```

If you require persistent storage, you'll also need to use:
```java
import javax.microedition.rms.*; // For persistent storage
import javax.io.*; // For IO
```

Some programs require the `Random` class. These can be imported using:
```java
import java.util.*;
```

### A Minimal MIDlet

A minimal MIDlet can be created as follows:

```java
public class MyDialog extends MIDlet {

    // Constructor
    public MyDialog() {
        
    }

    public void startApp() {
        
    }

    public void pauseApp() {
        
    }

    public void destroyApp(boolean flag) {

    }
}
```

It's a simple class, `MyDialog`, that extends `MIDlet`. `MIDlet` has 3 abstract methods which our class must implement. In the above example, we have implemented the 3 **lifecycle methods** `startApp()`, `pauseApp()` and `destroyApp(boolean)`, and added an empty constructor.

The lifecycle methods are automatically called. Try adding `sysout` statements in the lifecycle method's body to log to the console using `System.out.println("Text to print to console")`. The `destroyApp()` is called when the app is closed using the red button, the `pauseApp()` is called when the app is paused due to an incoming call, and the `startApp()` is called when the app is started.

## Creating a basic MIDlet application

Let's go through exercise 7 to create a simple app. (It's one of the simplest exercises we got.)

#### Creating the project, and getting the code to run

1. Create a new project by clicking on the New Project icon
1. Enter P7 (or any other name) as your project name
1. Enter `MyDialog` as the MIDlet class name

A project folder (P7) will be created in a directory. The project path will be printed in the output console. Open that path and go to the src folder. Create a `MyDialog.java` file and type the code from the minimal MIDlet sample we just saw. Click on Build.

It must build successfully, if it doesn't there's either something wrong with the code or the setup. You may compare the code with [this](https://github.com/msc-it/mc-pracs/blob/621d7ad3bf9c19c0b6618e87c5226564ecae36fb/P7/src/MyDialog.java).

#### Displaying a basic form

1. Once you've the project builds successfully, type the code from [here](https://github.com/msc-it/mc-pracs/blob/d91623fcf0e938f557f666c033d9c9ff004f0432/P7/src/MyDialog.java). It creates a basic form with two `TextField`s, a `ChoiceGroup` and two `Command`s. If you don't understand something or require more explanation feel free to go through the help documentation or open an issue on this GitHub repo.
1. Build the project. If it fails find what's wrong and fix it. Compare it with existing code. 
1. If the build succeeds, run the app by clicking on the Run button, you should see the app start on one of those old phone simulators. (If it doesn't you'll see the project name. Select that to start the app.)

#### Listening to commands

We created two commands (`cmdExit` and `cmdSave`), but they don't really do anything. To be able to _listen_ to commands we'll need a `CommandListener` instance. Since `CommandListener` is an interface the easiest way is to make `MyDialog` to implement `CommandListener`.

[The commit here](https://github.com/msc-it/mc-pracs/commit/887d9ed48a74e2ab97039c60a48b6d3ade86577a) creates a new form and implements the command listener. Open it in a new tab. (If you use the split view, you'll see the old code we just typed on the left, and the changes made to it on the right. Line numbers used below are the line numbers on the right.)

Three changes have been made to it:

1. **Line 8, 39-40:** We create a new empty form, and add the exit command (`cmdExit`) we created earlier.
2. **Line 4, 60-62:** We make `MyDialog` implement the `CommandListener` interface.
3. **Line 43-44:** We set the `CommandListener` instance (which is `this` in our case) to our forms.

Now all that's left is to write the logic to be executed when the user selects a command. Refer to the code [here](https://github.com/msc-it/mc-pracs/commit/7a29fac0dde82552cb2397f5a0215d861e83107c).

#### Moving on

Try doing Practical 6, 2 and 12 now. They use the same concepts of `MIDlet` and `CommandListener`. Once you're comfortable with these try Practical 3. It's a gentle introduction to `Canvas` which is used to draw stuff on the screen manually (similar to `graphics.h` of the old Borland Turbo C++).
