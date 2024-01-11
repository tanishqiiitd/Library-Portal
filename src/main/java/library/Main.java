package assign1.lib.src.main.java.library;
    

import assign1.lib.src.main.resources.*;
import java.util.ArrayList;
import java.util.Scanner;

import assignment1.Book;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!"); System.out.println("Library portal initialized....");
        System.out.println("------------------------");

        int enter = 0;

        Scanner input = new Scanner(System.in);

        //Variables which are needed outside loop.
        int bookid = 1;
        int memid = 1;
        


        ArrayList<Book> bookshelf = new ArrayList<Book>();
        ArrayList<Member> Memberlist = new ArrayList<Member>();



        while (enter!=3) {
            System.out.println("1.   Enter as a librarian");
            System.out.println("2.   Enter as a member");
            System.out.println("3.   Exit");
            System.out.println("------------------");
            enter = input.nextInt();
            input.nextLine();
            System.out.println("------------------");

            int action;  //takes input for action in 1,2 cases.




            if(enter==1) {                 //librarian actions
                
                
                while(true) {
                    //System.out.println("You have entered as librarian.");
                    System.out.println("1.   Register a member");
                    System.out.println("2.   Remove a member");
                    System.out.println("3.   Add a book");
                    System.out.println("4.   Remove a book");
                    System.out.println("5.   View all members along with their books and fines to be paid");
                    System.out.println("6.   View all books");
                    System.out.println("7.   Back");

                    System.out.println("------------------");
                    action = input.nextInt();
                    input.nextLine();
                    System.out.println("------------------");

                    if (action<1 || action>7) {
                        System.out.println("Please enter correct option.");
                        System.out.println("------------------");
                        continue;
                    }
                    else if (action==7) {
                        break;
                    }

                    else if (action==1) {              //register a member
                        System.out.print("Name: ");
                        String namee = input.nextLine();
                        System.out.print("Age: ");
                        int agee=input.nextInt();
                        input.nextLine();
                        System.out.print("Phone no: ");
                        Long phone = input.nextLong();
                        input.nextLine();
                        
                        if (phone<1000000000) {
                            System.out.println("------------------");
                            System.out.println("Please enter correct phone no.");
                            System.out.println("------------------");
                        }

                        else{
                            int finee = 0;
                            ArrayList<Book> membooks = new ArrayList<Book>();

                            Member mem1 = new Member(namee, agee, phone, memid, finee, membooks);

                            System.out.println("------------------");
                            System.out.printf("Member Successfully Registered with member id: %d!\n", memid);
                            System.out.println("------------------");

                            Memberlist.add(mem1);
                            memid++;

                        }
                        

                        
                    }


                    else if (action==2) {         //remove a member
                        System.out.print("Enter member id: ");
                        int remmid = input.nextInt();
                        input.nextLine();
                        System.out.println("------------------");

                        boolean check2 = false;
                        for (Member member : Memberlist) {
                            if (remmid == member.memberid) {
                                check2 = true;
                                break;
                            }
                        }

                        if (check2 == true) {

                            for (Member member : Memberlist) {
                                if (remmid == member.memberid) {
                                    Memberlist.remove(Memberlist.indexOf(member));
                                    System.out.println("Member removed successfully!");
                                    break;
                                }
                            }
                        }
                        else {
                            System.out.printf("Member with id: %d does not exist.\n");
                        }


                        System.out.println("------------------");
                    }




                    else if (action==3) {        //add a book
                        
                        System.out.print("1.   Book title: ");
                        String bkname = input.nextLine();
                        System.out.print("2.   Author: ");
                        String author = input.nextLine();
                        System.out.print("3.   Copies: ");
                        int copy = input.nextInt();
                        input.nextLine();
                        System.out.println("------------------");
                        boolean status=true;            //true=available, false=taken

                        for (int i=0; i<copy; i++) {
                            Book book1 = new Book(bkname, author, bookid, status);
                            bookid++;
                            System.out.println("Book added successfully");
                            System.out.println("------------------");
                            
                            bookshelf.add(book1);
                        }
                        /*for (Book book : bookshelf) {
                            System.out.println("The book is: "+book.getname());
                        } */
                        
                    }


                    else if (action==4) {             //remove a book
                        System.out.print("Enter Book Id: ");
                        int rem_id = input.nextInt();
                        input.nextLine();
                        System.out.println("------------------");

                        boolean check = false;
                        for (Book book : bookshelf) {
                            if ((rem_id == book.id)) {
                                check = true;
                                break;
                            }
                        }

                        if (check==true) {
                            for (Book book : bookshelf) {
                                if ((rem_id == book.id)) {
                                    bookshelf.remove(bookshelf.indexOf(book));
                                    System.out.print("Book removed successfully! ");
                                    break;
                                }
                            }
                            
                        }  
                        else {
                            System.out.printf("Book with Id: %d does not exist.", rem_id);

                        }
                        System.out.println("\n------------------");  
                    }


                    else if (action==5) {         //view members

                        for (Member member : Memberlist) {
                            System.out.printf("Member ID - %d\n", member.memberid);
                            System.out.printf("Name - %s\n", member.name);
                            System.out.printf("Books - [");
                            for (Book bkk : member.issuedbooks) {
                                System.out.printf("%s, ", bkk.name);
                            }
                            System.out.println("]");

                            
                            System.out.printf("Fine - %d\n", member.fine);
                            System.out.println("");
                        
                        }
                        System.out.println("------------------"); 
                    }




                    else if (action==6) {            //view all books
                        
                        for (Book book : bookshelf) {
                            System.out.printf("Book ID - %d\n", book.id);
                            System.out.printf("Name - %s\n", book.name);
                            System.out.printf("Author - %s\n", book.author);
                            System.out.println("");
                        }
                    
                    System.out.println("------------------");  
                    }

                }


                
                

                
            }

            else if(enter==2) {              //member actions
                //System.out.println("You have entered as member.");
                System.out.print("Name: ");
                String name = input.nextLine();

                System.out.print("Phone No: ");
                Long phone = input.nextLong();
                input.nextLine();

                boolean membercheck = false;
                
                for (Member member : Memberlist) {
                    if (name.equals(member.name) && phone.equals(member.phone)) {
                        
                        membercheck = true;
                        break;
                    }
                }

                if (membercheck == true) {
                    System.out.println("");
                    System.out.printf("Welcome %s. \n", name);
                    System.out.println("------------------");
                    while (true) {
                        System.out.println("1.   List Available Books");
                        System.out.println("2    List My Books");
                        System.out.println("3.   Issue Book");
                        System.out.println("4.   Return Book");
                        System.out.println("5.   Pay Fine");
                        System.out.println("6.   Back");
                        System.out.println("------------------");
                        action = input.nextInt();
                        input.nextLine();
                        System.out.println("------------------");


                        if (action<1 || action>6) {
                            System.out.println("Please enter correct option.");
                            System.out.println("------------------");
                            continue;
                        }
                        else if (action==6) {
                            break;
                        }


                        else if (action==1) {      //list available books

                            for (Book book : bookshelf) {
                                if (book.status == true) {
                                    System.out.printf("Book ID - %d\n", book.id);
                                    System.out.printf("Name - %s\n", book.name);
                                    System.out.printf("Author - %s\n", book.author);
                                    System.out.println("");
                                    
                                }
                            }
                            System.out.println("------------------");
                        }

                        else if (action==2) {        //list my books
                            System.out.println("Your books: ");

                            for (Member member : Memberlist) {
                                if (name.equals(member.name) && phone == member.phone) {

                                    for (Book mybooks : member.issuedbooks) {
                                        System.out.printf("Book ID - %d\n", mybooks.id);
                                        System.out.printf("Name - %s\n", mybooks.name);
                                        System.out.printf("Author - %s\n", mybooks.author);
                                        System.out.println("");

                                    }
                                }
                            }
                            


                            System.out.println("------------------");
                        }


                        else if (action==3) {        //issue book

                            System.out.print("Book ID: ");
                            int boookid = input.nextInt();
                            input.nextLine();
                            System.out.print("Book Name: ");
                            String bkname = input.nextLine(); 
                            System.out.println("------------------");

                            boolean checkbook = false;

                            for (Book book : bookshelf) {
                                if (bkname.equals(book.name) && (boookid == book.id) && (book.status == true)) {
                                    checkbook = true;
                                    break;
                                }

                            } 

                            boolean limit = false;

                            for (Member memm : Memberlist) {
                                if (name.equals(memm.name) && memm.phone == phone) {
                                    if (memm.issuedbooks.size() == 2) {
                                        limit = true;
                                    }
                                }
                            }


                            if (limit == true) {
                                System.out.println("You have reached the book issuing limit. please retrun previous books.");
                            }
                            else if (checkbook == false) {
                                System.out.println(bkname + " is not available.");
                            }
                            
                            else if (checkbook == true && limit == false) {
                                for (Book book : bookshelf) {
                                    if ((boookid)==book.id && (bkname).equals((book.name))) {
                                        book.status = false;
                                        for (Member member : Memberlist){
                                            if (name.equals(member.name) && phone.equals(member.phone)) {
                                                
                                                member.issuedbooks.add(book);
                                                
                                            }
                                        }
                                    }
                                    
                                }
                                System.out.println("Book Issued Successfully!");
                            }

                            System.out.println("------------------");
                        }

                        else if (action == 4) {          //return book
                            System.out.print("Enter Book ID: ");
                            int bokid = input.nextInt();
                            input.nextLine();
                            System.out.println("------------------");

                            boolean bokcheck = false;

                            

                            for (Member member : Memberlist){
                                if (name.equals(member.name) && phone.equals(member.phone)) {

                                    for (Book book : member.issuedbooks) {
                                        if (book.id == bokid) {
                                            member.issuedbooks.remove(member.issuedbooks.indexOf(book));
                                            System.out.printf("Book ID: %d successfully returned.\n", bokid);
                                            bokcheck = true;
                                            break;
                                        }
                                    }

                                }
                            }

                            if (bokcheck == false) {
                                System.out.println("Please enter correct ID");
                            }
                            for (Book book : bookshelf) {
                                if (book.id == bokid) {
                                    book.status = true;
                                }
                            }
                            System.out.println("------------------");

                        }

                        else if (action == 5) {
                            
                            int finebk = 0;
                            System.out.printf("You had a total fine of Rs. %d. It has been paid successfully!\n", finebk);
                            System.out.println("------------------");
                        }

                        



                    }
                }

                else if (membercheck == false) {
                    System.out.printf("Member with Name: %s and Phone No: %d doesn't exist.\n", name, phone);
                }




            }
            else if(enter<1 || enter>3) {
                System.out.println("please enter correct option.");
                enter = 0;
            }

            if(enter!=3) {
            System.out.println("------------------");
            }
        }


        input.close();
        System.out.println("Thanks for visiting!");
        System.out.println("------------------");
        
    }
}