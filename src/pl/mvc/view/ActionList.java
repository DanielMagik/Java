package pl.mvc.view;

import java.util.ArrayList;
import java.util.List;

/**
 * List of Actions. ArrayList.
 *
 * @author Daniel Tarnecki
 * @version 1.0.0, 03/10/20
 */
class ActionList 
{
     private List<Action> list;
     
    /**
     * Constructor. Makes list as ArrayList.
     */
    ActionList() 
    {
        this.list = new ArrayList<>();
    }
    
    /**
     * Adding an element (Action) to list
     * @param action element to adding
     */
    void AddElement(Action action)
    {
        this.list.add(action);
    }
    
    /**
     * Deleting all elements from list.
     */
    void ClearList()
    {
        this.list.clear();
    }
    
    /**
     * Getter that reutrns list
     * 
     * @return list
     */
    List<Action> getList() 
    {
        return this.list;
    }
}
