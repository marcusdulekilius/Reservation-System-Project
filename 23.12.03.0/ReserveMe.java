import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReserveMe extends JFrame {
      private Map<String, String> companies = new HashMap<>();

    public ReserveMe(){
    setTitle("Main Menu");
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

        // GridBagConstraints for symbolLabel
        GridBagConstraints symbolConstraints = new GridBagConstraints();
        symbolConstraints.gridx = 0;
        symbolConstraints.gridy = 0;
        symbolConstraints.fill = GridBagConstraints.BOTH;
        symbolConstraints.weightx = 1.0;
        symbolConstraints.weighty = 1.0;

        leftPanel.add(symbolLabel, symbolConstraints);

        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightPanel.setBackground(new Color(10, 22, 39, 255));

        JButton adminbutton = new JButton("Admin");
        JButton companybutton = new JButton("Company");
        JButton passengerbutton = new JButton("Passenger");

        adminbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAdminPanel();
            }
        });
        companybutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openUserPanel();
            }
        });

        GridBagConstraints adminbuttonConstraints = new GridBagConstraints();
        adminbuttonConstraints.gridx = 0;
        adminbuttonConstraints.gridy = 0;
        adminbuttonConstraints.fill = GridBagConstraints.HORIZONTAL;
        adminbuttonConstraints.anchor = GridBagConstraints.CENTER;
        adminbuttonConstraints.ipady = 20; // Yükseklik arttırıldı
        adminbuttonConstraints.ipadx = 150; // Genişlik arttırıldı
        adminbuttonConstraints.insets = new Insets(0, 0, 20, 0); // Alt boşluk eklendi

        GridBagConstraints companybuttonConstraints = new GridBagConstraints();
        companybuttonConstraints.gridx = 0;
        companybuttonConstraints.gridy = 1;
        companybuttonConstraints.fill = GridBagConstraints.HORIZONTAL;
        companybuttonConstraints.anchor = GridBagConstraints.CENTER;
        companybuttonConstraints.ipady = 20; // Yükseklik arttırıldı
        companybuttonConstraints.ipadx = 150; // Genişlik arttırıldı
        companybuttonConstraints.insets = new Insets(0, 0, 20, 0); // Alt boşluk eklendi

        GridBagConstraints passengerbuttonConstraints = new GridBagConstraints();
        passengerbuttonConstraints.gridx = 0;
        passengerbuttonConstraints.gridy = 2;
        passengerbuttonConstraints.fill = GridBagConstraints.HORIZONTAL;
        passengerbuttonConstraints.anchor = GridBagConstraints.CENTER;
        passengerbuttonConstraints.ipady = 20; // Yükseklik arttırıldı
        passengerbuttonConstraints.ipadx = 150; // Genişlik arttırıldı
        
        rightPanel.add(adminbutton, adminbuttonConstraints);
        rightPanel.add(companybutton, companybuttonConstraints);
        rightPanel.add(passengerbutton, passengerbuttonConstraints);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    private void openAdminPanel(){
    String username = JOptionPane.showInputDialog(null, "Enter username:");
    String password = JOptionPane.showInputDialog(null, "Enter password:");

    if (username != null && password != null && username.equals("Marcus") && password.equals("selam")) {
        openAdminPanelWindow();
    } else {
        JOptionPane.showMessageDialog(null, "Invalid username or password");
    }
}
       // ADMIN PANEL //
        private void openAdminPanelWindow() {
            
        JFrame adminFrame = new JFrame("Admin Panel");
        Color color = new Color(10, 22, 39,255);
        
        adminFrame.setSize(1280, 720);
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ana pencereyi kapat, diğerlerini açık bırak
        adminFrame.setResizable(false);
        adminFrame.setLayout(new BorderLayout());
        adminFrame.getContentPane().setBackground(color);
         // Menü çubuğu oluşturuluyor
    JMenuBar menuBar = new JMenuBar();

    // Menü öğeleri oluşturuluyor
    JMenu showMenu = new JMenu("Company list");
    JMenu addmenu = new JMenu("Add company");
    JMenu deletemenu = new JMenu("Delete company");
    JMenu feemenu = new JMenu("Service fee");
    JMenuItem addCompanyItem = new JMenuItem("Add company");
    addCompanyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String companyName = JOptionPane.showInputDialog(null, "Enter company name:");
                String companyPassword = JOptionPane.showInputDialog(null, "Enter company password:");

                if (companyName != null && !companyName.isEmpty() && companyPassword != null) {
                    addCompany(companyName, companyPassword);
                    JOptionPane.showMessageDialog(null, "Company added successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid information.");
                }
            }
        });
    // Menü çubuğuna menü öğeleri ekleniyor
    menuBar.add(showMenu);
    menuBar.add(addmenu);
    menuBar.add(deletemenu);
    menuBar.add(feemenu);
   addmenu.add(addCompanyItem);
    adminFrame.setJMenuBar(menuBar); // Menü çubuğu JFrame'e ekleniyor
    adminFrame.setVisible(true);
    }
    private void addCompany(String companyName, String companyPassword) {
        companies.put(companyName, companyPassword);
    }

    public boolean checkCompanyPassword(String companyName, String enteredPassword) {
        String storedPassword = companies.get(companyName);
        return storedPassword != null && storedPassword.equals(enteredPassword);
    }

   /* private void openUserPanel() {
        CompanyPanel userPanel = new CompanyPanel();
        userPanel.setVisible(true);
       
    } */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ReserveMe();
        });
    }
    
}
    
  class CompanyPanel extends JFrame {
    private JPasswordField passwordField;
    private boolean passwordVisible = false;
    private Map<String, String> companies;

    // Constructor to receive companies data from ReserveMe class
    public CompanyPanel(Map<String, String> companies) {
        this.companies = companies;
        setTitle("Company Panel Login");
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

        // GridBagConstraints for symbolLabel
        GridBagConstraints symbolConstraints = new GridBagConstraints();
        symbolConstraints.gridx = 0;
        symbolConstraints.gridy = 0;
        symbolConstraints.fill = GridBagConstraints.BOTH;
        symbolConstraints.weightx = 2.0;
        symbolConstraints.weighty = 2.0;

        leftPanel.add(symbolLabel, symbolConstraints);

        // Right Panel (Login)
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightPanel.setBackground(new Color(10, 22, 39, 255));

        JPanel loginPanel = createLoginPanel();

        // Set default visibility
        loginPanel.setVisible(true);
        rightPanel.add(loginPanel, createGridBagConstraints(0, 1, 2, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        add(leftPanel);
        add(rightPanel);

        setVisible(true);
    }
    // COMPANY PANEL //
    private JPanel createLoginPanel() {
        /*String username = 'Marcus';
        String password = 'selam'; */
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
                String enteredUsername = usernameField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                if (authenticateCompany(enteredUsername, enteredPassword)) {
                    MainMenu();
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

    private boolean authenticateCompany(String name, String password) {
        String storedPassword = companies.get(name);
        return storedPassword != null && storedPassword.equals(password);
    }

    private void MainMenu() {
        JFrame newPage = new JFrame("Main Menu");
        newPage.setSize(1280, 720);
        newPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ana pencereyi kapat, diğerlerini açık bırak
        newPage.setResizable(false);
        Color color = new Color(10, 22, 39,255);
        newPage.setLayout(new BorderLayout());
       newPage.getContentPane().setBackground(color);

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
            new CompanyPanel(new HashMap<>()); // Pass your HashMap of companies here
        });
    }
      // User sınıfı, kullanıcı adı ve şifreyi tutar
    private static class User {
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
