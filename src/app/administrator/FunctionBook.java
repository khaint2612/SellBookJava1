package app.administrator;

import java.util.List;
import java.util.Scanner;

import controller.ListAuthor;
import controller.ListBook;
import model.Author;
import util.InputData;

public class FunctionBook {

    ListBook listBook = new ListBook();
    Scanner scanner = new Scanner(System.in);
    ListAuthor listAuthor = new ListAuthor();
    public void MenuBook() {
        do {
            System.out.println("Menu book");
            System.out.println("----------");
            System.out.println("1.New book");
            System.out.println("2.Show list book");
            System.out.println("3.Edit book");
            System.out.println("4.Remove book");
            int choice = InputData.inputInteger("Enter choice", scanner);
            switch (choice) {
                case 1:
                    listBook.addBookToList(null);
                    break;
                case 2:
                    listBook.showListBook();
                    break;
                case 3:
                    listBook.editBook(null);
                    break;
                case 4:
                    listBook.removeBook();
                    break;
                case 0:

                    break;
                default:
                    System.out.println("Enter again choice:");
                    break;
            }
        } while (true);
    }

    //if list author is empty, new author.
    private void listAuthorNullIsNew(List<Author> list){
        if(list.isEmpty()){
            listAuthor.authorToList();
        }
    }
}
