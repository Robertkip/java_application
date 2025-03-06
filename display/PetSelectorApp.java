import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PetSelectorApp {
    public static void main(String[] args) {
        // Create the main frame with a title
        JFrame frame = new JFrame("Pet Selector Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        // Label to display selected pet
        JLabel label = new JLabel("Select a pet:", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(label, BorderLayout.NORTH);

        // Create radio buttons for pet selection
        JRadioButton dogButton = new JRadioButton("Dog");
        JRadioButton catButton = new JRadioButton("Cat");
        JRadioButton rabbitButton = new JRadioButton("Rabbit");
        JRadioButton parrotButton = new JRadioButton("Parrot");
        JRadioButton fishButton = new JRadioButton("Fish");

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(dogButton);
        group.add(catButton);
        group.add(rabbitButton);
        group.add(parrotButton);
        group.add(fishButton);

        // Panel to hold radio buttons
        JPanel panel = new JPanel();
        panel.add(dogButton);
        panel.add(catButton);
        panel.add(rabbitButton);
        panel.add(parrotButton);
        panel.add(fishButton);
        frame.add(panel, BorderLayout.SOUTH);

        // Label to display the selected pet
        JLabel resultLabel = new JLabel("No pet selected.", SwingConstants.CENTER);
        frame.add(resultLabel, BorderLayout.CENTER);

        // Panel to display pet image
        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(imageLabel);
        frame.add(imagePanel, BorderLayout.EAST);

        // Action listener for radio buttons
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String petName = ((JRadioButton) e.getSource()).getText();
                resultLabel.setText("You selected pet : " + petName);
                
                // Load and set the image with scaling
                String imagePath = "images/" + petName.toLowerCase() + ".jpeg";
                ImageIcon icon = new ImageIcon(imagePath);
            }
        };

        // Attach listener to each radio button
        dogButton.addActionListener(listener);
        catButton.addActionListener(listener);
        rabbitButton.addActionListener(listener);
        parrotButton.addActionListener(listener);
        fishButton.addActionListener(listener);

        // Set frame visibility
        frame.setVisible(true);
    }
}
