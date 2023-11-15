package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Book{
    private @Setter @Getter int id;
    private @Setter @Getter String title;
    private @Setter @Getter float price;
    private @Setter @Getter int quantity;
    private @Setter @Getter String author;
    private static int autoId = 1;

    private Integer autoIdBook(){
        return autoId++;
    }

    public Book(String title, float price, int quantity, String author){
        this.id = autoIdBook();
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.author = author;
    }     
   
}