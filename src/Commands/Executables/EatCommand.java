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
public class EatCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public EatCommand()
    {
    }

    /**
     * Eat the item if it is eatable, or return an error message.
     */
    public void execute(GameEngine engine)
    {
        if(!hasSecondWord()) 
        {
            engine.getTextView().printManger();
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
            if (bag.get(description).canBeEaten())
            {
                bag.get(description).iAction(engine.getGameModel());
                engine.getTextView().printEat(description);
                engine.getGameModel().getPlayer().getBag().removeItem(description);
                engine.getTextView().show("\n" + engine.getGameModel().getPlayer().getBagContent() + "\n");
            }
            else
            {
                engine.getTextView().show("\n" + "Mais \u00e7a va pas non !!!" + "\n");
            }
        } //else
    }
}
