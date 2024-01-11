package assign1.lib.src.main.java.library;

import java.util.ArrayList;

public class Member {
    String name;
    int age;
    Long phone;
    int memberid;
    int fine;
    ArrayList<Book> issuedbooks = new ArrayList<Book>();

    Member (String name, int age, Long phone, int memberid, int fine, ArrayList<Book> issuedbooks) {

        this.name = name;
        this.age = age;
        this.phone = phone;
        this.memberid = memberid;
        this.fine = fine;
        this.issuedbooks = issuedbooks;
    }

}
