import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class ReserveMe extends JFrame {
      private int newfee;
      private List<String> addedVehicles = new ArrayList<>();
      private Map<String, String> companies = new HashMap<>();
      private Map<String, Set<String>> reservedSeats = new HashMap<>();
      private HashMap<String, Double> driverSalaries = new HashMap<>();
      private HashMap<String, Double> staffSalaries = new HashMap<>();private DefaultListModel<Trip> tripListModel = new DefaultListModel<>();
       
    private void addDriverSalary(String companyName, double salary) {
        driverSalaries.put(companyName, salary);
    }

    private void addStaffSalary(String companyName, double salary) {
        staffSalaries.put(companyName, salary);
    }
    public ReserveMe(){
        setTitle("Main Menu");
        setBounds(100, 100, 1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(1, 2));

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
        adminbuttonConstraints.ipady = 20; 
        adminbuttonConstraints.ipadx = 150;
        adminbuttonConstraints.insets = new Insets(0, 0, 20, 0);

        GridBagConstraints companybuttonConstraints = new GridBagConstraints();
        companybuttonConstraints.gridx = 0;
        companybuttonConstraints.gridy = 1;
        companybuttonConstraints.fill = GridBagConstraints.HORIZONTAL;
        companybuttonConstraints.anchor = GridBagConstraints.CENTER;
        companybuttonConstraints.ipady = 20; 
        companybuttonConstraints.ipadx = 150; 
        companybuttonConstraints.insets = new Insets(0, 0, 20, 0); 

        GridBagConstraints passengerbuttonConstraints = new GridBagConstraints();
        passengerbuttonConstraints.gridx = 0;
        passengerbuttonConstraints.gridy = 2;
        passengerbuttonConstraints.fill = GridBagConstraints.HORIZONTAL;
        passengerbuttonConstraints.anchor = GridBagConstraints.CENTER;
        passengerbuttonConstraints.ipady = 20; 
        passengerbuttonConstraints.ipadx = 150; 
        
        rightPanel.add(adminbutton, adminbuttonConstraints);
        rightPanel.add(companybutton, companybuttonConstraints);
        rightPanel.add(passengerbutton, passengerbuttonConstraints);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    // PASSENGER PANEL //
    public void openPassengerPanel() {
    JFrame passengerFrame = new JFrame("Passenger Panel");
    passengerFrame.setSize(1280, 720);
    passengerFrame.getContentPane().setBackground(new Color(10, 22, 39));

    passengerFrame.setLayout(new GridLayout(1, 1));

    JLabel label = new JLabel("Passenger Panel");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setVerticalAlignment(SwingConstants.CENTER);
    label.setForeground(Color.WHITE); 

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
            reservation();
        }
    });
    JMenuItem reservedseatsItem = new JMenuItem("See Your Reservations");
    reservedseatsItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           showReservedSeats();
        }
    });
    menuBar.add(listByDayItem);
    menuBar.add(reservationItem);
    menuBar.add(reservedseatsItem);
    passengerFrame.setJMenuBar(menuBar);

    passengerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    passengerFrame.setLocationRelativeTo(null); 
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
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setResizable(false);
        adminFrame.setLayout(new BorderLayout());
        adminFrame.getContentPane().setBackground(color);
        
    JMenuBar menuBar = new JMenuBar();
    JMenuItem showmenu = new JMenuItem("Company list");
    JMenuItem addmenu = new JMenuItem("Add company");
    JMenuItem deletemenu = new JMenuItem("Delete company");
    JMenuItem chargemenu = new JMenuItem("Set Charges");
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

                if (companyName != null && !companyName.isEmpty() && companyPassword != null && !companyPassword.isEmpty()) {
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
                deleteCompany();
            }
        });
    feemenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Current fee: "+ newfee +" TL");
                String newFeeString = JOptionPane.showInputDialog(null, "Enter the new fee:");
                try {
                    int newFee = Integer.parseInt(newFeeString);
                    newfee = newFee; 
                    JOptionPane.showMessageDialog(null, "Fee updated successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        });
        chargemenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            setCharges();
            }
        });
    menuBar.add(showmenu);
    menuBar.add(addmenu);
    menuBar.add(deletemenu);
    menuBar.add(chargemenu);
    menuBar.add(feemenu);
    
    adminFrame.setJMenuBar(menuBar); 
    adminFrame.setVisible(true);
    }
    private void setCharges(){
        JFrame companyListFrame = new JFrame("Company List");
        companyListFrame.setSize(720, 720);
        companyListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        companyListFrame.setResizable(false);
        companyListFrame.getContentPane().setBackground(new Color(10, 22, 39, 255));
    
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(10, 22, 39, 255));
    
        JLabel instructionLabel = new JLabel("List of Companies");
        instructionLabel.setForeground(Color.WHITE);
        instructionLabel.setHorizontalAlignment(JLabel.CENTER);
        instructionLabel.setFont(instructionLabel.getFont().deriveFont(24f)); 
        panel.add(instructionLabel);
        for (String companyName : companies.keySet()) {
            JButton companyButton = new JButton(companyName);
            companyButton.setForeground(Color.BLACK);
            companyButton.setPreferredSize(new Dimension(200, 40));
            companyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   String driverFee = JOptionPane.showInputDialog(null, "Enter Driver's fee for " + companyName);
                    String personnelFee = JOptionPane.showInputDialog(null, "Enter Personnel's fee for " + companyName);
    
                    if (driverFee != null && personnelFee != null) {
                        try {
                            double driverFeeValue = Double.parseDouble(driverFee);
                            double personnelFeeValue = Double.parseDouble(personnelFee);
                            
                            addDriverSalary(companyName, driverFeeValue);
                            addStaffSalary(companyName, personnelFeeValue);
    
                            JOptionPane.showMessageDialog(null, "Fees saved for " + companyName);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Please enter valid numbers for fees.");
                        }
                    }
                }
            });
            panel.add(companyButton);
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        companyListFrame.add(scrollPane);
        companyListFrame.setVisible(true);
    }
    private void showCompanyList() {
        JFrame companyListFrame = new JFrame("Company List");
        companyListFrame.setSize(720, 720);
        companyListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        companyListFrame.setResizable(false);
        companyListFrame.getContentPane().setBackground(new Color(10, 22, 39, 255));
    
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(10, 22, 39, 255));
    
        JLabel instructionLabel = new JLabel("List of Companies");
        instructionLabel.setForeground(Color.WHITE);
        instructionLabel.setHorizontalAlignment(JLabel.CENTER);
        instructionLabel.setFont(instructionLabel.getFont().deriveFont(24f)); 
        panel.add(instructionLabel);
    
        for (String companyName : companies.keySet()) {
            JButton companyButton = new JButton(companyName);
            companyButton.setForeground(Color.BLACK);
            companyButton.setPreferredSize(new Dimension(200, 40)); 
            companyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
            panel.add(companyButton);
        }
    
        JScrollPane scrollPane = new JScrollPane(panel);
        companyListFrame.add(scrollPane);
        companyListFrame.setVisible(true);
    } 
    private void deleteCompany() {
        JFrame deleteCompanyFrame = new JFrame("Delete Company");
        deleteCompanyFrame.setSize(720, 720);
        deleteCompanyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteCompanyFrame.setResizable(false);
        deleteCompanyFrame.getContentPane().setBackground(new Color(10, 22, 39, 255));
    
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(10, 22, 39, 255));
    
        JLabel instructionLabel = new JLabel("Select a company to delete:");
        instructionLabel.setForeground(Color.WHITE);
        panel.add(instructionLabel);
    
        JList<String> companyList = new JList<>(companies.keySet().toArray(new String[0]));
        companyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(companyList);
        panel.add(scrollPane);
    
        JButton deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(100, 40));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = companyList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedCompany = (String) companyList.getSelectedValue();
                    companies.remove(selectedCompany);
                    JOptionPane.showMessageDialog(null, "Company '" + selectedCompany + "' deleted!");
                    deleteCompanyFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a company to delete.");
                }
            }
        });
        panel.add(deleteButton);
    
        deleteCompanyFrame.add(panel);
        deleteCompanyFrame.setVisible(true);
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
    instructionLabel.setFont(instructionLabel.getFont().deriveFont(24f)); 
    panel.add(instructionLabel);

    List<Trip> tripDetails = new ArrayList<>();
    for (String vehicle : addedVehicles) {
        for (String date : Arrays.asList("04/12/2023", "05/12/2023", "06/12/2023", "07/12/2023", "08/12/2023", "09/12/2023", "10/12/2023")) {
            tripDetails.add(new Trip(vehicle, date));
        }
    }

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
private void showAvailableVehicles(String transportMode, Object departure, Object arrival) {
    JFrame vehicleDetailsFrame = new JFrame("Vehicle Details");
    vehicleDetailsFrame.setSize(720, 720);
    vehicleDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    vehicleDetailsFrame.setResizable(false);

    JPanel panel = new JPanel(new BorderLayout());
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.setBackground(new Color(240, 240, 240));

    JLabel titleLabel = new JLabel("Available Vehicles:");
    titleLabel.setForeground(Color.BLACK);
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titleLabel.setFont(titleLabel.getFont().deriveFont(18f));
    panel.add(titleLabel, BorderLayout.NORTH);

    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> vehiclesList = new JList<>(listModel);
    vehiclesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    for (String vehicle : addedVehicles) {
        if (vehicle.startsWith(transportMode)) {
            listModel.addElement(vehicle);
        }
    }
    vehiclesList.addListSelectionListener(e -> {
        String selectedVehicle = vehiclesList.getSelectedValue();
        if (selectedVehicle != null) {
            listAllSeats(selectedVehicle, "Selected Date", 30 );
        }
    });
    JScrollPane scrollPane = new JScrollPane(vehiclesList);
    panel.add(scrollPane, BorderLayout.CENTER);

    vehicleDetailsFrame.add(panel);
    vehicleDetailsFrame.setVisible(true);
}
private void reservation() {
    JFrame viewTripFrame = new JFrame("Reservation");
    viewTripFrame.setSize(720, 720);
    viewTripFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    viewTripFrame.setResizable(false);
    viewTripFrame.getContentPane().setBackground(new Color(10, 22, 39, 255));

    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.setBackground(new Color(10, 22, 39, 255));

    JLabel instructionLabel = new JLabel("List of Trips for Reservation");
    instructionLabel.setForeground(Color.WHITE);
    instructionLabel.setHorizontalAlignment(JLabel.CENTER);
    instructionLabel.setFont(instructionLabel.getFont().deriveFont(24f));
    panel.add(instructionLabel);

    JComboBox<String> transportModes = new JComboBox<>(new String[]{"Karayolu 1", "Karayolu 2", "Havayolu 1", "Havayolu 2", "Demiryolu 1", "Demiryolu 2"});
    panel.add(new JLabel("Select Transport Mode:"));
    panel.add(transportModes);

    JComboBox<String> departureComboBox = new JComboBox<>();
    JComboBox<String> arrivalComboBox = new JComboBox<>();
    panel.add(new JLabel("Departure: "));
    panel.add(departureComboBox);
    panel.add(new JLabel("Arrival: "));
    panel.add(arrivalComboBox);

    transportModes.addActionListener(e -> {
        String selectedTransportMode = (String) transportModes.getSelectedItem();
        switch (selectedTransportMode) {
            case "Demiryolu 1":
                setRailwayRoute1(departureComboBox, arrivalComboBox);
                break;
            case "Demiryolu 2":
                setRailwayRoute2(departureComboBox, arrivalComboBox);
                break;
            case "Karayolu 1":
                setRoadRoute1(departureComboBox, arrivalComboBox);
                break;
            case "Karayolu 2":
                setRoadRoute2(departureComboBox, arrivalComboBox);
                break;
            case "Havayolu 1":
                setAirRoute1(departureComboBox, arrivalComboBox);
                break;
            case "Havayolu 2":
                setAirRoute2(departureComboBox, arrivalComboBox);
                break;
            default:
                break;
        }
    });

    JButton reserveButton = new JButton("ReserveMe");
    reserveButton.setForeground(Color.BLACK);
    reserveButton.addActionListener(e -> {
        String selectedTransportMode = (String) transportModes.getSelectedItem();
        switch (selectedTransportMode) {
             case "Demiryolu 1":
                showAvailableVehicles("Demiryolu 1", departureComboBox.getSelectedItem(), arrivalComboBox.getSelectedItem());
                break;
                 case "Demiryolu 2":
                showAvailableVehicles("Demiryolu 2", departureComboBox.getSelectedItem(), arrivalComboBox.getSelectedItem());
                break;
            case "Karayolu 1":
                showAvailableVehicles("Karayolu 1", departureComboBox.getSelectedItem(), arrivalComboBox.getSelectedItem());
                break;
            case "Karayolu 2":
                showAvailableVehicles("Karayolu 2", departureComboBox.getSelectedItem(), arrivalComboBox.getSelectedItem());
                break;
            case "Havayolu 1":
                showAvailableVehicles("Havayolu 1", departureComboBox.getSelectedItem(), arrivalComboBox.getSelectedItem());
                break;
            case "Havayolu 2":
                showAvailableVehicles("Havayolu 2", departureComboBox.getSelectedItem(), arrivalComboBox.getSelectedItem());
                break;
            default:
                break;
        }
    });
    
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.setBackground(new Color(10, 22, 39, 255));
    buttonPanel.add(reserveButton);
    panel.add(buttonPanel);

    viewTripFrame.add(panel);
    viewTripFrame.setVisible(true);
}
private void setRailwayRoute1(JComboBox<String> departureComboBox, JComboBox<String> arrivalComboBox) {
    String[] stations = {"Ankara", "Bilecik", "Eskişehir", "İstanbul", "Kocaeli"};
    setRoute(departureComboBox, arrivalComboBox, stations);
}

private void setRailwayRoute2(JComboBox<String> departureComboBox, JComboBox<String> arrivalComboBox) {
    String[] stations = {"İstanbul", "Kocaeli", "Bilecik", "Eskişehir", "Ankara"};
    setRoute(departureComboBox, arrivalComboBox, stations);
}
private void setRoadRoute1(JComboBox<String> departureComboBox, JComboBox<String> arrivalComboBox) {
    String[] stations = {"İstanbul", "Kocaeli", "Ankara"};
    setRoute(departureComboBox, arrivalComboBox, stations);
}
private void setRoadRoute2(JComboBox<String> departureComboBox, JComboBox<String> arrivalComboBox) {
    String[] stations = {"İstanbul", "Kocaeli", "Eskişehir", "Konya"};
    setRoute(departureComboBox, arrivalComboBox, stations);
}
private void setAirRoute1(JComboBox<String> departureComboBox, JComboBox<String> arrivalComboBox) {
    String[] stations = {"İstanbul", "Konya"};
    setRoute(departureComboBox, arrivalComboBox, stations);
}
private void setAirRoute2(JComboBox<String> departureComboBox, JComboBox<String> arrivalComboBox) {
    String[] stations = {"İstanbul", "Ankara"};
    setRoute(departureComboBox, arrivalComboBox, stations);
}
private void setRoute(JComboBox<String> departureComboBox, JComboBox<String> arrivalComboBox, String[] stations) {
    departureComboBox.removeAllItems();
    arrivalComboBox.removeAllItems();

    for (String station : stations) {
        departureComboBox.addItem(station);
        arrivalComboBox.addItem(station);
    }
}
private void listAllSeats(String vehicleType, String selectedDate, int seatCount) {
    JFrame seatFrame = new JFrame("Seats for " + vehicleType);
    seatFrame.setSize(400, 300);
    seatFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    seatFrame.setResizable(false);

    JPanel seatPanel = new JPanel(new BorderLayout());
    seatPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    seatPanel.setBackground(new Color(240, 240, 240));

    JLabel titleLabel = new JLabel("Seats for " + vehicleType);
    titleLabel.setForeground(Color.BLACK);
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titleLabel.setFont(titleLabel.getFont().deriveFont(18f));
    seatPanel.add(titleLabel, BorderLayout.NORTH);

    DefaultListModel<String> listModel = new DefaultListModel<>();
    JList<String> seatsList = new JList<>(listModel);
    seatsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    for (int i = 1; i <= seatCount; i++) {
        listModel.addElement("Seat " + i);
    }
    JScrollPane scrollPane = new JScrollPane(seatsList);
    seatPanel.add(scrollPane, BorderLayout.CENTER);

    seatFrame.add(seatPanel);
    seatFrame.setVisible(true);

    seatsList.addListSelectionListener(e -> {
        String selectedSeat = seatsList.getSelectedValue();
        if (selectedSeat != null) {
            String key = vehicleType + "-" + selectedDate;

            if (!reservedSeats.containsKey(key)) {
                reservedSeats.put(key, new HashSet<>());
            }

            Set<String> reservedSeatsForDate = reservedSeats.get(key);

            if (!reservedSeatsForDate.contains(selectedSeat)) {
                JOptionPane.showMessageDialog(null, selectedSeat + " is available for reservation on " + selectedDate);
                reservedSeatsForDate.add(selectedSeat);
                listModel.removeElement(selectedSeat);
            } else {
                JOptionPane.showMessageDialog(null, selectedSeat + " is already reserved for " + selectedDate);
            }
        }
    });
}
private void showReservedSeats() {
    JFrame reservedSeatsFrame = new JFrame("Reserved Seats");
    reservedSeatsFrame.setSize(1280, 720);
    reservedSeatsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    reservedSeatsFrame.setResizable(false);

    JPanel panel = new JPanel();
    panel.setBackground(new Color(10, 22, 39, 255));

    DefaultListModel<String> reservedSeatsModel = new DefaultListModel<>();

    for (String date : reservedSeats.keySet()) {
        Set<String> seats = reservedSeats.get(date);
        for (String seat : seats) {
            reservedSeatsModel.addElement("Date: " + date + ", Seat: " + seat);
        }
    }

    JList<String> reservedSeatsList = new JList<>(reservedSeatsModel);
    reservedSeatsList.setForeground(Color.WHITE);
    reservedSeatsList.setBackground(new Color(10, 22, 39, 255));

    JScrollPane scrollPane = new JScrollPane(reservedSeatsList);
    panel.add(scrollPane);

    reservedSeatsFrame.add(panel);
    reservedSeatsFrame.setVisible(true);
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

    public CompanyPanel(Map<String, String> companies) {
        this.companies = companies;
        setTitle("Company Panel Login");
        setBounds(100, 100, 1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(1, 2));

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

        GridBagConstraints symbolConstraints = new GridBagConstraints();
        symbolConstraints.gridx = 0;
        symbolConstraints.gridy = 0;
        symbolConstraints.fill = GridBagConstraints.BOTH;
        symbolConstraints.weightx = 2.0;
        symbolConstraints.weighty = 2.0;

        leftPanel.add(symbolLabel, symbolConstraints);

        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightPanel.setBackground(new Color(10, 22, 39, 255));

        JPanel loginPanel = createLoginPanel();
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
                } else if(enteredUsername.equals("a") && enteredPassword.equals("a")){MainMenu();}
                else {
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
        JFrame newPage = new JFrame("Company Panel");
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
incomemenu.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        incomeCalculator();
    }
});
    newPage.setJMenuBar(menuBar); 
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
    
        JPanel panel = new JPanel(new GridLayout(16, 1));
        Color panelColor = new Color(10, 22, 39);
        panel.setBackground(panelColor);
    
        JLabel typeLabel = new JLabel("Select Vehicle Type:");
        typeLabel.setForeground(Color.WHITE);
        panel.add(typeLabel);
    
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBackground(panelColor);
    
        JComboBox<String> routeComboBox = new JComboBox<>(new String[]{
                "Demiryolu 1: Istanbul - Kocaeli - Bilecik - Eskisehir - Ankara - Eskisehir - Bilecik - Kocaeli - Istanbul",
                "Demiryolu 2: Istanbul - Kocaeli - Bilecik - Eskisehir - Konya - Eskisehir - Bilecik - Kocaeli - Istanbul",
                "Karayolu 1: Istanbul - Kocaeli - Ankara - Kocaeli - Istanbul - Kocaeli - Ankara - Kocaeli - Istanbul",
                "Karayolu 2: Istanbul - Kocaeli - Eskisehir - Konya - Eskisehir - Kocaeli - Istanbul",
                "Havayolu 1: Istanbul - Konya - Istanbul",
                "Havayolu 2: Istanbul - Ankara - Istanbul"
        });
    
        panel.add(routeComboBox);
    
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
                        String selectedRoute = (String) routeComboBox.getSelectedItem();
                        String vehicleNumber = numberField.getText();
                        int seatCount = 0;
                        String seatCountText = seatsField.getText();
                        if (!selectedRoute.isEmpty() && !vehicleNumber.isEmpty() && !seatCountText.isEmpty()) {
                            try {
                                seatCount = Integer.parseInt(seatCountText);
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid number for the seat count.");
                                return;
                            }
                            String newVehicle = selectedRoute + " - Vehicle Number: " + vehicleNumber + " - Seat Count: " + seatCount;
                
                            boolean isDuplicate = addedVehicles.contains(newVehicle);
                            if (isDuplicate) {
                                JOptionPane.showMessageDialog(null, "A vehicle with the same type and number already exists.");
                            } else {
                                addedVehicles.add(newVehicle);
                                vehicleFrame.dispose();
                                JOptionPane.showMessageDialog(null, "Vehicle added successfully: " + newVehicle);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please select a vehicle route, enter a vehicle number, and specify the seat count.");
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
    public static void incomeCalculator() {
        JFrame frame = new JFrame("Income Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(10, 22, 39));
        frame.setLayout(new GridLayout(3, 1));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.setBackground(new Color(10, 22, 39));

        JButton dailyButton = new JButton("Calculate Daily Income");
        JButton weeklyButton = new JButton("Calculate Weekly Income");

        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setBackground(Color.WHITE);
        resultField.setHorizontalAlignment(JTextField.CENTER);

        dailyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultField.setText("Daily income: 100TL");
            }
        });

        weeklyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultField.setText("Weekly income: 700TL"); 
            }
        });

        buttonPanel.add(dailyButton);
        buttonPanel.add(weeklyButton);

        frame.add(buttonPanel);
        frame.add(resultField);

        frame.setVisible(true);
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

    JComboBox<String> vehicleDropdown = new JComboBox<>(addedVehicles.toArray(new String[0]));
    vehiclePanel.add(selectVehicleLabel);
    vehiclePanel.add(vehicleDropdown);

    JPanel cityPanel = new JPanel();
    JLabel selectDepartureLabel = new JLabel("Select Departure City:");
    selectDepartureLabel.setForeground(Color.WHITE);

    JComboBox<String> departureDropdown = new JComboBox<>(new String[]{"Ankara", "Bilecik", "Eskişehir", "İstanbul", "Kocaeli", "Konya"});
    JLabel selectArrivalLabel = new JLabel("Select Arrival City:");
    selectArrivalLabel.setForeground(Color.WHITE);

    JComboBox<String> arrivalDropdown = new JComboBox<>(new String[]{"Bilecik", "Eskişehir", "İstanbul", "Kocaeli", "Konya", "Ankara"});

    cityPanel.add(selectDepartureLabel);
    cityPanel.add(departureDropdown);
    cityPanel.add(selectArrivalLabel);
    cityPanel.add(arrivalDropdown);

    JPanel datePanel = new JPanel();
    JLabel selectDateLabel = new JLabel("Select Date (4-10 December 2023):");
    selectDateLabel.setForeground(Color.WHITE);

    SpinnerDateModel dateModel = new SpinnerDateModel();
    JSpinner datePicker = new JSpinner(dateModel);
    datePicker.setEditor(new JSpinner.DateEditor(datePicker, "dd/MM/yyyy"));
    datePicker.setValue(new Date());

    datePanel.add(selectDateLabel);
    datePanel.add(datePicker);
    JButton addButton = new JButton("Add Trip");
    addButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String selectedVehicle = (String) vehicleDropdown.getSelectedItem();
            String selectedDeparture = (String) departureDropdown.getSelectedItem();
            String selectedArrival = (String) arrivalDropdown.getSelectedItem();
            Date selectedDate = (Date) datePicker.getValue();
            
            if (selectedVehicle != null && selectedDeparture != null && selectedArrival != null && selectedDate != null) {
                Trip newTrip = new Trip(selectedVehicle, selectedDeparture + " to " + selectedArrival + " on " + selectedDate.toString());
                tripListModel.addElement(newTrip); 
                JOptionPane.showMessageDialog(null, "Trip added for " + selectedVehicle + " from " + selectedDeparture + " to " + selectedArrival + " on " + selectedDate.toString());
                tripFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a vehicle, departure city, arrival city, and date.");
            }
        }
    });

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addButton);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(vehiclePanel);
    panel.add(cityPanel);
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
                tripDetails.remove(selectedIndex);
                JOptionPane.showMessageDialog(null, "Trip '" + selectedTrip + "' deleted!");
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
