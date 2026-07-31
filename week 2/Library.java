import java.util.Scanner;
class Book{
    float price;
    String title, author;
    void book_details(float price,String title,String author){
        this.price = price;
        this.title = title;
        this.author = author;
        System.out.println("TITLE : "+title);
        System.out.println("PRICE : "+price);
        System.out.println("AUTHOR : "+author);
    }
}
public class Library{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book b = new Book();
        String title;
        float price;
        String author;
        System.out.println("TITLE: ");
        title = scanner.nextLine();
        System.out.println("PRICE: ");
        price = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("AUTHOR: ");
        author = scanner.nextLine();
        b.book_details(price,title,author);
        scanner.close();
    }
}