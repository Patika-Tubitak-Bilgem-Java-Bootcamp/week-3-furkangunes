package CollectionBook;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static void printSet(Set<Book> set) {
        for (Book book : set) {
            System.out.println(book);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Date today = Calendar.getInstance().getTime();

        Book book1 = new Book("Random Book", 120, "Random Author", today);
        Book book2 = new Book("Book of decade", 23, "Famous Author", new Date(today.getTime() + 30000));
        Book book3 = new Book("Great Book", 413, "Best Author", new Date(today.getTime() + 20000));
        Book book4 = new Book("Short Book", 15, "Lazy Author", new Date(today.getTime() + 40000));
        Book book5 = new Book("Just a Book", 40, "Any Author", new Date(today.getTime() + 10000));

        Set<Book> set = new HashSet<>();
        set.add(book1);
        set.add(book2);
        set.add(book3);
        set.add(book4);
        set.add(book5);

        System.out.println("Initial");
        printSet(set);

        System.out.println("Sorted by name (default)");
        set.stream().sorted().forEach(System.out::println);

        
        System.out.println();
        System.out.println("Sorted by number of pages");
        set.stream().sorted((b1, b2) -> b1.getPages() - b2.getPages()).forEach(System.out::println);;
    }
}
