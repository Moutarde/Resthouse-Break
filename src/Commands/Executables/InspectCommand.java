package Commands.Executables;

import java.util.HashMap;
import Objets.*;
import Games.*;
import Commands.*;


/**
 * D�crivez votre classe GoCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class InspectCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public InspectCommand()
    {
    }

    /**
     * Try to inspect an Item in the current room. If it's an item, print out 
     * a description, otherwise print an error message.
     */
    public void execute(GameEngine engine)
    {
        if(!hasSecondWord()) {
            // if there is no second word, we don't know what to inspect...
            engine.getTextView().show("\n"+"Tu veux que je m'int\u00e9resse a quoi ?" + "\n");
            return;
        } //if
        
        String description = getSecondWord();
        
        HashMap<String, Item> hm = engine.getGameModel().getPlayer().getCurrentRoom().getItems();

        if (!hm.containsKey(description)) 
        {
            engine.getTextView().show("\n" + "Mais ou tu veux que je trouve \u00e7a ?" + "\n");
        } //if
        else 
        {
            engine.getTextView().show("\n"+ hm.get(description).getItemName() +":"
                                + hm.get(description).getItemDescription()+"\n"
                                + "prix : " + hm.get(description).getItemCost() + "\n"
                                + "poids : " + hm.get(description).getItemWeight() + "\n");
        } //else
    }
}
