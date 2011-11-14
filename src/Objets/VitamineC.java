package Objets;

import Games.*;

/**
 * Write a description of class  here.
 * 
 * @author  Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (mai 2009)
 */
public class VitamineC extends Item
{
    /**
     * Constructor for objects of class Pacemaker
     */
    public VitamineC(String n,String i,int c,int w,int nb)
    {
        super(n,i,c,w,nb);
    } //Pacemaker(.)
    
    /**
     * Use this item increase the max weight the player can carry.
     */
    @Override public void iAction(GameModel gameModel)
    {
        gameModel.getPlayer().increaseStepNb(50);
    } //iAction()
    
    /**
     * This item can be eaten.
     * @return True.
     */
    @Override public boolean canBeEaten()
    {
        return true;
    } //canBeEaten()
} //Pacemaker
