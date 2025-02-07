//Import java modules

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
Student no BSE-01-0031/2025
Software Engineering
Zetech -TRC
YEAR 2
*/

//Initiate the LoginForm Class
public class LoginForm extends JFrame implements ActionListener {
    // Labels for username and password fields
    private JLabel usernameLabel, passwordLabel;
    // Text field for entering the username
    private JTextField usernameField;
    // Password field for entering the password
    private JPasswordField passwordField;
    // Button to initiate the login process
    private JButton loginButton;
    // Counter for tracking login attempts
    private int loginAttempts = 0;
    //Maximum allowed login attempts
    private final int MAX_ATTEMPTS = 3;

    public LoginForm() {
        //set the title of the logiform on the Jframe window
        setTitle("Login Form");
        //Set the Jframe window size
        setSize(400, 300);
        // Close the application when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the JFrame on the screen
        setLocationRelativeTo(null);
        // Set the layout of the JFrame using GridLayout (3 rows, 2 columns)
        setLayout(new GridLayout(3, 2, 10, 10));
        
        // Initialize the text fields for username and password input
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        // Initialize the login button and add an ActionListener to it
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        // Add components to the JFrame in the specified order
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); 
        // Empty label for spacing
        add(loginButton);
        // Make the JFrame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // Get the username as a String
            String username = usernameField.getText();
            // Get the password as a String
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                //Display an error message if any field is empty
                JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                //Display Login successful when the username and password match the records
            } else if (authenticate(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Proceed to the next part of your application
            } else {
                //Handle the login attempts
                loginAttempts++;
                if (loginAttempts >= MAX_ATTEMPTS) {
                    //Throw an error message and disable the login button when maximum attempts are reached
                    JOptionPane.showMessageDialog(this, "Maximum login attempts exceeded.", "Error", JOptionPane.ERROR_MESSAGE);
                    loginButton.setEnabled(false);
                } else {
                    //Display an error message with the remaining attempts
                    JOptionPane.showMessageDialog(this, "Invalid credentials. Attempts remaining: " + (MAX_ATTEMPTS - loginAttempts), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private boolean authenticate(String username, String password) {
        // Replace with your actual authentication logic
        return "admin".equals(username) && "password".equals(password);
    }

    public static void main(String[] args) {
        // Create an instance of the LoginForm class to run the application
        new LoginForm();
    }
}
