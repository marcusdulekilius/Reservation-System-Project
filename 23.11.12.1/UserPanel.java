import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JFrame {
    public UserPanel() {
        setTitle("User Panel Login");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Using BorderLayout for top and bottom components

        // Logo Panel (Top)
        JPanel logoPanel = new JPanel();
        logoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel logoLabel = new JLabel();

        int logoWidth = 200; // You can adjust the width of the logo
        int logoHeight = 200; // You can adjust the height of the logo

        ImageIcon symbolImage = new ImageIcon(System.getProperty("user.home") + "/Downloads/logo.png");
        Image image = symbolImage.getImage();
        Image newImage = image.getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
        symbolImage = new ImageIcon(newImage);

        logoLabel.setIcon(symbolImage);
        logoPanel.add(logoLabel);

        // Main Panel (Center)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JTextField usernameField = new JTextField(20);
        usernamePanel.add(new JLabel("Username:"));
        usernamePanel.add(usernameField);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPasswordField passwordField = new JPasswordField(20);
        passwordPanel.add(new JLabel("Password:"));
        passwordPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add login logic here
                // You can access usernameField.getText() and new String(passwordField.getPassword()) to get the input values
            }
        });

        mainPanel.add(usernamePanel);
        mainPanel.add(passwordPanel);
        mainPanel.add(loginButton);

        add(logoPanel, BorderLayout.NORTH); // Logo at the top
        add(mainPanel, BorderLayout.CENTER); // Form at the center

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UserPanel();
        });
    }
}
