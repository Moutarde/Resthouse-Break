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
public class DropCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public DropCommand()
    {
    }

    /**
     * Remove the item in parameter from the player's bag,
     * and add it to the current room.
     */
    public void execute(GameEngine engine)
    {
        if(!hasSecondWord()) {
            // if there is no second word, we don't know what to inspect...
            engine.getTextView().show("\n"+"Tu veux que je pose quoi ?" + "\n");
            return;
        } //if
        
        String description = getSecondWord();
        HashMap<String, Item> bag = engine.getGameModel().getPlayer().getBag();
        
        if (!bag.containsKey(description)) 
        {
            engine.getTextView().show("\n" + "Mais ou tu veux que je trouve \u00e7a ?" + "\n");
        } //if
        else 
        {
            engine.getGameModel().getPlayer().removeWeight(bag.get(description).getItemWeight());
            engine.getGameModel().getPlayer().getCurrentRoom().getItems().addItem(bag.get(description).getItemName(), bag.get(description));
            engine.getGameModel().getPlayer().getBag().removeItem(description);
            engine.getTextView().printDropItem(description);
            engine.getTextView().printCarriedWeight(engine.getGameModel().getPlayer().getCarriedWeight());
        } //else
    }
}
