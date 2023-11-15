package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class Author {
    private @Setter @Getter int id;
    private @Setter @Getter String name; 
    private static int autoId = 1;

    private Integer autoIdAuthor(){
        return autoId++;
    }

    public Author (String name){
        this.id = autoIdAuthor();
        this.name = name;
    }
}
