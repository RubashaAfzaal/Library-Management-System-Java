import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

Library myLibrary= new Library();
 
myLibrary.displayTimings();
Admin admin=new Admin("101","AdminUser","sfgh13502345");
System.out.print("Logged In as Admin: "+ admin.getUsername()+ "\n");

//adding Books
Book b1= new Book("Java Programming", "Ali", "CS", "Shelf A1", 5);
Book b2=new Book("Data Structures", "Sara", "CS", "Shelf B2", 3);
Book b3= new Book("BIOLOGY NOTES" , "DR.Ahmad" , "Zoology","Sheld Z1", 2);

myLibrary.addBook(b1);
myLibrary.addBook(b2);
myLibrary.addBook(b3);


Staff s1=new Staff(01,"Ayesha","lahore",03000441556,2500,"Librarian");
Staff s2=new Staff(02,"Ahmad","lahore",03000567556,2400,"Assistent");
  myLibrary.addStaff(s1);
 myLibrary.addStaff(s2);


 int mainChoice= 0;
do{
    System.out.println("=== LIBRARY MANAGEMNET SYSTEM=== \n");
System.out.println("1. Admin Login");
System.out.println("2. Librarian / Staff Portal");
    System.out.println("3. Student / Customer Portal");
    System.out.println("4. Exit");
    System.out.println("Select User Type from 1-4: ");
    if(!sc.hasNextInt()){
        sc.next();
        continue;
    }
    mainChoice=sc.nextInt();
    sc.nextLine();
    switch(mainChoice){
        case 1: //for admin
            System.out.println("\n   ADMIN PORTAL   ");
            System.out.println("Enter Admin Username: ");
            String user= sc.nextLine();
            String pass=sc.nextLine();
            if (Admin.verifyLogin(user,pass)){
                System.out.println("\n Logged in as Admin: "+user);
                adminMenu(sc, myLibrary);
            }
    
    else{
        System.out.println("Invalid Admin Credentials.");
    }
    break;
    case 2: //for diff roles librarian /staff
System.out.println("\n   LIBRARIAN / STAFF PORTAL   ");
staffMenu(sc, myLibrary);
break;
case 3: //for student or customer
    System.out.println("\n   STUDENT / CUSTOMER PORTAL   ");
    studentMenu(sc,myLibrary);
    break;
    case 4: //exit
    System.out.println("Exiting System. Goodbye!" );
    break;
    default:
        System.out.println("Invalid Selection...Try Again...");
    } 
}
while(mainChoice !=4 );
sc.close();
    }

    //admin portal

    public static void adminMenu(Scanner sc, Library library){
        int choice =0;
        do{

            System.out.println("\n   ADMIN MENU   ");
            System.out.println("1. Add Staff Member ");
            System.out.println("2. Display All Staff ");
            System.out.println("3. Display All Books");
            System.out.println("4. View All Issued History");
            System.out.println("5. Logout to Main Menu");
            System.out.println("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter Staff ID (number): ");
                   int sId = sc.nextInt();
                    System.out.println("Enter Staff Name: ");
                    String sName= sc.nextLine();
                    System.out.println("Enter Address: ");
                    String sAddr=sc.nextLine();
                    System.out.println("Enter Phone Number: ");
                    int sPhone=sc.nextInt();
                    System.out.println("Enter Salary: ");
                    double sSal=sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter Role: ");
                    String sRole=sc.nextLine();
                    Staff s= new Staff(sId,sName,sAddr,sPhone,sSal,sRole);
                    library.addStaff(s);
                    System.out.println("Staff Member Added Successfully.");
                    break;

                    case 2:
                        library.displayAllStaff();
                    
                        break;
                        case 3:
                        library.displayAllBooks();
                        case 4:
                            library.displayIssuedHistory();
                            break;
                            case 5:
                                System.out.println("Logged Out Successfully.");
                                break;
                                default:
                                    System.out.println("Invalid Option.");
                                    }
            }
            while(choice !=5);
        }

    
    
//staffmenu
public static void staffMenu(Scanner sc, Library library){
int choice =0;
do{
 System.out.println("\n   LIBRARIAN / STAFF MENU   ");
            System.out.println("1. Add New Book ");
            System.out.println("2. Display Issued Books History ");
            System.out.println("3. Display All Books");
            System.out.println("4. Logout to Main Menu");
            System.out.println("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                     System.out.println("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter Author: ");
                    String author= sc.nextLine();
                    System.out.println("Enter Category: ");
                    String cat=sc.nextLine();
                    System.out.println("Enter Shelf Location: ");
                    String shelf=sc.nextLine();
                    System.out.println("Enter Copies Count: ");
                    int copies=sc.nextInt();
                    sc.nextLine();
                   Book b = new Book(title,author,cat,shelf,copies);
                   library.addBook(b);
                    System.out.println("Book Added Successfully.");
                    break;
                    case 2:
                        library.displayIssuedHistory();
                        break;
                        case 3:
                            library.displayAllBooks();
                            case4:
                    System.out.println("Logging Out from Staff...");
                    break;
                    default:
                        System.out.print("Invalid Option.");
            }
}
while (choice!=4);
}
//studentmenu

public static void studentMenu(Scanner sc, Library library){
  System.out.println("Enter your Student Name: ");
  String sName=sc.nextLine();
  System.out.println("Enter your Student ID: ");
  String sId = sc.nextLine();
  Member mem=new Member(sName,sId);
      int choice =0;
    do{
        System.out.println("\n   STUDENT / CUSTOMER MENU   ");
            System.out.println("1. View All Books ");
            System.out.println("2. Search Book by Category ");
            System.out.println("3. View My Details");
            System.out.println("4. Pay Fine");
            System.out.println("5. Logout to Main Menu");
            System.out.println("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    library.displayAllBooks();
                    break;
                    case 2:
                        System.out.println("Enter Category to Search: ");
                    String searchCat=sc.nextLine();
              library.searchByCategory(searchCat);
            break;
            case 3:
                mem.displayMember();
                break;
                case 4:
                    mem.payFine();
                    break;
                    case 5:
                        System.out.println("Logging out from Student Portal ");
                   break;
                   default:
                    System.out.println(" Invalid Option.");
            }
    }
    while (choice !=5);

}
}

    

