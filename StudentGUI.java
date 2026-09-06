import javax.swing.*;
import java.util.List;

public class StudentGUI {
    private Library library;

    public StudentGUI(Library library) {
        this.library = library;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("STUDENT MENU");
        frame.setSize(440, 340);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel title = new JLabel("=== STUDENT / CUSTOMER MENU ===");
        title.setBounds(100, 15, 250, 25);
        panel.add(title);

        JButton btnBrowse = new JButton("1. Browse All Books");
        btnBrowse.setBounds(80, 50, 260, 35);
        panel.add(btnBrowse);

        JButton btnSearchCategory = new JButton("2. Search Book by Category");
        btnSearchCategory.setBounds(80, 95, 260, 35);
        panel.add(btnSearchCategory);

        JButton btnCheckFine = new JButton("3. Check Unpaid Fine");
        btnCheckFine.setBounds(80, 140, 260, 35);
        panel.add(btnCheckFine);

        JButton btnBack = new JButton("4. Go Back");
        btnBack.setBounds(80, 185, 260, 35);
        panel.add(btnBack);

        // 1. Browse All Books
        btnBrowse.addActionListener(e -> DisplayWindow.showBookTable("Browse Books Catalog", library.getBooksList()));

        // 2. Search Book by Category
        btnSearchCategory.addActionListener(e -> {
            String cat = JOptionPane.showInputDialog(frame, "Enter Category (e.g., CS, Math, Literature):");
            if (cat != null && !cat.trim().isEmpty()) {
                List<Book> filtered = library.getBooksByCategory(cat.trim());
                DisplayWindow.showBookTable("Books in Category: " + cat, filtered);
            }
        });

        // 3. Check Unpaid Fine
        btnCheckFine.addActionListener(e -> {
            String studentId = JOptionPane.showInputDialog(frame, "Enter Your Student ID:");
            if (studentId != null && !studentId.trim().isEmpty()) {
                double fine = library.getStudentFine(studentId.trim());
                JOptionPane.showMessageDialog(frame, "Student ID: " + studentId + "\nUnpaid Fine: $" + fine, "Fine Status", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // 4. Go Back
        btnBack.addActionListener(e -> {
            frame.dispose();
            MainGUI.showMainMenu(library);
        });

        frame.setVisible(true);
    }
}