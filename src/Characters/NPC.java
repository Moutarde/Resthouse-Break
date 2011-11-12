package Characters;

import Objets.*;


/**
 * Class NPC - a non-player character in an adventure game.
 * 
 * @author Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 19/04/2009
 */
public class NPC
{
    private String name;
    private String description;
    private String talk;
    private ItemList<String, Item> bag;
    
    
    /**
     *  Create a NPC object.
     */
    public NPC(String name, String description, String talk)
    {
        this.name = name;
        this.description = description;
        this.talk = talk;
        bag = new ItemList<String, Item>();
    } //Character(.)
    
    /**
     * @return The character's name.
     */
    public String getNPCName()
    {
        return name;
    } //getCharacterName()
    
    /**
     * @return The character's description.
     */
    public String getNPCDescription()
    {
        return description;
    } //getCharacterDescription()
    
    /**
     * @return What the character says when the player talks to him.
     */
    public String getNPCTalk()
    {
        return talk;
    } //getCharacterTalk()
    
    /**
     * @return The player's bag.
     */
    public ItemList<String, Item> getBag()
    {
        return bag;
    } //getBag()
    
    /**
     * @return False by default (normal characters can't move).
     */
    public boolean canMove()
    {
        return false;
    } //canMove()
    
    
} //Character