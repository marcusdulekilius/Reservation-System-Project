import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JFrame {
    private JPasswordField passwordField;
    private boolean passwordVisible = false; // Şifrenin görünürlüğünü izlemek için bir bayrak

    public UserPanel() {
        setTitle("User Panel Login");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        // Sol Panel (Simge ve Ad)
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JTextField usernameField = new JTextField(30);
        usernamePanel.add(new JLabel("Kullanıcı Adı:"));
        usernamePanel.add(usernameField);

        passwordField = new JPasswordField(30);
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        passwordPanel.add(new JLabel("Şifre:"));
        passwordPanel.add(passwordField);

        JButton showPasswordButton = new JButton("Şifreyi Göster");
        showPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!passwordVisible) {
                    char[] passwordChars = passwordField.getPassword();
                    String password = new String(passwordChars);
                    passwordField.setEchoChar((char) 0); // Şifreyi görünür yap
                    passwordField.setText(password);
                    passwordVisible = true;
                } else {
                    passwordField.setEchoChar('\u25cf'); // Şifreyi gizle (yuvarlak karakter)
                    passwordVisible = false;
                }
            }
        });

        JButton loginButton = new JButton("Giriş");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("Marcus") && password.equals("ReserveMe!")) {
                    JOptionPane.showMessageDialog(null, "Giriş Başarılı!");
                } else {
                    JOptionPane.showMessageDialog(null, "Giriş Başarısız! Kullanıcı adı veya şifre yanlış.");
                }
            }
        });

        rightPanel.add(usernamePanel);
        rightPanel.add(passwordPanel);
        rightPanel.add(showPasswordButton);
        rightPanel.add(loginButton);

        add(leftPanel);
        add(rightPanel);

        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UserPanel();
        });
    }
}
