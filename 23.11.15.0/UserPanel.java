import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class UserPanel extends JFrame {
    private JPasswordField passwordField;
    private boolean passwordVisible = false;

    private Map<String, String> userCredentials = new HashMap<>();

    public UserPanel() {
        setTitle("User Panel Login");
        setBounds(100, 100, 1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(1, 2));

        // Left Panel (Symbol and Name)
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        leftPanel.setBackground(new Color(10, 22, 39, 255));

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        ImageIcon symbolImage = new ImageIcon(System.getProperty("user.home") + "/Downloads/logo.png");
        Image image = symbolImage.getImage();
        Image newImage = image.getScaledInstance(screenWidth / 2, screenHeight, Image.SCALE_SMOOTH);
        symbolImage = new ImageIcon(newImage);

        JLabel symbolLabel = new JLabel(symbolImage);
        symbolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        symbolLabel.setVerticalAlignment(SwingConstants.CENTER);

        JLabel nameLabel = new JLabel();
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        nameLabel.setForeground(Color.white);

        // GridBagConstraints for symbolLabel
        GridBagConstraints symbolConstraints = new GridBagConstraints();
        symbolConstraints.gridx = 0;
        symbolConstraints.gridy = 0;
        symbolConstraints.fill = GridBagConstraints.BOTH;
        symbolConstraints.weightx = 2.0;
        symbolConstraints.weighty = 2.0;

        // GridBagConstraints for nameLabel
        GridBagConstraints nameConstraints = new GridBagConstraints();
        nameConstraints.gridx = 0;
        nameConstraints.gridy = 1;

        leftPanel.add(symbolLabel, symbolConstraints);
        leftPanel.add(nameLabel, nameConstraints);

        // Right Panel (Login and Register)
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightPanel.setBackground(new Color(10, 22, 39, 255));

        JPanel loginPanel = createLoginPanel();
        JPanel registerPanel = createRegisterPanel();

        // Set default visibility
        loginPanel.setVisible(true);
        registerPanel.setVisible(false);

        JButton loginTabButton = new JButton("Login");
        loginTabButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPanel.setVisible(true);
                registerPanel.setVisible(false);
            }
        });

        JButton registerTabButton = new JButton("Register");
        registerTabButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPanel.setVisible(false);
                registerPanel.setVisible(true);
            }
        });

        // GridBagConstraints for loginTabButton
        GridBagConstraints loginTabConstraints = new GridBagConstraints();
        loginTabConstraints.gridx = 0;
        loginTabConstraints.gridy = 0;

        // GridBagConstraints for registerTabButton
        GridBagConstraints registerTabConstraints = new GridBagConstraints();
        registerTabConstraints.gridx = 1;
        registerTabConstraints.gridy = 0;

        rightPanel.add(loginTabButton, loginTabConstraints);
        rightPanel.add(registerTabButton, registerTabConstraints);
        rightPanel.add(loginPanel, createGridBagConstraints(0, 1, 2, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        rightPanel.add(registerPanel, createGridBagConstraints(0, 1, 2, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        add(leftPanel);
        add(rightPanel);

        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(10, 22, 39, 255));

        JPanel usernamePanel = new JPanel(new GridBagLayout());
        usernamePanel.setBackground(new Color(10, 22, 39, 255));

        JTextField usernameField = new JTextField(15);
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.white);
        usernamePanel.add(usernameLabel, createGridBagConstraints(0, 0, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        usernamePanel.add(usernameField, createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        passwordField = new JPasswordField(15);
        JPanel passwordPanel = new JPanel(new GridBagLayout());
        passwordPanel.setBackground(new Color(10, 22, 39, 255));
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.white);
        passwordPanel.add(passwordLabel, createGridBagConstraints(0, 0, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        passwordPanel.add(passwordField, createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        JButton showPasswordButton = new JButton("Show Password");
        showPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!passwordVisible) {
                    char[] passwordChars = passwordField.getPassword();
                    String password = new String(passwordChars);
                    passwordField.setEchoChar((char) 0);
                    passwordField.setText(password);
                    passwordVisible = true;
                } else {
                    passwordField.setEchoChar('\u25cf');
                    passwordVisible = false;
                }
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
                    openNewPage();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login Failed. Wrong username or password.");
                }
            }
        });

        loginPanel.add(usernamePanel, createGridBagConstraints(0, 0, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        loginPanel.add(passwordPanel, createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        loginPanel.add(showPasswordButton, createGridBagConstraints(0, 2, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        loginPanel.add(loginButton, createGridBagConstraints(0, 3, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        return loginPanel;
    }

    private JPanel createRegisterPanel() {
        JPanel registerPanel = new JPanel(new GridBagLayout());
        registerPanel.setBackground(new Color(10, 22, 39, 255));

        JPanel usernamePanel = new JPanel(new GridBagLayout());
        usernamePanel.setBackground(new Color(10, 22, 39, 255));

        JTextField usernameField = new JTextField(15);
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.white);
        usernamePanel.add(usernameLabel, createGridBagConstraints(0, 0, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        usernamePanel.add(usernameField, createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        JPasswordField passwordField = new JPasswordField(15);
        JPanel passwordPanel = new JPanel(new GridBagLayout());
        passwordPanel.setBackground(new Color(10, 22, 39, 255));
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.white);
        passwordPanel.add(passwordLabel, createGridBagConstraints(0, 0, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        passwordPanel.add(passwordField, createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        JPasswordField confirmPasswordField = new JPasswordField(15);
        JPanel confirmPasswordPanel = new JPanel(new GridBagLayout());
        confirmPasswordPanel.setBackground(new Color(10, 22, 39, 255));
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setForeground(Color.white);
        confirmPasswordPanel.add(confirmPasswordLabel, createGridBagConstraints(0, 0, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        confirmPasswordPanel.add(confirmPasswordField, createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        JButton showPasswordButton = new JButton("Show Password");
        showPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!passwordVisible) {
                    char[] passwordChars = passwordField.getPassword();
                    String password = new String(passwordChars);
                    passwordField.setEchoChar((char) 0);
                    passwordField.setText(password);

                    char[] confirmChars = confirmPasswordField.getPassword();
                    String confirmPassword = new String(confirmChars);
                    confirmPasswordField.setEchoChar((char) 0);
                    confirmPasswordField.setText(confirmPassword);

                    passwordVisible = true;
                } else {
                    passwordField.setEchoChar('\u25cf');
                    confirmPasswordField.setEchoChar('\u25cf');
                    passwordVisible = false;
                }
            }
        });

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (userCredentials.containsKey(username)) {
                    JOptionPane.showMessageDialog(null, "Username already exists. Please choose another username.");
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.");
                } else {
                    userCredentials.put(username, password);
                    JOptionPane.showMessageDialog(null, "Registration successful!");
                }
            }
        });

        registerPanel.add(usernamePanel, createGridBagConstraints(0, 0, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        registerPanel.add(passwordPanel, createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        registerPanel.add(confirmPasswordPanel, createGridBagConstraints(0, 2, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        registerPanel.add(showPasswordButton, createGridBagConstraints(0, 3, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        registerPanel.add(registerButton, createGridBagConstraints(0, 4, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        return registerPanel;
    }

    private void openNewPage() {
        JFrame newPage = new JFrame("Main Menu");
        newPage.setSize(1280, 720);
        newPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newPage.setResizable(false);
        // New page with three columns using GridLayout
        newPage.setLayout(new GridLayout(1, 3));

        // Back, Forward, and Main Menu buttons
        JButton backButton = new JButton("Back");
        JButton forwardButton = new JButton("Forward");
        JButton mainMenuButton = new JButton("Main Menu");

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);
        buttonPanel.add(mainMenuButton);
        buttonPanel.add(forwardButton);

        newPage.add(buttonPanel);

        // Each column with a different background image and buttons
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(new JLabel(new ImageIcon(System.getProperty("user.home") + "/Downloads/passenger.png")), BorderLayout.CENTER);
        JButton passengerButton = new JButton("Passenger");
        passengerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(passengerButton, BorderLayout.SOUTH);
        newPage.add(panel1);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(new JLabel(new ImageIcon(System.getProperty("user.home") + "/Downloads/personnel.png")), BorderLayout.CENTER);
        JButton personnelButton = new JButton("Personnel");
        personnelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(personnelButton, BorderLayout.SOUTH);
        newPage.add(panel2);

        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.add(new JLabel(new ImageIcon(System.getProperty("user.home") + "/Downloads/company.png")), BorderLayout.CENTER);
        JButton companyButton = new JButton("Company");
        companyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel3.add(companyButton, BorderLayout.SOUTH);
        newPage.add(panel3);

        newPage.setVisible(true);
    }

    private GridBagConstraints createGridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight, int fill, int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.fill = fill;
        gbc.anchor = anchor;
        gbc.insets = new Insets(5, 5, 5, 5);
        return gbc;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UserPanel();
        });
    }
}
