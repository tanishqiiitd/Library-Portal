package assignment1;

public class Book {
    String name;
    String author;
    int id;
    boolean status;
    int seconds;

    Book (String name, String author, int id,boolean status, int seconds) {

        this.name = name;
        this.author = author;
        this.id = id;
        this.status = status;    //true = available , false = taken
        this.seconds = seconds;
    }

    String getname() {
        return name;
    }




    
}
