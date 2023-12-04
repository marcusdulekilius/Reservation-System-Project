import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class ReserveMe extends JFrame {
      private Map<String, String> companies = new HashMap<>();
       private List<String> addedVehicles = new ArrayList<>();
      private int newfee;
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
                openCompanyPanel();
            }
        });
        passengerbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPassengerPanel();
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
    public void openPassengerPanel() {
    JFrame passengerFrame = new JFrame("Passenger Panel");
    passengerFrame.setSize(1280, 720);
    passengerFrame.getContentPane().setBackground(new Color(10, 22, 39));

    // Panel içeriği burada oluşturulabilir, istediğin bileşenleri ekleyebilirsin.

    passengerFrame.setLayout(new GridLayout(1, 1)); // Tek bir bileşen ekleyeceğiz

    // Örnek olarak panelin içine bir etiket (label) ekleyelim:
    JLabel label = new JLabel("Passenger Panel");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setVerticalAlignment(SwingConstants.CENTER);
    label.setForeground(Color.WHITE); // Yazı rengini beyaz yapalım

    passengerFrame.add(label);

    JMenuBar menuBar = new JMenuBar();
    JMenuItem listByDayItem = new JMenuItem("List trips by day");
    listByDayItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            showtriplist();
        }
    });

    JMenuItem reservationItem = new JMenuItem("Reservation");
    reservationItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Buraya Reservation işlevselliği eklenebilir
            JOptionPane.showMessageDialog(passengerFrame, "Reservation clicked");
        }
    });

    menuBar.add(listByDayItem);
    menuBar.add(reservationItem);

    // Menubar'ı frame'e ekle
    passengerFrame.setJMenuBar(menuBar);

    passengerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Bu paneli kapattığında sadece bu panelin kapanmasını sağlar
    passengerFrame.setLocationRelativeTo(null); // Ekranın ortasına konumlandırır
    passengerFrame.setResizable(false);
    passengerFrame.setVisible(true);
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
    JMenuItem showmenu = new JMenuItem("Company list");
    JMenuItem addmenu = new JMenuItem("Add company");
    JMenuItem deletemenu = new JMenuItem("Delete company");
    JMenuItem feemenu = new JMenuItem("Service fee");
    

    showmenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showCompanyList();
                }
            });
    addmenu.addActionListener(new ActionListener() {
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
    deletemenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCompanyList();
            }
        });
    feemenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the current fee
                JOptionPane.showMessageDialog(null, "Current fee: "+ newfee +" TL");
    
                // Ask for a new fee
                String newFeeString = JOptionPane.showInputDialog(null, "Enter the new fee:");
                try {
                    int newFee = Integer.parseInt(newFeeString);
                    newfee = newFee; // Güncellemeyi burada yapın
                    JOptionPane.showMessageDialog(null, "Fee updated successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        });
    // Menü çubuğuna menü öğeleri ekleniyor
    menuBar.add(showmenu);
    menuBar.add(addmenu);
    menuBar.add(deletemenu);
    menuBar.add(feemenu);
    
    adminFrame.setJMenuBar(menuBar); // Menü çubuğu JFrame'e ekleniyor
    adminFrame.setVisible(true);
    }
    // Method to display the list of companies for deletion
private void showCompanyList() {
    JFrame companyListFrame = new JFrame("Company List");
    companyListFrame.setSize(720, 720);
    companyListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    companyListFrame.setResizable(false);
    companyListFrame.setLayout(new GridLayout(0, 1));

    JPanel panel = new JPanel(new GridLayout(0, 1));

    // Iterate through the companies and create buttons for each company name
    for (String companyName : companies.keySet()) {
        JButton deleteButton = new JButton(companyName);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deletedCompanyName = e.getActionCommand(); // Get the name of the company to be deleted
                companies.remove(deletedCompanyName); // Remove the company from the map
                JOptionPane.showMessageDialog(null, "Company '" + deletedCompanyName + "' deleted!");
                companyListFrame.dispose(); // Close the list frame after deletion
            }
        });
        panel.add(deleteButton);
    }

    JScrollPane scrollPane = new JScrollPane(panel);
    companyListFrame.add(scrollPane);
    companyListFrame.setVisible(true);
}
    private void addCompany(String companyName, String companyPassword) {
        companies.put(companyName, companyPassword);
    }
private void showtriplist() {
    JFrame viewTripFrame = new JFrame("View Trips");
    viewTripFrame.setSize(720, 720);
    viewTripFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    viewTripFrame.setResizable(false);
    viewTripFrame.getContentPane().setBackground(new Color(10, 22, 39, 255));

    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.setBackground(new Color(10, 22, 39, 255));

    JLabel instructionLabel = new JLabel("List of Trips");
    instructionLabel.setForeground(Color.WHITE);
    instructionLabel.setHorizontalAlignment(JLabel.CENTER);
    instructionLabel.setFont(instructionLabel.getFont().deriveFont(24f)); // Font size
    panel.add(instructionLabel);

    List<Trip> tripDetails = new ArrayList<>();
    for (String vehicle : addedVehicles) {
        for (String date : Arrays.asList("04/12/2023", "05/12/2023", "06/12/2023", "07/12/2023", "08/12/2023", "09/12/2023", "10/12/2023")) {
            tripDetails.add(new Trip(vehicle, date));
        }
    }

    // Sort trips based on dates
    tripDetails.sort(Comparator.comparing(Trip::getDate));

    JList<Trip> tripList = new JList<>(tripDetails.toArray(new Trip[0]));
    tripList.setCellRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (c instanceof JLabel && value instanceof Trip) {
                Trip trip = (Trip) value;
                ((JLabel) c).setText(trip.getVehicle() + " - " + trip.getDate());
                ((JLabel) c).setForeground(Color.BLACK);
            }
            return c;
        }
    });

    JScrollPane scrollPane = new JScrollPane(tripList);
    panel.add(scrollPane);

    viewTripFrame.add(panel);
    viewTripFrame.setVisible(true);
}

class Trip {
    private final String vehicle;
    private final String date;

    public Trip(String vehicle, String date) {
        this.vehicle = vehicle;
        this.date = date;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getDate() {
        return date;
    }
}

    public boolean checkCompanyPassword(String companyName, String enteredPassword) {
        String storedPassword = companies.get(companyName);
        return storedPassword != null && storedPassword.equals(enteredPassword);
    }

   private void openCompanyPanel() {
        CompanyPanel userPanel = new CompanyPanel(companies);
        userPanel.setVisible(true);
    } 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ReserveMe();
        });
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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        newPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        newPage.setResizable(false);
        Color color = new Color(10, 22, 39,255);
        newPage.setLayout(new BorderLayout());
       newPage.getContentPane().setBackground(color);

       JMenuBar menuBar = new JMenuBar();
       JMenu vehiclemenu = new JMenu("Vehicle Operations");
       JMenu tripmenu = new JMenu("Trip Operations");
       JMenuItem incomemenu = new JMenuItem("Income Calculator");

       JMenuItem addvehicle = new JMenuItem("Add Vehicle");
       JMenuItem deletevehicle = new JMenuItem("Delete Vehicle");
       JMenuItem addtrip = new JMenuItem("Add trip");
       JMenuItem deletetrip = new JMenuItem("Delete trip");
       
       vehiclemenu.add(addvehicle);
       vehiclemenu.add(deletevehicle);
       tripmenu.add(addtrip);
       tripmenu.add(deletetrip);

       menuBar.add(vehiclemenu);
       menuBar.add(tripmenu);
       menuBar.add(incomemenu);
    
      
addvehicle.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        addVehicle();
    }
});
deletevehicle.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        deleteVehicle();
    }
});
 addtrip.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        addTrip();
    }
});
deletetrip.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        deleteTrip();
    }
});
    newPage.setJMenuBar(menuBar); // Menü çubuğu JFrame'e ekleniyor
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


    private void addVehicle() {
        JFrame vehicleFrame = new JFrame("Add Vehicle");
        vehicleFrame.setSize(1280, 720);
        vehicleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vehicleFrame.setResizable(false);
        vehicleFrame.setLayout(new GridLayout(0, 1));
    
        JPanel panel = new JPanel(new GridLayout(8, 1)); // Increased to accommodate seat count input
        Color panelColor = new Color(10, 22, 39);
        panel.setBackground(panelColor);
    
        JLabel typeLabel = new JLabel("Select Vehicle Type:");
        typeLabel.setForeground(Color.WHITE);
        panel.add(typeLabel);
    
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBackground(panelColor);
    
        ButtonGroup typeGroup = new ButtonGroup();
        JRadioButton planeButton = new JRadioButton("Plane");
        JRadioButton trainButton = new JRadioButton("Train");
        JRadioButton busButton = new JRadioButton("Bus");
    
        planeButton.setForeground(Color.BLACK);
        trainButton.setForeground(Color.BLACK);
        busButton.setForeground(Color.BLACK);
    
        typeGroup.add(planeButton);
        typeGroup.add(trainButton);
        typeGroup.add(busButton);
    
        planeButton.setPreferredSize(new Dimension(100, 30));
        trainButton.setPreferredSize(new Dimension(100, 30));
        busButton.setPreferredSize(new Dimension(100, 30));
    
        buttonPanel.add(planeButton);
        buttonPanel.add(trainButton);
        buttonPanel.add(busButton);
    
        panel.add(buttonPanel);
    
        JLabel numberLabel = new JLabel("Enter Vehicle Number:");
        numberLabel.setForeground(Color.WHITE);
        panel.add(numberLabel);
    
        JTextField numberField = new JTextField();
        panel.add(numberField);
    
        JLabel seatsLabel = new JLabel("Enter Seat Count:");
        seatsLabel.setForeground(Color.WHITE);
        panel.add(seatsLabel);
    
        JTextField seatsField = new JTextField();
        panel.add(seatsField);
    
        JButton addButton = new JButton("Add");
        addButton.setForeground(Color.BLACK);
    
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vehicleType = "";
                if (planeButton.isSelected()) {
                    vehicleType = "Plane";
                } else if (trainButton.isSelected()) {
                    vehicleType = "Train";
                } else if (busButton.isSelected()) {
                    vehicleType = "Bus";
                }
    
                String vehicleNumber = numberField.getText();
    
                boolean isDuplicate = false;
    
                if (!vehicleType.isEmpty() && !vehicleNumber.isEmpty()) {
                    String seatCountText = seatsField.getText();
                    int seatCount = 0;
    
                    if (!seatCountText.isEmpty()) {
                        try {
                            seatCount = Integer.parseInt(seatCountText);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid number for the seat count.");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter the seat count.");
                        return;
                    }
    
                    String newVehicle = vehicleType + " - " + vehicleNumber + " (" + seatCount + " seats)";
    
                    for (String existingVehicle : addedVehicles) {
                        if (existingVehicle.equals(newVehicle)) {
                            isDuplicate = true;
                            break;
                        }
                    }
    
                    if (isDuplicate) {
                        JOptionPane.showMessageDialog(null, "A vehicle with the same type and number already exists.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Vehicle added: " + newVehicle);
                        addedVehicles.add(newVehicle);
                        vehicleFrame.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a vehicle type, enter a vehicle number, and specify the seat count.");
                }
            }
        });
    
        addButton.setPreferredSize(new Dimension(100, 30));
    
        JPanel addButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addButtonPanel.setBackground(panelColor);
        addButtonPanel.add(addButton);
    
        panel.add(addButtonPanel);
    
        vehicleFrame.add(panel);
        vehicleFrame.setVisible(true);
    }
private void deleteVehicle() {
    JFrame deleteVehicleFrame = new JFrame("Delete Vehicle");
    deleteVehicleFrame.setSize(720, 720);
    deleteVehicleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    deleteVehicleFrame.setResizable(false);

    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.setBackground(new Color(10, 22, 39, 255));

    JLabel instructionLabel = new JLabel("Select a vehicle to delete:");
    instructionLabel.setForeground(Color.WHITE);
    panel.add(instructionLabel);

    // Display the added vehicles in a list
    JList<String> vehicleList = new JList<>(addedVehicles.toArray(new String[0]));
    vehicleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollPane = new JScrollPane(vehicleList);
    panel.add(scrollPane);

    JButton deleteButton = new JButton("Delete");
    deleteButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = vehicleList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedVehicle = addedVehicles.get(selectedIndex);
                addedVehicles.remove(selectedIndex);
                JOptionPane.showMessageDialog(null, "Vehicle '" + selectedVehicle + "' deleted!");
                deleteVehicleFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a vehicle to delete.");
            }
        }
    });
    panel.add(deleteButton);

    deleteVehicleFrame.getContentPane().setBackground(new Color(10, 22, 39, 255));
    deleteVehicleFrame.add(panel);
    deleteVehicleFrame.setVisible(true);
}
private void addTrip() {
    JFrame tripFrame = new JFrame("Add Trip");
    tripFrame.setSize(1280, 720);
    tripFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    tripFrame.setResizable(false);
    tripFrame.setLayout(new BorderLayout());
    tripFrame.getContentPane().setBackground(new Color(10, 22, 39, 255));

    JPanel vehiclePanel = new JPanel();
    JLabel selectVehicleLabel = new JLabel("Select a vehicle:");
    selectVehicleLabel.setForeground(Color.WHITE);

    // Display the added vehicles in a dropdown
    JComboBox<String> vehicleDropdown = new JComboBox<>(addedVehicles.toArray(new String[0]));
    vehiclePanel.add(selectVehicleLabel);
    vehiclePanel.add(vehicleDropdown);

    JPanel datePanel = new JPanel();
    JLabel selectDateLabel = new JLabel("Select Date (4-10 December 2023):");
    selectDateLabel.setForeground(Color.WHITE);

    // Date selection using JSpinner
    SpinnerDateModel dateModel = new SpinnerDateModel();
    JSpinner datePicker = new JSpinner(dateModel);
    datePicker.setEditor(new JSpinner.DateEditor(datePicker, "dd/MM/yyyy"));
    datePicker.setValue(new Date()); // Set default value to current date

    datePanel.add(selectDateLabel);
    datePanel.add(datePicker);

    JButton addButton = new JButton("Add Trip");
    addButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String selectedVehicle = (String) vehicleDropdown.getSelectedItem();
            Date selectedDate = (Date) datePicker.getValue();

            // Handling selected vehicle and date
            if (selectedVehicle != null && selectedDate != null) {
                JOptionPane.showMessageDialog(null, "Trip added for " + selectedVehicle + " on " + selectedDate.toString());
                tripFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a vehicle and date.");
            }
        }
    });

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addButton);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(vehiclePanel);
    panel.add(datePanel);
    panel.add(buttonPanel);

    tripFrame.add(panel, BorderLayout.CENTER);
    tripFrame.setVisible(true);
}

        
private void deleteTrip() {
    JFrame deleteTripFrame = new JFrame("Delete Trip");
    deleteTripFrame.setSize(720, 720);
    deleteTripFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    deleteTripFrame.setResizable(false);
    deleteTripFrame.getContentPane().setBackground(new Color(10, 22, 39, 255));

    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.setBackground(new Color(10, 22, 39, 255));

    JLabel instructionLabel = new JLabel("Select a trip to delete:");
    instructionLabel.setForeground(Color.WHITE);
    panel.add(instructionLabel);

    // Display the trip details in a list
    List<String> tripDetails = new ArrayList<>();
    for (String vehicle : addedVehicles) {
        for (String date : Arrays.asList("04/12/2023", "05/12/2023", "06/12/2023", "07/12/2023", "08/12/2023", "09/12/2023", "10/12/2023")) {
            tripDetails.add(vehicle + " - " + date);
        }
    }

    JList<String> tripList = new JList<>(tripDetails.toArray(new String[0]));
    tripList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollPane = new JScrollPane(tripList);
    panel.add(scrollPane);

    JButton deleteButton = new JButton("Delete");
    deleteButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = tripList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedTrip = tripDetails.get(selectedIndex);
                tripDetails.remove(selectedIndex); // Seçilen seferi listeden kaldır
                JOptionPane.showMessageDialog(null, "Trip '" + selectedTrip + "' deleted!");
                // tripDetails listesi güncellendikten sonra, JList yeniden oluşturulmalıdır
                tripList.setListData(tripDetails.toArray(new String[0]));
            } else {
                JOptionPane.showMessageDialog(null, "Please select a trip to delete.");
            }
        }
    });
    panel.add(deleteButton);

    deleteTripFrame.add(panel);
    deleteTripFrame.setVisible(true);
}
}}
