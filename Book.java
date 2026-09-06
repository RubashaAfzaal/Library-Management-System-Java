public class Book {
    private String title;
    private String author;
    private String category;
    private String shelf;
    private int copies;

    public Book(String title, String author, String category, String shelf, int copies) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.shelf = shelf;
        this.copies = copies;
    }

    public String getTitle() { return title; }
    public String getName() { return title; } // Compatibility fallback
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public String getShelf() { return shelf; }
    public int getCopies() { return copies; }
    public void setCopies(int copies) { this.copies = copies; }

    // Methods requested by Member.java
    public boolean isAvailable() {
        return copies > 0;
    }

    public void borrowCopy() {
        if (copies > 0) {
            copies--;
        }
    }

    public void returnCopy() {
        copies++;
    }
}