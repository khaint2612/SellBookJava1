package app.administrator;

import java.util.Scanner;

import controller.ListAuthor;
import util.InputData;

public class FunctionAuthor {

    ListAuthor authorList = new ListAuthor();

    public void MenuAuthor() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu Author:");
            System.out.println("------------");
            System.out.println("1.New Author");
            System.out.println("2.List Author");
            System.out.println("3.Edit Author");
            System.out.println("4.Remove Author");
            System.out.println("-------------");
            choice = InputData.inputInteger("Enter choice:", scanner);
            switch (choice) {
                case 1:
                    authorList.authorToList();
                    break;
                case 2:
                    authorList.showListAuthor();
                    break;
                case 3:
                    authorList.editAuhotList();
                    break;
                case 4:
                    authorList.deleteAuthorList();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Enter choice again");
                    break;
            }
        } while (choice != 0);
    }
}
