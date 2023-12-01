package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Author;
import model.Book;
import util.InputData;

public class ListBook {

    Scanner scanner = new Scanner(System.in);

    List<Book> books = new ArrayList<Book>();

    private void addBook(List<Author> authors) {
        System.out.println("New Book:");
        System.out.println("----------");
        String title = InputData.inputString("Enter title: ", scanner);
        Float price = InputData.inputFloat("Enter price: ", scanner);
        Integer quantity = InputData.inputInteger("Enter quantity: ", scanner);
        String authorName;
        while (true) {
            String authorNameFound = InputData.inputString("Enter author name:", scanner);
            if (authorNameFound.isEmpty()) {
                authors.add(new Author(InputData.inputString("Enter new author:", scanner)));
                continue;
            }
            if (authors.stream().anyMatch(a -> a.getName().equals(authorNameFound))) {
                authorName = authorNameFound;
                break;
            }
        }

        Book book = new Book(title, price, quantity, authorName);
        books.add(book);
    }

    public void addBookToList(List<Author> authors) {
        while (true) {
            addBook(authors);
            System.out.println("Do you want continue");
            int choice = InputData.inputInteger("Enter choice", scanner);
            if (choice != 1) {
                break;
            }
        }
    }

    public void showListBook() {
        books.forEach(b -> {
            System.out.println("id: " + b.getId() + " - title: " + b.getTitle() + " - author: " + b.getAuthor()
                    + " - price: " + b.getPrice() + " - quantity: " + b.getQuantity());
        });
    }

    private Book findBook(String title) {
        Book bookFind = books.stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(null);
        return bookFind;
    }

    private boolean checkBookNull(Book book) {
        if (book == null) {
            System.out.println("Title don't find");
        }
        return true;
    }

    private void editBookTitle(Book bookFind) {
        bookFind.setTitle(InputData.inputString("Enter new title:", scanner));
    }

    private void editBookQuantity(Book bookFind) {

        bookFind.setQuantity(InputData.inputInteger("Enter new quantity:", scanner));
    }

    private void editBookPrice(Book bookFind) {

        bookFind.setPrice(InputData.inputFloat("Enter new price:", scanner));
    }

    private void editBookAuthor(List<Author> authors, Book bookFind) {

        String authorName = InputData.inputString("Enter edit author:", scanner);
        if (!authors.stream().anyMatch(a -> a.getName().equals(authorName))) {
            authors.add(new Author(authorName));
            System.out.println("Added a new author");
        }
        bookFind.setAuthor(authorName);
    }

    public void editBook(List<Author> authors) {
        System.out.println("Edit book");
        do {
            Book bookFind = findBook(InputData.inputString("Enter title need edit", scanner));
            if (!checkBookNull(bookFind)) {
                System.out.println("1.Title book");
                System.out.println("2.Author name book:");
                System.out.println("3.Quantity book:");
                System.out.println("4.Price book:");
                System.out.println("0.Back");
                int choice = InputData.inputInteger("Enter choice", scanner);
                switch (choice) {
                    case 1:
                        editBookTitle(bookFind);
                        break;
                    case 2:
                        editBookAuthor(authors, bookFind);
                        break;
                    case 3:
                        editBookQuantity(bookFind);
                        break;
                    case 4:
                        editBookPrice(bookFind);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Function don't exist");
                        break;
                }
            }
        } while (true);
    }
}
