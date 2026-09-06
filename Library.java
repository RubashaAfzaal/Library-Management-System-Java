import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Staff> staffList = new ArrayList<>();
    private List<String[]> issuedRecords = new ArrayList<>();

    // --- Basic Adders ---
    public void addBook(Book book) {
        books.add(book);
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    // --- List Getters for GUI Windows ---
    public List<Book> getBooksList() {
        return books;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public List<String[]> getIssuedRecordsList() {
        return issuedRecords;
    }

    // --- File Storage ---
    public void saveBookToFile(Book book) {
        try (FileWriter fw = new FileWriter("books.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(book.getName() + "," + book.getAuthor() + "," + book.getCategory() + "," + book.getShelf() + "," + book.getCopies());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --- Methods Expected by Main.java ---
    public void displayTimings() {
        System.out.println("=== LIBRARY TIMINGS ===");
        System.out.println("Monday - Friday: 8:00 AM - 4:00 PM");
    }

    public void displayAllStaff() {
        System.out.println("=== ALL STAFF MEMBERS ===");
        for (Staff s : staffList) {
            System.out.println("ID: " + s.getId() + " | Name: " + s.getName() + " | Role: " + s.getRole());
        }
    }

    public void displayAllBooks() {
        System.out.println("=== ALL BOOKS ===");
        for (Book b : books) {
            System.out.println("Title: " + b.getName() + " | Author: " + b.getAuthor() + " | Copies: " + b.getCopies());
        }
    }

    public void displayIssuedHistory() {
        System.out.println("=== ISSUED BOOKS HISTORY ===");
        for (String[] rec : issuedRecords) {
            System.out.println("Student ID: " + rec[0] + " | Book: " + rec[1]);
        }
    }

    public void displayIssuedBooks() {
        displayIssuedHistory();
    }

    public void searchByCategory(String category) {
        System.out.println("=== BOOKS IN CATEGORY: " + category + " ===");
        for (Book b : books) {
            if (b.getCategory().equalsIgnoreCase(category)) {
                System.out.println("Title: " + b.getName() + " | Author: " + b.getAuthor());
            }
        }
    }

    // --- Methods Expected by StudentGUI / LibrarianGUI ---
    public List<Book> getBooksByCategory(String category) {
        List<Book> filtered = new ArrayList<>();
        for (Book b : books) {
            if (b.getCategory().equalsIgnoreCase(category)) {
                filtered.add(b);
            }
        }
        return filtered;
    }

    public boolean issueBook(String studentId, String bookTitle) {
        for (Book b : books) {
            if (b.getName().equalsIgnoreCase(bookTitle) && b.getCopies() > 0) {
                b.setCopies(b.getCopies() - 1);
                issuedRecords.add(new String[]{studentId, bookTitle});
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String studentId, String bookTitle) {
        for (int i = 0; i < issuedRecords.size(); i++) {
            String[] rec = issuedRecords.get(i);
            if (rec[0].equalsIgnoreCase(studentId) && rec[1].equalsIgnoreCase(bookTitle)) {
                issuedRecords.remove(i);
                for (Book b : books) {
                    if (b.getName().equalsIgnoreCase(bookTitle)) {
                        b.setCopies(b.getCopies() + 1);
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public double getStudentFine(String studentId) {
        return 0.00;
    }
}