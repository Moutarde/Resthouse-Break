package Characters;

import java.util.HashMap;

/**
 * 
 * 
 * @author Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (mai 2009)
 */
public class CharacterList extends HashMap<String, NPC>
{
    private static final long serialVersionUID = 7910236785870346322L;

	/**
     * Constructor for objects of class CharacterList
     */
    public CharacterList()
    {
        
    } //ItemList()

    /**
     * Add a character to the list.
     * @param name The name of the character.
     * @param i The character itself.
     */
    public void addCharacter(String name, NPC character)
    {
        put(name, character);
    } //addCharacter(.)
    
    /**
     * Remove a character from the list.
     * @param name The name of the character.
     */
    public void removeCharacter(String name)
    {
        remove(name);
    } //removeCharacter(.)
} //CharacterList
