package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Book;
import util.InputData;

public class ListBook {
    
    Scanner scanner = new Scanner(System.in);
    
    List<Book> books = new ArrayList<Book>();
    
    private ListAuthor listAuthor;
    private void addToBook(){
        System.out.println("New Book:");
        System.out.println("----------");
        String title = InputData.inputString("Enter title: ", scanner);
        Float price = InputData.inputFloat("Enter price: ", scanner);
        Integer quantity = InputData.inputInteger("Enter quantity: ", scanner);
        
    }
}
