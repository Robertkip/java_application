import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginForm extends JFrame implements ActionListener {
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private int loginAttempts = 0;
    private final int MAX_ATTEMPTS = 3;

    public LoginForm() {
        setTitle("Login Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // Empty label for spacing
        add(loginButton);

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
