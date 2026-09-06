import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {
    public static void main(String[] args) {
        // Initialize central library instance
        Library myLibrary = new Library();

        // Sample Data Initialization
        Staff s1 = new Staff(1, "Ayesha", "Lahore", 1234567, 50000.0, "Librarian");
        Staff s2 = new Staff(2, "Ahmad", "Nankana", 7654321, 35000.0, "Assistant");
        myLibrary.addStaff(s1);
        myLibrary.addStaff(s2);

        // Frame Setup
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(400, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel titleLabel = new JLabel("=== MAIN PORTAL SELECTION ===");
        titleLabel.setBounds(90, 20, 220, 25);
        panel.add(titleLabel);

        // Portal Selection Buttons
        JButton btnAdmin = new JButton("1. Admin Portal");
        btnAdmin.setBounds(90, 60, 220, 35);
        panel.add(btnAdmin);

        JButton btnStaff = new JButton("2. Librarian / Staff Portal");
        btnStaff.setBounds(90, 110, 220, 35);
        panel.add(btnStaff);

        JButton btnStudent = new JButton("3. Student / Customer Portal");
        btnStudent.setBounds(90, 160, 220, 35);
        panel.add(btnStudent);

        JButton btnExit = new JButton("4. Exit");
        btnExit.setBounds(90, 210, 220, 35);
        panel.add(btnExit);

        // 1. Admin Portal Action
        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputUser = JOptionPane.showInputDialog(frame, "Enter Admin Username:");
                String inputPass = JOptionPane.showInputDialog(frame, "Enter Admin Password:");

                if (inputUser != null && inputPass != null && Admin.verifyLogin(inputUser, inputPass)) {
                    JOptionPane.showMessageDialog(frame, "Login Successful! Welcome Admin.");
                    frame.dispose();
                    new AdminGUI(myLibrary);
                } else if (inputUser != null) {
                    JOptionPane.showMessageDialog(frame, "Invalid Admin Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 2. Staff Portal Action
        btnStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Opening Staff Portal...");
                // You can attach a Staff Dashboard GUI here
            }
        });

        // 3. Student Portal Action
        btnStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new StudentGUI(myLibrary);
            }
        });

        // 4. Exit Action
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}