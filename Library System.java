import java.util.ArrayList;
import java.util.Scanner;

// Abstract Class
abstract class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Encapsulation
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    // Polymorphism
    public abstract void getBookDetails();
}

// Inheritance
class FictionBook extends Book {
    public FictionBook(String title, String author) {
        super(title, author);
    }

    @Override
    public void getBookDetails() {
        System.out.println("📖 Fiction: " + getTitle() + " by " + getAuthor());
    }
}

class ScienceBook extends Book {
    public ScienceBook(String title, String author) {
        super(title, author);
    }

    @Override
    public void getBookDetails() {
        System.out.println("🔬 Science: " + getTitle() + " by " + getAuthor());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> library = new ArrayList<>();

        System.out.println("📚 Welcome to OOP Library System 📚");

        while (true) {
            System.out.println("\n1. Add Fiction Book");
            System.out.println("2. Add Science Book");
            System.out.println("3. Show All Books");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String fTitle = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String fAuthor = sc.nextLine();
                    library.add(new FictionBook(fTitle, fAuthor));
                    break;

                case 2:
                    System.out.print("Enter Title: ");
                    String sTitle = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String sAuthor = sc.nextLine();
                    library.add(new ScienceBook(sTitle, sAuthor));
                    break;

                case 3:
                    System.out.println("\n📚 Library Books:");
                    for (Book b : library) {
                        b.getBookDetails(); // Polymorphism
                    }
                    break;

                case 4:
                    System.out.println("👋 Exiting Library System...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}






