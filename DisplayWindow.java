import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DisplayWindow {

    public static void showBookTable(String title, List<Book> books) {
        JFrame frame = new JFrame(title);
        frame.setSize(600, 350);
        frame.setLocationRelativeTo(null);

        String[] columns = {"Book Name", "Author", "Category", "Shelf/Rack", "Copies Available"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Book b : books) {
            model.addRow(new Object[]{b.getName(), b.getAuthor(), b.getCategory(), b.getShelf(), b.getCopies()});
        }

        JTable table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void showStaffTable(String title, List<Staff> staffList) {
        JFrame frame = new JFrame(title);
        frame.setSize(600, 350);
        frame.setLocationRelativeTo(null);

        String[] columns = {"Staff ID", "Name", "Role", "Phone", "Salary"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Staff s : staffList) {
            model.addRow(new Object[]{s.getId(), s.getName(), s.getRole(), s.getPhone(), s.getSalary()});
        }

        JTable table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void showIssuedBooksTable(String title, List<String[]> records) {
        JFrame frame = new JFrame(title);
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);

        String[] columns = {"Student ID", "Book Title"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (String[] rec : records) {
            model.addRow(rec);
        }

        JTable table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}