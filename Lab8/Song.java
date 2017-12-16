import java.util.*;

public class Song implements Comparable<Song>
{
    private String title;
    private String artist;
    private int year;
    private String genre;
    
    public Song(String title, String artist, int year, String genre){
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
    }
    
    public int compareTo(Song obj){
        //compare artists
        if (this.artist.compareToIgnoreCase(obj.artist) == 0){
            //compare titles
            if(this.title.compareToIgnoreCase(obj.title) == 0){
                //compare year
                if(this.year == obj.year){
                    //compare genre
                    return this.genre.compareToIgnoreCase(obj.genre);
                } else if (this.year > obj.year){
                    return 1;
                } else { 
                    return -1;
                }
            }
            return this.title.compareToIgnoreCase(obj.title);
        }
        return this.artist.compareToIgnoreCase(obj.artist);
    }
    
    @Override
    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Song)) {
            return false;
        }
        
        // typecast o to Complex so that we can compare data members 
        Song c = (Song) o;
         
        // Compare the data members and return accordingly 
        return this.compareTo(c) == 0;
    }

    public String toString(){
        return artist + "," + title + "," + year + "," + genre + "\n"; 
    }
    
    public String getTitle(){return title;}
    public String getArtist(){ return artist;}
}
