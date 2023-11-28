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
                ListAuthor listAuthor = new ListAuthor();
                listAuthor.authorToList();
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

    public void addBookToList(){
        
    }

    public void showListBook() {
        books.forEach(b -> {
            System.out.println("id: " + b.getId() + " - title: " + b.getTitle() + " - author: " + b.getAuthor()
                    + " - price: " + b.getPrice() + " - quantity: " + b.getQuantity());
        });
    }
}
