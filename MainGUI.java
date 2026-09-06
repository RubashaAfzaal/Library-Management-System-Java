import javax.swing.*;
import java.io.*;

public class MainGUI {
    public static void main(String[] args) {
        Library library = new Library();

        // Reads saved files at startup
        loadAdminData();
        loadBooksData(library);

        // Pre-populate initial staff data if list is empty
        if (library.getStaffList().isEmpty()) {
            library.addStaff(new Staff(101, "Ayesha", "Librarian", 1234567, 50000.0));
            library.addStaff(new Staff(102, "Ali", "Assistant", 7654321, 35000.0));
        }

        showMainMenu(library);
    }

    public static void showMainMenu(Library library) {
        JFrame frame = new JFrame("Library Management System - Main Menu");
        frame.setSize(440, 360);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel titleLabel = new JLabel("=== MAIN MENU (Choose Your Role) ===");
        titleLabel.setBounds(90, 20, 280, 25);
        panel.add(titleLabel);

        JButton btnAdmin = new JButton("1. Admin Login");
        btnAdmin.setBounds(90, 60, 250, 35);
        panel.add(btnAdmin);

        JButton btnLibrarian = new JButton("2. Librarian Portal");
        btnLibrarian.setBounds(90, 105, 250, 35);
        panel.add(btnLibrarian);

        JButton btnStudent = new JButton("3. Student / Customer");
        btnStudent.setBounds(90, 150, 250, 35);
        panel.add(btnStudent);

        JButton btnExit = new JButton("4. Exit Program");
        btnExit.setBounds(90, 195, 250, 35);
        panel.add(btnExit);

        btnAdmin.addActionListener(e -> {
            String user = JOptionPane.showInputDialog(frame, "Enter Admin Username:");
            String pass = JOptionPane.showInputDialog(frame, "Enter Admin Password:");
            if (user != null && pass != null && user.equals("admin") && pass.equals("1234")) {
                frame.dispose();
                new AdminGUI(library);
            } else if (user != null) {
                JOptionPane.showMessageDialog(frame, "Invalid Admin Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnLibrarian.addActionListener(e -> {
            frame.dispose();
            new LibrarianGUI(library);
        });

        btnStudent.addActionListener(e -> {
            frame.dispose();
            new StudentGUI(library);
        });

        btnExit.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    private static void loadAdminData() {
        File file = new File("admin.txt");
        if (!file.exists()) {
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println("admin");
                writer.println("1234");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void loadBooksData(Library library) {
        File file = new File("books.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length >= 5) {
                        Book book = new Book(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(), Integer.parseInt(parts[4].trim()));
                        library.addBook(book);
                    }
                }
            } catch (Exception ex) {
                System.out.println("Error reading books.txt file.");
            }
        } else {
            // Seed sample books if books.txt doesn't exist yet
            Book b1 = new Book("Java Programming", "Ali", "CS", "Shelf A1", 5);
            Book b2 = new Book("Data Structures", "Sara", "CS", "Shelf B2", 3);
            library.addBook(b1);
            library.addBook(b2);
        }
    }
}