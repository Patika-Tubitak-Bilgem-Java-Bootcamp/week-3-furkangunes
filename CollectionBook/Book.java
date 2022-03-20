package CollectionBook;

import java.util.Date;

public class Book implements Comparable<Book> {
    private String name;
    private int pages;
    private String author;
    private Date publishDate;

    public Book(String name, int pages, String author, Date publishDate) {
        this.name = name;
        this.pages = pages;
        this.author = author;
        this.publishDate = publishDate;
    }

    @Override
    public int compareTo(Book book) {
        return name.compareTo(book.name);
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("Name: ");
        stringBuilder.append(name);

        stringBuilder.append(", Page Count: ");
        stringBuilder.append(pages);

        stringBuilder.append(", Author: ");
        stringBuilder.append(author);

        stringBuilder.append(", Published On: ");
        stringBuilder.append(publishDate);

        return stringBuilder.toString();
    }
}
