import java.util.*;

public interface EventByProperty<E>
{
    public void add(Event e);
    public void remove(String name);
    public ArrayList<Event> find(E parameter);
}
