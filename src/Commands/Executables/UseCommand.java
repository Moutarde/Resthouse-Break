package Commands.Executables;

import java.util.HashMap;

import Commands.Command;
import Games.GameEngine;
import Objets.Item;


/**
 * D�crivez votre classe GoCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class UseCommand extends Command
{
    /**
     * Constructor for objects of class UseCommand
     */
    public UseCommand()
    {
    }

    /**
     * Use an item
     */
    public void execute(GameEngine engine)
    {
        if(!hasSecondWord()) 
        {
            engine.getTextView().printuseItem();
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
            if (bag.get(description).canBeUse())
            {   
                bag.get(description).iAction(engine.getGameModel());
                engine.getTextView().printuse(description);

                engine.getTextView().show("\n" + engine.getGameModel().getPlayer().getBagContent() + "\n");
                
            }
            else
            {
                engine.getTextView().show("\n" + "Mais \u00e7a va pas non !!!" + "\n");
            }
        } //else
    }
}
