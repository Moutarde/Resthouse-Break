package Objets;

import Games.GameModel;
import Games.Room;

/**
 * Write a description of class  here.
 * 
 * @author  Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (mai 2009)
 */
public class Beamer extends Item
{   
    private Room chargedRoom;
    private boolean charged;

    /**
     * Constructor for objects of class Beamer
     */
    public Beamer(String n,String i,int c,int w,int nb)
    {
        super(n,i,c,w,nb);
        charged = false;
        chargedRoom = null;
    } //Beamer(.)
    
    /**
     * Use the item Beamer
     */
    @Override public void iAction(GameModel gameModel)
    {
        if (charged == true)
            {
            gameModel.goRoom(chargedRoom);
            charged = false;
            }
            
        else{
            chargedRoom = gameModel.getPlayer().getCurrentRoom();
            charged = true;
            }
    } //iAction()
    
    /**
     * This item cant be use.
     * @return False.
     */
    @Override public boolean canBeUse()
    {
        return true;
    } //canBeUse()
    
} //Beamer
