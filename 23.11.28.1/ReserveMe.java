import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ReserveMe extends JFrame {

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
        private void openAdminPanelWindow() {
            
        JFrame adminFrame = new JFrame("Admin Panel");
        adminFrame.setSize(1280, 720);
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ana pencereyi kapat, diğerlerini açık bırak
        adminFrame.setResizable(false);
        adminFrame.setLayout(new BorderLayout());

     /* Geri ve ileri oklarını temsil eden butonlar oluşturuluyor
     JButton backButton = new JButton("<");
     JButton forwardButton = new JButton(">");

     // Geri ve ileri okları için işlevsellik ekleniyor
     backButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             // Geri butonunun işlevi buraya eklenir
             // Örneğin: Önceki sayfaya gitmek için bir işlev çağrılabilir
         }
     });

     forwardButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             // İleri butonunun işlevi buraya eklenir
             // Örneğin: Sonraki sayfaya gitmek için bir işlev çağrılabilir
         }
     }); */
         // Menü çubuğu oluşturuluyor
    JMenuBar menuBar = new JMenuBar();

    // Menü öğeleri oluşturuluyor
    JMenu showMenu = new JMenu("Company list");
    JMenu addmenu = new JMenu("Add company");
    JMenu deletemenu = new JMenu("Delete company");
    JMenu feemenu = new JMenu("Service fee");

    // Dosya menüsü öğeleri
    JMenuItem newItem = new JMenuItem("New");
    JMenuItem openItem = new JMenuItem("Open");
    JMenuItem saveItem = new JMenuItem("Save");
    JMenuItem exitItem = new JMenuItem("Exit");

    // Dosya menüsüne öğeler ekleniyor
    showMenu.add(newItem);
    showMenu.add(openItem);
    showMenu.add(saveItem);
    showMenu.addSeparator(); // Ayırıcı ekleniyor
    showMenu.add(exitItem);

    // Menü çubuğuna menü öğeleri ekleniyor
    menuBar.add(showMenu);
    menuBar.add(addmenu);
    menuBar.add(deletemenu);
    menuBar.add(feemenu);

    adminFrame.setJMenuBar(menuBar); // Menü çubuğu JFrame'e ekleniyor
    adminFrame.setVisible(true);
    }
    private void openUserPanel() {
        UserPanel userPanel = new UserPanel();
        userPanel.setVisible(true);
        dispose(); // Ana pencereyi kapat
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ReserveMe();
        });
    }
}
/*class AdminPanel extends JFrame{
    public AdminPanel(){
    }
} */
    class UserPanel extends JFrame {
    private JPasswordField passwordField;
    private boolean passwordVisible = false;

    private List<User> users = new ArrayList<>();

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

        // Right Panel (Login and Register)
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

             /*   if () {
                    MainMenu();
                    dispose();
                } else { 
                    JOptionPane.showMessageDialog(null, "Login Failed. Wrong username or password.");
                } */
            }
        });

        loginPanel.add(usernamePanel, createGridBagConstraints(0, 0, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        loginPanel.add(passwordPanel, createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        loginPanel.add(showPasswordButton, createGridBagConstraints(0, 2, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        loginPanel.add(loginButton, createGridBagConstraints(0, 3, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        return loginPanel;
    }

    private void MainMenu() {
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
