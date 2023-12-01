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

    public void addBookToList(List<Author> authors){
        while (true) {
            addBook(authors);
            System.out.println("Do you want continue");
            int choice = InputData.inputInteger("Enter choice", scanner);
            if(choice != 1){
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
}
