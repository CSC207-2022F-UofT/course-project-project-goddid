package UI;
//import required classes and packages

import controllers.RegisterUIController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.Exception;

//create CreateLoginForm class to create login form
//class extends JFrame to create a window where our component add
//class implements ActionListener to perform an action on button click
class RegisterScreen extends JFrame implements ActionListener
{
    //initialize button, panel, label, and text field
    JButton b1;
    JPanel newPanel;
    JLabel userLabel, passLabel, acc_typeLabel;
    final JTextField  nameField, passField, acc_typeField;

    //calling constructor
    RegisterScreen()
    {

        //create label for username
        userLabel = new JLabel();
        userLabel.setText("Username");      //set label value for textField1

        //create text field to get username from the user
        nameField = new JTextField();    //set length of the text

        //create label for password
        passLabel = new JLabel();
        passLabel.setText("Password");      //set label value for textField2

        //create text field to get password from the user
        passField = new JPasswordField();    //set length for the password

        acc_typeLabel = new JLabel();
        acc_typeLabel.setText("Type Of Account");      //set label value for textField2

        //create text field to get password from the user
        acc_typeField = new JTextField();

        //create submit button
        b1 = new JButton("SUBMIT"); //set label to button

        //create panel to put form elements
        newPanel = new JPanel(new GridLayout(5, 1));
        newPanel.add(userLabel);    //set username label to panel
        newPanel.add(nameField);   //set text field to panel
        newPanel.add(passLabel);    //set password label to panel
        newPanel.add(passField);   //set text field to panel
        newPanel.add(acc_typeLabel);    //set password label to panel
        newPanel.add(acc_typeField);
        newPanel.add(b1);           //set button to panel

        //set border to panel
        add(newPanel, BorderLayout.CENTER);

        //perform action on button click
        b1.addActionListener(this);     //add action listener to button
        setTitle("Register Form");         //set title to the login form
    }

    public JPanel getPanel(){
        return newPanel;
    }

    //define abstract method actionPerformed() which will be called on button click
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter
    {
        String userValue = nameField.getText();        //get user entered username from the textField1
        String passValue = passField.getText();        //get user entered password from the textField2
        String acc_typeValue = acc_typeField.getText();

        //check whether user already exists
        if (true) {  //if authentic, navigate user to a new page
            RegisterUIController regControl = new RegisterUIController();
            try {
                regControl.performRegister(passValue, userValue, acc_typeValue);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            //create instance of the NewPage
            HomeScreen home = new HomeScreen();
            //make page visible to the user
            home.setVisible(true);


        }
        else{
            //show error message
            System.out.println("User already exists");
        }
    }
}

//create the main class
class RegisterFormDemo
{
    //main() method start
    public static void main(String arg[])
    {
        try
        {
            //create instance of the CreateLoginForm
            RegisterScreen form = new RegisterScreen();
            form.setSize(500,200);  //set size of the frame
            form.setVisible(true);  //make form visible to the user
        }
        catch(Exception e)
        {
            //handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}