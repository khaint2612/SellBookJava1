package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Author;
import util.InputData;

public class ListAuthor {
    
    List<Author> authorList = new ArrayList<Author>();

    Scanner scanner = new Scanner(System.in);
    public  List<Author> getAuthorList() {
        return authorList;
    }

    private void addAuthor(){
        System.out.println("New author");
        System.out.println("----------");
        String name = InputData.inputString("Enter name author:", scanner);
        Author author = new Author(name);
        authorList.add(author);
    }

    public void authorToList(){
        while (true) {
            addAuthor();
            System.out.println("Enter 1 continue");
            int choice = InputData.inputInteger("Enter choice:", scanner);
            if (choice != 1) {
                break;
            }
        }
    }

    public void showListAuthor(){
        authorList.forEach(author ->{
            System.out.println("id: " + author.getId() + " - name: " + author.getName());
        });
    }

    private void editAuthor(){
        System.out.println("Edit author:");
        System.out.println("------------");
        String nameFound = InputData.inputString("Enter name find:", scanner);
        Author authorFound = authorList.stream().filter(a -> a.getName().equals(nameFound)).findFirst().orElse(null);
        if(authorFound == null){
            System.out.println("Name not found");
            return;
        }
        authorFound.setName(InputData.inputString("Enter name new:", scanner));
    }

    public void editAuhotList(){
        while (true) {
            editAuthor();
            System.out.println("Enter number 1 continue");
            int choice = InputData.inputInteger("Enter choice:", scanner);
            if(choice != 1) break;
        }
    }

    private void deleteAuthor(){
        System.out.println("Delete Author");
        System.out.println("---------------");
        String nameFound = InputData.inputString("Enter name find:", scanner);
        Author authorFound = authorList.stream().filter(a -> a.getName().equals(nameFound)).findFirst().orElse(null);
        if(authorFound == null){
            System.out.println("Name not found");
            return;
        }
        authorList.remove(authorFound);
    }

    public void deleteAuthorList(){
        while (true) {
            deleteAuthor();
            System.out.println("Enter number 1 continue:");
            int choice = InputData.inputInteger("Enter choice:", scanner);
            if(choice != 1 ) break;
        }
    }
}
