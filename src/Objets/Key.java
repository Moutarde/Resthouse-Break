package Objets;

import Games.*;

/**
 * Write a description of class Key here.
 * 
 * @author  Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (mai 2009)
 */
public class Key extends Item
{
    private Door door;

    /**
     * Constructor for objects of class Keys.
     */
    public Key(String n, String i, int c, int w, int nb, Door door)
    {
        super(n, i, c, w, nb);
        this.door = door;
    } //Key(.)
    
    /**
     * @return The door opened by the key.
     */
    public Door getDoor()
    {
        return door;
    } //getRooms()
    
    /**
     * This item is a key.
     * @return True.
     */
    @Override public boolean isAKey()
    {
        return true;
    } //isAKey()
} //Key