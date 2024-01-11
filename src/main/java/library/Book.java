package assign1.lib.src.main.java.library;

public class Book {
    String name;
    String author;
    int id;
    boolean status;

    Book (String name, String author, int id,boolean status) {

        this.name = name;
        this.author = author;
        this.id = id;
        this.status = status;    //true = available , false = taken
    }

    String getname() {
        return name;
    }
}
