package app.administrator;

import controller.ListBook;

public class FunctionBook {

    static ListBook listBook = new ListBook();

    public void MenuBook() {
        System.out.println("Menu book");
        System.out.println("----------");
        System.out.println("1.New book");
        System.out.println("2.Show list book");
        System.out.println("3.Edit book");
        System.out.println("4.Remove book");
    }

}
