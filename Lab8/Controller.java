
public class Controller
{
    public static void main(String args[]){
        PlayList p = new PlayList(); 
        p.addSong("data.txt");
        p.writePlayList("output.txt");
    }
}
