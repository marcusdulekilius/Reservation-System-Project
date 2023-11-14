import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JFrame {
    private JPasswordField passwordField;
    private boolean passwordVisible = false;

    public UserPanel() {
        setTitle("User Panel Login");
        setBounds(100, 100, 1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(1, 2));

        // Sol Panel (Simge ve Ad)
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

        // symbolLabel için GridBagConstraints oluştur
        GridBagConstraints symbolConstraints = new GridBagConstraints();
        symbolConstraints.gridx = 0;
        symbolConstraints.gridy = 0;
        symbolConstraints.fill = GridBagConstraints.BOTH;
        symbolConstraints.weightx = 2.0;
        symbolConstraints.weighty = 2.0;

        // nameLabel için GridBagConstraints oluştur
        GridBagConstraints nameConstraints = new GridBagConstraints();
        nameConstraints.gridx = 0;
        nameConstraints.gridy = 1;

        leftPanel.add(symbolLabel, symbolConstraints);
        leftPanel.add(nameLabel, nameConstraints);

        // Sağ Panel (Kullanıcı Adı, Şifre ve Giriş)
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightPanel.setBackground(new Color(10, 22, 39, 255));

        JPanel usernamePanel = new JPanel(new GridBagLayout());
        usernamePanel.setBackground(new Color(10, 22, 39, 255));

        JTextField usernameField = new JTextField(15); // Gerekirse genişliği ayarlayın
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.white); // Metin rengini beyaz yap
        usernamePanel.add(usernameLabel, createGridBagConstraints(0, 0, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        usernamePanel.add(usernameField, createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        passwordField = new JPasswordField(15); // Gerekirse genişliği ayarlayın
        JPanel passwordPanel = new JPanel(new GridBagLayout());
        passwordPanel.setBackground(new Color(10, 22, 39, 255)); // Şifre panelinin arka plan rengi
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.white); // Metin rengini beyaz yap
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

                if (username.equals("Marcus") && password.equals("ReserveMe!")) {
                    openNewPage();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login Failed. Wrong username or password.");
                }
            }
        });

        rightPanel.add(usernamePanel, createGridBagConstraints(0, 0, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        rightPanel.add(passwordPanel, createGridBagConstraints(0, 1, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        rightPanel.add(showPasswordButton, createGridBagConstraints(0, 2, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        rightPanel.add(loginButton, createGridBagConstraints(0, 3, 1, 1, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        add(leftPanel);
        add(rightPanel);

        setVisible(true);
    }

    private void openNewPage() {
        JFrame newPage = new JFrame("Main Menu");
        newPage.setSize(1280, 720);
        newPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newPage.setResizable(false);
        // Yeni sayfayı üç sütuna bölmek için GridLayout kullan
        newPage.setLayout(new GridLayout(1, 3));

        // Back, Forward ve Ana Menü butonlarını ekleyin
        JButton backButton = new JButton("Back");
        JButton forwardButton = new JButton("Forward");
        JButton mainMenuButton = new JButton("Main Menu");

        /* Ana menü butonuna tıklandığında yeni bir UserPanel penceresi açılacak
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserPanel();
                newPage.dispose();
            }
        }); */

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);
        buttonPanel.add(mainMenuButton);
        buttonPanel.add(forwardButton);

        newPage.add(buttonPanel);

        // Her sütuna farklı arka plan resmi ve butonları ekleyin
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(new JLabel(new ImageIcon(System.getProperty("user.home") + "/Downloads/passenger.png")), BorderLayout.CENTER);
        JButton passengerButton = new JButton("Passenger");
        passengerButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Butonları sütunun tam ortasına hizala
        panel1.add(passengerButton, BorderLayout.SOUTH);
        newPage.add(panel1);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(new JLabel(new ImageIcon(System.getProperty("user.home") + "/Downloads/personnel.png")), BorderLayout.CENTER);
        JButton personnelButton = new JButton("Personnel");
        personnelButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Butonları sütunun tam ortasına hizala
        panel2.add(personnelButton, BorderLayout.SOUTH);
        newPage.add(panel2);

        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.add(new JLabel(new ImageIcon(System.getProperty("user.home") + "/Downloads/company.png")), BorderLayout.CENTER);
        JButton companyButton = new JButton("Company");
        companyButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Butonları sütunun tam ortasına hizala
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
        gbc.insets = new Insets(5, 5, 5, 5); // İsteğe bağlı: Bileşenler arasındaki boşluğu ayarlar
        return gbc;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UserPanel();
        });
    }
}
