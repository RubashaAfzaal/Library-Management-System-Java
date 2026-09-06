import javax.swing.*;

public class AdminGUI {
    private Library library;

    public AdminGUI(Library library) {
        this.library = library;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("ADMIN MENU");
        frame.setSize(450, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel title = new JLabel("=== ADMIN CONTROL MENU ===");
        title.setBounds(120, 15, 220, 25);
        panel.add(title);

        JButton btnViewBooks = new JButton("1. View All Books");
        btnViewBooks.setBounds(90, 50, 260, 35);
        panel.add(btnViewBooks);

        JButton btnAddBook = new JButton("2. Add New Book (Save to File)");
        btnAddBook.setBounds(90, 95, 260, 35);
        panel.add(btnAddBook);

        JButton btnAddStaff = new JButton("3. Add Staff Member");
        btnAddStaff.setBounds(90, 140, 260, 35);
        panel.add(btnAddStaff);

        JButton btnViewStaff = new JButton("4. View All Staff");
        btnViewStaff.setBounds(90, 185, 260, 35);
        panel.add(btnViewStaff);

        JButton btnIssued = new JButton("5. Check Issued Books");
        btnIssued.setBounds(90, 230, 260, 35);
        panel.add(btnIssued);

        JButton btnLogout = new JButton("6. Logout");
        btnLogout.setBounds(90, 275, 260, 35);
        panel.add(btnLogout);

        // 1. View All Books
        btnViewBooks.addActionListener(e -> DisplayWindow.showBookTable("All Library Books", library.getBooksList()));

        // 2. Add New Book
        btnAddBook.addActionListener(e -> {
            try {
                String name = JOptionPane.showInputDialog(frame, "Enter Book Name:");
                if (name == null || name.isEmpty()) return;
                String author = JOptionPane.showInputDialog(frame, "Enter Author Name:");
                String category = JOptionPane.showInputDialog(frame, "Enter Category:");
                String shelf = JOptionPane.showInputDialog(frame, "Enter Shelf/Rack:");
                int copies = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Total Copies:"));

                Book newBook = new Book(name, author, category, shelf, copies);
                library.addBook(newBook);
                library.saveBookToFile(newBook);
                JOptionPane.showMessageDialog(frame, "Book Successfully Added & Saved!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid details entered.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // 3. Add Staff Member
        btnAddStaff.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Staff ID:"));
                String name = JOptionPane.showInputDialog(frame, "Enter Staff Name:");
                String role = JOptionPane.showInputDialog(frame, "Enter Role:");
                int phone = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Phone Number:"));
                double salary = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter Salary:"));

                Staff s = new Staff(id, name, role, phone, salary);
                library.addStaff(s);
                JOptionPane.showMessageDialog(frame, "Staff Member Added Successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input details.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // 4. View All Staff
        btnViewStaff.addActionListener(e -> DisplayWindow.showStaffTable("All Staff Members", library.getStaffList()));

        // 5. Check Issued Books
        btnIssued.addActionListener(e -> DisplayWindow.showIssuedBooksTable("Issued Books Log", library.getIssuedRecordsList()));

        // 6. Logout
        btnLogout.addActionListener(e -> {
            frame.dispose();
            MainGUI.showMainMenu(library);
        });

        frame.setVisible(true);
    }
}