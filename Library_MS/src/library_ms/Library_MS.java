/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_ms;
import java.util.*;
import java.io.*;
import com.businessrefinery.barcode.Barcode;
/**
 *
 * @author Khubaib
 */
class Fine{
    String offense;
    long mem_id;
    double amount;
    Fine(long id, String off, double amount){
        Member curr_mem = null;
        mem_id = id;
        offense = off;
        this.amount = amount;
        boolean flag = false;
        for(Member a: Library_MS.mem_list){
            if(a.mem_id==id){
                curr_mem = a;
                flag = true;
                break;
            }
        }
        if(flag==false){
            System.out.println("No such member exists.");
            return;
        }
        curr_mem.dues += amount;
    }
}
class Member implements Serializable{
    String mem_username;
    String mem_pass;
    long mem_id;
    String mem_name;
    Date reg_date;
    Book book_taken = new Book("none");
    double dues;
    boolean book_issued;
    String contact_no;
    String address;
    Member(long mem_id, String mem_name, Date reg_date, double dues, boolean book_issued, String contact_no, String address, String user, String pass){
        this.mem_id = mem_id;
        this.mem_name = mem_name;
        this.reg_date = reg_date;
        this.dues = dues;
        this.book_issued = book_issued;
        this.contact_no = contact_no;
        this.address = address;
        mem_username = user;
        mem_pass = pass;
    }
    public void setName(String name){
        mem_name = name;
    }
    public void setContact(String contact){
        contact_no = contact;
    }
    public void setAddress(String add){
        address = add;
    }
    public void setPass(String pass){
        mem_pass = pass;
    }
    public String getUserName(){
        return mem_username;
    }
    public int CheckUserPass(String username, String pass){
        if(username.equals(mem_username)){
            if(pass.equals(mem_pass)){
                return 1;
            }
        }
        return 0;
    }
    public String toString(){
        return "Name: "+mem_name+"\nID: "+mem_id+"\nDues: "+dues+"$"+"\nBook issued: "+book_taken.book_name+"\nContact: "+contact_no+"\nAddress: "+address+"\nDate registered: "+reg_date.toString()+"\nUsername: "+mem_username;
    }
    public void Issue(Book bookerino){
        bookerino.SetStatus(true);
        book_taken = bookerino;
        book_issued = true;
    }
    public void Return(Book bookerino){
        bookerino.SetStatus(false);
        book_taken = new Book("none");
        book_issued = false;
    }
    public void PayFine(double payment){
        dues = dues - payment;
        System.out.println("Remaining dues: "+dues+"$");
    }
    public int CheckDues(){
        if(dues>0){
            return 0;
        }
        return 1;
    }
}
class Librarian{
    static String librarian_username = "abc123";
    static String librarian_pass = "54321";
    public static int CheckUserPass(String username, String pass){
        if(username.equals(librarian_username)){
            if(pass.equals(librarian_pass)){
                return 1;
            }
        }
        return 0;
    }
    public static void IssueFine(long mem_id, double amount, String reason){
        new Fine(mem_id, reason, amount);
    }
}
class Book implements Serializable{
    long book_bar;
    String author;
    String book_name;
    boolean is_issued;
    Date purchase_date;
    String publisher;
    Book(String book_name){
        this.book_name = book_name;   
    }
    Book(String author, String book_name, boolean is_issued, Date purchase_date, long book_bar, String publisher) throws Exception{
        this.author = author;
        this.book_name = book_name;
        this.is_issued = is_issued;
        this.purchase_date = purchase_date;
        this.book_bar = book_bar;
        this.publisher = publisher;
        Barcode barc = new Barcode();
        barc.setCode(Long.toString(book_bar));
        barc.drawImage2File(book_name+".jpeg");
    }
    public void SetStatus(boolean hue){
        is_issued = hue;
    }
    public String toString(){
        return "Book name: "+book_name+"\nAuthor name: "+author+"\nPublisher: "+publisher+"\nIssue status: "+is_issued+"\nDate purchased: "+purchase_date.toString()+"\nBarcode: "+book_bar;
    }
}
class Catalogue{
    public static boolean CheckAvailability(String book_name){
        for(Book a: Library_MS.book_list){
            if(a.book_name.equalsIgnoreCase(book_name)){
                if(a.is_issued==true){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        System.out.println("That book does not exist.");
        return false;
    }
    public static void GetList(){
        for(Book a: Library_MS.book_list){
            System.out.println(a.toString());
            System.out.println("----------");
        }
    }
}
class TextBook extends Book{
    String subject;
    TextBook(String author, String book_name, boolean is_issued, Date purchase_date, String subject, long book_bar, String publisher) throws Exception{
        super(author, book_name, is_issued, purchase_date, book_bar, publisher);
        this.subject = subject;
    }
    public String toString(){
        return super.toString()+"\nSubject: "+subject;
    }
}
class Magazine extends Book{
    String date_pub;
    Magazine(String author, String book_name, boolean is_issued, Date purchase_date, String date_pub, long book_bar, String publisher) throws Exception{
        super(author, book_name, is_issued, purchase_date, book_bar, publisher);
        this.date_pub = date_pub;
    }
    public String toString(){
        return super.toString()+"\nDate Published: "+date_pub;
    }
}
class StoryBook extends Book{
    String genre;
    StoryBook(String author, String book_name, boolean is_issued, Date purchase_date, String genre, long book_bar, String publisher) throws Exception{
        super(author, book_name, is_issued, purchase_date, book_bar, publisher);
        this.genre = genre;
    }
    public String toString(){
        return super.toString()+"\nGenre: "+genre;
    }
}
//more types if possible, doesnt matter really
public class Library_MS {
    
    /**
     * @param args the command line arguments
     */
    static long mem_id_curr;
    static long book_bar_curr;
    static double registration_fees = 2.35;
    static ArrayList<Member> mem_list;
    static ArrayList<Book> book_list;
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, Exception {
        Scanner input = new Scanner(System.in);
        //FirstRun();
        File mem = new File("members.dat");
        File book = new File("book.dat");
        File mem_id = new File("mem_id.txt");
        File book_bar = new File("book_bar.txt");
        ObjectInputStream ois_mem = new ObjectInputStream(new FileInputStream(mem));
        ObjectInputStream ois_book = new ObjectInputStream(new FileInputStream(book));
        Scanner s_mem_id = new Scanner(mem_id);
        Scanner s_book_bar = new Scanner(book_bar);
        try {
            book_list = (ArrayList<Book>) ois_book.readObject();
            mem_list = (ArrayList<Member>) ois_mem.readObject();
            mem_id_curr = Long.parseLong(s_mem_id.next());
            book_bar_curr = Long.parseLong(s_book_bar.next());
        } 
        catch (IOException | ClassNotFoundException Ex) {
            System.out.println(Ex);
        }
        ois_mem.close();
        ois_book.close();
        s_mem_id.close();
        s_book_bar.close();
        MainMenu();
    }
    public static void MainMenu() throws IOException, Exception{
        Scanner input = new Scanner(System.in);
        UpdateFiles();
        while(true){
            System.out.println("~Main Menu~");
            System.out.println("Enter 1 for librarian login and 2 for member login and 3 for new member registration. 0 to exit.");
            int choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1:
                    System.out.println("~Librarian login screen~");
                    while(true){    
                        System.out.print("Enter librarian username: ");
                        String lib_u = input.nextLine();
                        System.out.print("Enter librarian password: ");
                        String lib_p = input.nextLine();
                        if(Librarian.CheckUserPass(lib_u, lib_p)==1){
                            System.out.println("Login successful.");
                            break;
                        }
                        else{
                            System.out.println("Invalid login.");
                            continue;
                        }
                    }
                    LibrarianMenu();
                    break;
                case 2:
                    Member curr_mem = null;
                    System.out.println("~Member login screen~");
                    while(true){
                        System.out.print("Enter your username: ");
                        String mem_u = input.nextLine();
                        System.out.print("Enter your password: ");
                        String mem_p = input.nextLine();
                        boolean auth_flag = false;
                        for(Member a: mem_list){
                            if(a.CheckUserPass(mem_u, mem_p)==1){
                                curr_mem = a;
                                auth_flag = true;
                                break;
                            }
                        }
                        if(auth_flag==false){
                            System.out.println("Invalid username or password. Try again.");
                            continue;
                        }
                        else{
                            System.out.println("Welcome "+curr_mem.mem_name+"!");
                            break;
                        }
                    }
                    MemberMenu(curr_mem);
                    break;
                case 3:
                    while(true){
                    //input.nextLine();    
                    System.out.println("~Member registration screen~");
                    System.out.println("Enter your name: ");
                    String name = input.nextLine();
                    Date date = new Date();
                    System.out.println("Enter your contact number: ");
                    String contact = input.nextLine();
                    System.out.println("Enter your physical address: ");
                    String address = input.nextLine();
                    String user;
                    while(true){
                        System.out.println("Enter username: ");
                        user = input.nextLine();
                        boolean auth_flag = true;
                        for(Member a: mem_list){
                            if(user.equals(a.getUserName())){
                                System.out.println("That username is already taken.");
                                auth_flag = false;
                                continue;
                            }
                        }
                        if(auth_flag == true){
                            break;
                        }
                    }
                    System.out.println("Enter password: ");
                    String pass = input.nextLine();
                    boolean flag = false;
                    System.out.println("Is the following information ok?");
                    System.out.println(new Member(mem_id_curr,name,date,registration_fees,false,contact,address,user,pass).toString());
                    System.out.println("1 to confirm. 2 to enter again.");
                    int ch = input.nextInt();
                    if(ch==1){
                        flag = true;
                    }
                    if(flag==true){
                    mem_list.add(new Member(mem_id_curr++,name,date,registration_fees,false,contact,address,user,pass));
                    System.out.println("Account added.");
                    UpdateFiles();
                    break;
                    }
                    }
                    break;
                case 0:
                    UpdateFiles();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Give a valid input.");
            }
        }
    }
    public static void LibrarianMenu() throws IOException, Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("~Librarian Menu~");
        while(true){
            System.out.println("1 to add a new Book. 2 to issue a fine. 3 to get all book details. 4 to get all member details. 0 to logout.");
            int choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1:
                    BookAddMenu();
                    break;
                case 2:
                    System.out.println("~Fine Issuing Screen~");
                    System.out.println("Give member id: ");
                    long id = input.nextLong();
                    System.out.println("Amount?");
                    double amount = input.nextDouble();
                    input.nextLine();
                    System.out.println("Reason?");
                    String reason = input.nextLine();
                    Librarian.IssueFine(id, amount, reason);
                    break;
                case 3:
                    Catalogue.GetList();
                    break;
                case 4:
                    for(Member a: mem_list){
                        System.out.println(a.toString());
                        System.out.println("----------");
                    }
                    break;
                case 0:
                    MainMenu();
                    break;
                default:
                    System.out.println("Give a valid input.");
            }
        }
    }
    public static void BookAddMenu() throws IOException, Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("~Book Adding Menu~");
        while(true){
            System.out.println("1 for Story Book. 2 for Magazine. 3 for Textbook. 0 to go back.");
            int choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1:
                    while(true){
                        System.out.println("~Story Book~");
                        System.out.println("Input name of book: ");
                        String name = input.nextLine();
                        System.out.println("Insert name of author: ");
                        String author = input.nextLine();
                        System.out.println("Insert name of publisher: ");
                        String pub = input.nextLine();
                        System.out.println("Insert genre: ");
                        String genre = input.nextLine();
                        boolean flag = false;
                        System.out.println("Is the following information ok?");
                        System.out.println(new StoryBook(author,name,false,new Date(),genre,book_bar_curr,pub).toString());
                        System.out.println("1 to confirm. 2 to enter again.");
                        int ch = input.nextInt();
                        if(ch==1){
                            flag = true;
                        }
                        if(flag==true){
                            book_list.add(new StoryBook(author,name,false,new Date(),genre,book_bar_curr++,pub));
                            System.out.println("Book added.");
                            UpdateFiles();
                            break;
                        }
                    }
                    break;
                case 2:
                    while(true){
                        System.out.println("~Magazine~");
                        System.out.println("Input name of book: ");
                        String name1 = input.nextLine();
                        System.out.println("Insert name of author: ");
                        String author1 = input.nextLine();
                        System.out.println("Insert name of publisher: ");
                        String pub1 = input.nextLine();
                        System.out.println("Insert date published: ");
                        String pub_date = input.nextLine();
                        boolean flag = false;
                        System.out.println("Is the following information ok?");
                        System.out.println(new Magazine(author1,name1,false,new Date(),pub_date,book_bar_curr,pub1).toString());
                        System.out.println("1 to confirm. 2 to enter again.");
                        int ch = input.nextInt();
                        if(ch==1){
                            flag = true;
                        }
                        if(flag==true){
                            book_list.add(new Magazine(author1,name1,false,new Date(),pub_date,book_bar_curr++,pub1));
                            System.out.println("Book added.");
                            UpdateFiles();
                            break;
                        }
                    }
                    break;
                case 3:
                    while(true){
                        System.out.println("~Textbook~");
                        System.out.println("Input name of book: ");
                        String name2 = input.nextLine();
                        System.out.println("Insert name of author: ");
                        String author2 = input.nextLine();
                        System.out.println("Insert name of publisher: ");
                        String pub2 = input.nextLine();
                        System.out.println("Insert subject: ");
                        String subject = input.nextLine();
                        boolean flag = false;
                        System.out.println("Is the following information ok?");
                        System.out.println(new TextBook(author2,name2,false,new Date(),subject,book_bar_curr,pub2).toString());
                        System.out.println("1 to confirm. 2 to enter again.");
                        int ch = input.nextInt();
                        if(ch==1){
                            flag = true;
                        }
                        if(flag==true){
                            book_list.add(new TextBook(author2,name2,false,new Date(),subject,book_bar_curr++,pub2));
                            System.out.println("Book added.");
                            UpdateFiles();
                            break;
                        }
                    }
                    break;
                case 0:
                    LibrarianMenu();
                    break;
                default:
                    System.out.println("Give a valid input.");
            }
        }
    }
    public static void MemberMenu(Member curr_mem) throws IOException, Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("~Member Menu~");
        while(true){
            System.out.println("1 to issue a book. 2 to return a book. 3 to view info. 4 to pay fine. 5 to view book list. 6 to edit info. 0 to logout.");
            int choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1:
                    System.out.println("~Book Issue~");
                    if(curr_mem.CheckDues()==0){
                        System.out.println("Cannot issue a book you have dues to be cleared.");
                        MemberMenu(curr_mem);
                    }
                    System.out.println("Enter name of book you want: ");
                    String name = input.nextLine();
                    for(Book a: book_list){
                        if(name.equalsIgnoreCase(a.book_name)){
                            if(Catalogue.CheckAvailability(name)){
                                curr_mem.Issue(a);
                            }
                            else{
                                System.out.println("Book is not available.");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("~Return Book~");
                    while(true){
                        System.out.println("Scan the barcode: ");
                        long bar = input.nextLong();
                        boolean flag = false;
                        for(Book a: book_list){
                            if(a.book_bar==bar){
                                flag = true;
                                curr_mem.Return(a);
                            }
                        }
                        if(flag==false){
                            System.out.println("There seems to be an error. Try again.");
                        }
                        else{
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("~Your Info~");
                    curr_mem.toString();
                    break;
                case 4:
                    System.out.println("~Fine Payment~");
                    System.out.println("Enter amount: ");
                    double payment = input.nextDouble();
                    curr_mem.PayFine(payment);
                    break;
                case 5:
                    Catalogue.GetList();
                    break;
                case 6:
                    EditMenu(curr_mem);
                    break;
                case 0:
                    MainMenu();
                    break;
                default:
                    System.out.println("Give a valid input.");
            }
        }
    }
    public static void EditMenu(Member curr_mem) throws IOException, Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("~Editing Menu~");
        while(true){
            System.out.println("Current info: ");
            System.out.println(curr_mem.toString());
            System.out.println("1 to change name. 2 to change contact info. 3 to change address. 4 to change password. 5 to delete account. 0 to go back.");
            int choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Input new name: ");
                    String name = input.nextLine();
                    curr_mem.setName(name);
                    break;
                case 2:
                    System.out.println("Input new contact info: ");
                    String contact = input.nextLine();
                    curr_mem.setContact(contact);
                    break;
                case 3:
                    System.out.println("Input new address: ");
                    String address = input.nextLine();
                    curr_mem.setAddress(address);
                    break;
                case 4:
                    PassMenu(curr_mem);
                    break;
                case 5:
                    mem_list.remove(curr_mem);
                    MainMenu();
                    break;
                case 0:
                    MemberMenu(curr_mem);
                    break;
                default:
                    System.out.println("Give a valid input.");
            }
        }
    }
    public static void PassMenu(Member curr_mem){
        Scanner input = new Scanner(System.in);
        System.out.println("Input old password: ");
        String oldpass = input.nextLine();
        if(oldpass.equals(curr_mem.mem_pass)){
            System.out.println("Input new pass: ");
            String newpass = input.nextLine();
            curr_mem.setPass(newpass);
        }
        else{
            System.out.println("Incorrect password.");
        }
    }
    public static void UpdateFiles() throws FileNotFoundException, IOException{
        File mem = new File("members.dat");
        File book = new File("book.dat");
        File mem_id = new File("mem_id.txt");
        File book_bar = new File("book_bar.txt");
        ObjectOutputStream oos_mem = new ObjectOutputStream(new FileOutputStream(mem));
        ObjectOutputStream oos_book = new ObjectOutputStream(new FileOutputStream(book));
        PrintWriter pw_mem_id = new PrintWriter(mem_id);
        PrintWriter pw_book_bar = new PrintWriter(book_bar);
        try{
            oos_mem.writeObject(mem_list);
            oos_book.writeObject(book_list);
            pw_mem_id.print(mem_id_curr);
            pw_book_bar.print(book_bar_curr);
        }
        catch (IOException Ex) {
            System.out.println(Ex);
        }
        oos_mem.close();
        oos_book.close();
        pw_mem_id.close();
        pw_book_bar.close();
    }
    public static void FirstRun() throws FileNotFoundException, IOException, Exception{
        File mem = new File("members.dat");
        File book = new File("book.dat");
        File mem_id = new File("mem_id.txt");
        File book_bar = new File("book_bar.txt");
        ObjectOutputStream oos_mem = new ObjectOutputStream(new FileOutputStream(mem));
        ObjectOutputStream oos_book = new ObjectOutputStream(new FileOutputStream(book));
        PrintWriter pw_mem_id = new PrintWriter(mem_id);
        PrintWriter pw_book_bar = new PrintWriter(book_bar);
        ArrayList<Member> first_mem_list = new ArrayList<Member>();
        ArrayList<Book> first_book_list = new ArrayList<Book>();
        first_mem_list.add(new Member(100,"EggsBenedict",new Date(),0,false,"03312415510","huehue street","user1","123"));
        first_book_list.add(new Book("BenedictCumberbatch","FPS 101",false,new Date(),10000000,"ranpub"));
        try{
            oos_mem.writeObject(first_mem_list);
            oos_book.writeObject(first_book_list);
            pw_mem_id.print(101);
            pw_book_bar.print(10000001);
        }
        catch (IOException Ex) {
            System.out.println(Ex);
        }
        oos_mem.close();
        oos_book.close();
        pw_mem_id.close();
        pw_book_bar.close();
    }
}
