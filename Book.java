package assignment1;

public class Book {
    private String name;
    private String author;
    private int id;
    private boolean status;
    private int seconds;

    public Book(String name, String author, int id, boolean status, int seconds) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.status = status;    // true = available, false = taken
        this.seconds = seconds;
    }

    public String getName() {
        return name;
    }
}
