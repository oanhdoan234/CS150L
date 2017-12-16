import java.io.FileReader;
import java.util.Scanner; 
import java.util.*;

public class PlayList
{
    private BinarySearchTree<Song> tree; 
    
    public PlayList(){
        this.tree = new BinarySearchTree<Song>(new Song("test", "test", 2017, "test"));              //tree has a randomly created root, which 
                                                                                                     //will be removed after more songs are added
    }
    
    /** read input file to add songs */
    public void addSong(String filename){
        try{
            //read a file 
            Scanner scanner = new Scanner(new FileReader(filename));
            while (scanner.hasNextLine()){
                //read line by line
                String[] aLine = scanner.nextLine().split(", ");
                //create a song 
                Song s = new Song(aLine[1], aLine[0], Integer.parseInt(aLine[2]), aLine[3]);
                //add song to tree
                tree.insert(s);
            }
            //remove root
            Song root = tree.getRoot().getValue();
            tree.remove(root);
        } catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    /** write songs to a file in sorted order */
    public void writePlayList(String outf){
        this.tree.write(outf);
    }
    
    /** Along with the toArrayOfArtistR() method, return an array of songs' artists in the same order as the songs */
    public String[] toArrayOfArtist(){
        //convert ArrayList to Array
        ArrayList<String> arr = toArrayOfArtistR(tree.root); 
        String[] songs = new String[arr.size()];
        for (int i = 0; i < songs.length; i++){
            songs[i] =  arr.get(i);
        }
        return songs;
    }
    
    /** Along with the toArrayOfTitleR() method, return an array of songs' titles in the same order as the songs */
    public String[] toArrayOfTitle(){
        //convert ArrayList to Array
        ArrayList<String> arr = toArrayOfTitleR(tree.root); 
        String[] songs = new String[arr.size()];
        for (int i = 0; i < songs.length; i++){
            songs[i] =  arr.get(i);
        }
        return songs;
    }
    
    public ArrayList<String> toArrayOfArtistR(BinaryNode<Song> node){
        if (node == null) return null;
        ArrayList<String> arr = new ArrayList<String>();
        
        //add artists from the left subtree
        ArrayList<String> leftArr = toArrayOfArtistR(node.getLeftChild());
        if (leftArr != null){
            for (int i = 0; i < leftArr.size(); i++){
                arr.add(leftArr.get(i));
            }
        }
        
        //add artists of the current node
        arr.add(node.getValue().getArtist());
        
        //add artists from the right subtree
        ArrayList<String> rightArr = toArrayOfArtistR(node.getRightChild());
        if (rightArr != null){
            for (int i = 0; i < rightArr.size(); i++){
                arr.add(rightArr.get(i));
            }
        }
        return arr;
    }
    
    public ArrayList<String> toArrayOfTitleR(BinaryNode<Song> node){
        if (node == null) return null;
        ArrayList<String> arr = new ArrayList<String>();
        
        //add titles from the left subtree
        ArrayList<String> leftArr = toArrayOfTitleR(node.getLeftChild());
        if (leftArr != null){
            for (int i = 0; i < leftArr.size(); i++){
                arr.add(leftArr.get(i));
            }
        }
        
        //add title of the current node
        arr.add(node.getValue().getTitle());
        
        //add titles of the right subtree
        ArrayList<String> rightArr = toArrayOfTitleR(node.getRightChild());
        if (rightArr != null){
            for (int i = 0; i < rightArr.size(); i++){
                arr.add(rightArr.get(i));
            }
        }
        return arr;
    }
}
