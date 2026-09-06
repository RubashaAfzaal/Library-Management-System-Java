import javax.swing.*;

public class LibrarianGUI {
    private Library library;

    public LibrarianGUI(Library library) {
        this.library = library;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("LIBRARIAN MENU");
        frame.setSize(440, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel title = new JLabel("=== LIBRARIAN PORTAL ===");
        title.setBounds(130, 15, 200, 25);
        panel.add(title);

        JButton btnViewBooks = new JButton("1. View All Books");
        btnViewBooks.setBounds(80, 50, 260, 35);
        panel.add(btnViewBooks);

        JButton btnIssue = new JButton("2. Issue / Lend Book");
        btnIssue.setBounds(80, 95, 260, 35);
        panel.add(btnIssue);

        JButton btnReturn = new JButton("3. Return Book");
        btnReturn.setBounds(80, 140, 260, 35);
        panel.add(btnReturn);

        JButton btnHistory = new JButton("4. Check Issued Books History");
        btnHistory.setBounds(80, 185, 260, 35);
        panel.add(btnHistory);

        JButton btnBack = new JButton("5. Go Back");
        btnBack.setBounds(80, 230, 260, 35);
        panel.add(btnBack);

        // 1. View All Books
        btnViewBooks.addActionListener(e -> DisplayWindow.showBookTable("All Library Books", library.getBooksList()));

        // 2. Issue Book
        btnIssue.addActionListener(e -> {
            String studentId = JOptionPane.showInputDialog(frame, "Enter Student ID:");
            if (studentId == null || studentId.isEmpty()) return;
            String bookTitle = JOptionPane.showInputDialog(frame, "Enter Book Title to Issue:");
            if (bookTitle == null || bookTitle.isEmpty()) return;

            boolean success = library.issueBook(studentId, bookTitle);
            if (success) {
                JOptionPane.showMessageDialog(frame, "Book '" + bookTitle + "' issued to Student " + studentId);
            } else {
                JOptionPane.showMessageDialog(frame, "Book unavailable or copy limit reached!", "Issue Failed", JOptionPane.WARNING_MESSAGE);
            }
        });

        // 3. Return Book
        btnReturn.addActionListener(e -> {
            String studentId = JOptionPane.showInputDialog(frame, "Enter Student ID:");
            if (studentId == null || studentId.isEmpty()) return;
            String bookTitle = JOptionPane.showInputDialog(frame, "Enter Book Title to Return:");
            if (bookTitle == null || bookTitle.isEmpty()) return;

            boolean success = library.returnBook(studentId, bookTitle);
            if (success) {
                JOptionPane.showMessageDialog(frame, "Book '" + bookTitle + "' returned successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Record not found!", "Return Failed", JOptionPane.WARNING_MESSAGE);
            }
        });

        // 4. Check Issued Books History
        btnHistory.addActionListener(e -> DisplayWindow.showIssuedBooksTable("Issued Books History", library.getIssuedRecordsList()));

        // 5. Go Back
        btnBack.addActionListener(e -> {
            frame.dispose();
            MainGUI.showMainMenu(library);
        });

        frame.setVisible(true);
    }
}