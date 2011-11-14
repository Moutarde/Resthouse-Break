package Commands.Executables;

import java.util.HashMap;

import Commands.Command;
import Games.GameEngine;
import Objets.Item;


/**
 * D�crivez votre classe TakeCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class TakeCommand extends Command
{
    /**
     * Constructor for objects of class TakeCommand
     */
    public TakeCommand()
    {
    }

    /**
     * Add the item in parameter in the player's bag.
     */
    public void execute(GameEngine engine)
    {
        if(!hasSecondWord()) 
        {
            // if there is no second word, we don't know what to inspect...
            engine.getTextView().show("\n" + "Tu veux que je prenne quoi ?" + "\n");
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
            if ( engine.getGameModel().getPlayer().controlCarriedWeight( engine.getGameModel().getPlayer().getCarriedWeight() + hm.get(description).getItemWeight() ) )
            {
                engine.getGameModel().getPlayer().addWeight(hm.get(description).getItemWeight());
                
                if(engine.getGameModel().getPlayer().getBag().containsKey(description))
                {
                    engine.getGameModel().getPlayer().getBag().get(description).increaseNb(hm.get(description).getItemNb());
                }
                else
                {
                    engine.getGameModel().getPlayer().getBag().addItem(hm.get(description).getItemName(), hm.get(description));
                }
                engine.getGameModel().getPlayer().getCurrentRoom().getItems().removeItem(description);
                engine.getTextView().printTakeItem(description);
                engine.getTextView().printCarriedWeight(engine.getGameModel().getPlayer().getCarriedWeight());
            } //if
            else
            {
                engine.getTextView().show("\n" + "J'ai plus de place dans mon sac !" + "\n");
            } //else
        } //else
    }
}
