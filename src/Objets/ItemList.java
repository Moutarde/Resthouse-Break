package Objets;

import java.util.HashMap;

/**
 * 
 * 
 * @author Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (mai 2009)
 */
public class ItemList extends HashMap<String, Item>
{	
    private static final long serialVersionUID = 1059933136985453840L;

	/**
     * Constructor for objects of class ItemList
     */
    public ItemList()
    {
        
    } //ItemList()

    /**
     * Add an item to the player's bag.
     * @param name The name of the item.
     * @param i The item itself.
     */
    public void addItem(String name, Item j)
    {
        put(name, j);
    } //addItem(.)
    
    /**
     * Remove an item from the player's bag.
     * @param name The name of the item.
     */
    public void removeItem(String name)
    {
        remove(name);
    } //removeItem(.)
} //ItemList
