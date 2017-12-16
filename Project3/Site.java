
/**
 * Write a description of class Site here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Site<K extends Comparable<K>> extends Node<K>
{
    private String type;
    private int suggestTime;
    
    public Site(K k,int suggestTime){
        super(k);
        this.suggestTime = suggestTime;
    }
    
    public int getSuggestTime(){return this.suggestTime;}
    public void setSuggestTime(int t){this.suggestTime = t;}
}
