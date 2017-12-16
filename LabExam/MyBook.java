import java.util.*;

public class MyBook
{
    private String author;
    private String title; 
    
    public MyBook(String author, String title){
        this.author = author; 
        this.title = title;
    }
    
    /** get methods */
    public String getTitle(){return title;}
    public String getAuthor(){return this.author;}
    
    /** get last name of the author */
    public String getLastName(){    
        String[] tokens = author.split(" ");                //split author names into tokens
        return tokens[tokens.length-1];                     //return the last token - i.e last name;
    }
    
    /** print author and title */
    public void print(){
        System.out.println("Author: " + author + "\n Title: " + title + "\n");
    }
}
