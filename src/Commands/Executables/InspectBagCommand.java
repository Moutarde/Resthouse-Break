package Commands.Executables;

import java.util.HashMap;

import Commands.Command;
import Games.GameEngine;
import Objets.Item;


/**
 * D�crivez votre classe Command ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class InspectBagCommand extends Command
{
    /**
     * Constructor for objects of class InspectBagCommand
     */
    public InspectBagCommand()
    {
    }

    /**
     * Try to inspect an Item in the player's bag. If it's an item, print out 
     * a description, otherwise print an error message.
     */
    public void execute(GameEngine engine)
    {
        if(!hasSecondWord())
        {
            engine.getTextView().show("\n" + engine.getGameModel().getPlayer().getBagContent());
            engine.getTextView().printTeethNb(engine.getGameModel().getPlayer().getTeethNb() );
            return;
        }
        
        String description = getSecondWord();
        
        HashMap<String, Item> bag = engine.getGameModel().getPlayer().getBag();
        
        if (!bag.containsKey(description)) 
        {
            engine.getTextView().show("\n" + "Mais ou tu veux que je trouve \u00e7a ?" + "\n");
        } //if
        else 
        {
            engine.getTextView().show("\n"+ bag.get(description).getItemName() +":"
                                + bag.get(description).getItemDescription()+"\n"
                                + "prix : " + bag.get(description).getItemCost() + "\n"
                                + "poids : " + bag.get(description).getItemWeight() + "\n");
        } //else
    }
}
