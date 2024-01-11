package assignment1;

import java.util.ArrayList;

public class Member {
    private String name;
    private int age;
    private Long phone;
    private int memberid;
    private int fine;
    private ArrayList<Book> issuedbooks;

    public Member(String name, int age, Long phone, int memberid, int fine, ArrayList<Book> issuedbooks) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.memberid = memberid;
        this.fine = fine;
        this.issuedbooks = issuedbooks;
    }
}
