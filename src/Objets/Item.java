package Objets;

import Games.*;


/**
 * Class Item - an item in an adventure game.
 * 
 * @author Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 19/04/2009
 */
public class Item
{
    private String nom;
    private String description;
    private int cost;
    private int weight;
    private int nb;
    
    /**
     *  Create an Item object with 3 parameters.
     */
    public Item(String n, String i, int c, int w, int nb)
    {
        nom=n;
        description=i;
        cost=c;
        weight=w;
        this.nb=nb;
    } //Item(.)
    
    /**
     * @return The object's name.
     */
    public String getItemName()
    {
        return nom;
    } //getItemName()
    
    /**
     * @return The object's description.
     */
    public String getItemDescription()
    {
        return description;
    } //getItemDescription()
    
    /**
     * @return The object's cost.
     */
    public int getItemCost()
    {
        return cost;
    } //getItemCost()
    
    /**
     *
     * @return The object's weight.
     */
    public int getItemWeight()
    {
        return weight;
    } //getItemWeight()
    
    /**
     * @return The object's nb.
     */
    public int getItemNb()
    {
        return nb;
    } //getItemNb()
    
    /**
     * Increase Nb
     */
    public void increaseNb(int n)
    {
        nb += n;
    } //increaseNb(.)
    
    /**
     * Decrease Nb
     */
    public void decreaseNb(int n)
    {
        nb -= n;
    } //decreaseNb(.)
    
    /**
     * This method had to be rewritten
     */
    public void iAction(GameModel gameModel){}
    
    /**
     * @return False by default (the classic items can not be eaten).
     */
    public boolean canBeEaten()
    {
        return false;
    } //canBeEaten()
    
    /**
     * @return False by default (the classic items can not be use).
     */
    public boolean canBeUse()
    {
        return false;
    } //canBeUse()
    
    /**
     * @return False by default (the classic items are not keys).
     */
    public boolean isAKey()
    {
        return false;
    } //isAKey()
} //Item