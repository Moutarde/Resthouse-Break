package Commands.Executables;

import java.util.HashMap;
import Commands.*;
import Objets.*;
import Games.*;
import Characters.*;


/**
 * D�crivez votre classe BuyCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class BuyCommand extends Command
{
    /**
     * Constructor for objects of class BuyCommand
     */
    public BuyCommand()
    {
    }

    /**
     * Buy the item in parameter
     * and put it in the player's bag.
     */
    public void execute(GameEngine engine)
    {
        if(!hasSecondWord()) 
        {
            // if there is no second word, we don't know what to inspect...
            engine.getTextView().show("\n" + "Tu veux que j'ach\u00eate quoi ?" + "\n");
            return;
        } //if
        
        NPC lastTalk = engine.getGameModel().getPlayer().getLastTalk();
        
        if (lastTalk == null)
        {
            engine.getTextView().show("\n" + "Je dois parler \u00e0 quelqu'un si je veux acheter quelque chose..." + "\n");
            return;
        } //if
        
        String item = getSecondWord();
//         HashMap<String, Item> hm = engine.getGameModel().getPlayer().getCurrentRoom().getCharacters().get(lastTalk).getBag();
        HashMap<String, Item> hm = lastTalk.getBag();
        
        
        
        if (!hm.containsKey(item)) 
        {
            engine.getTextView().show("\n" + "Il ne vend pas \u00e7a !" + "\n");
            return;
        } //if
        else 
        {
            if ( engine.getGameModel().getPlayer().controlCarriedWeight( engine.getGameModel().getPlayer().getCarriedWeight() + hm.get(item).getItemWeight() ) )
            {
                if ( engine.getGameModel().getPlayer().controlTeethNb( hm.get(item).getItemCost() ) )
                {
                    engine.getGameModel().getPlayer().removeTeeth(hm.get(item).getItemCost());
                    
                    engine.getGameModel().getPlayer().addWeight(hm.get(item).getItemWeight());
                    
                    if(engine.getGameModel().getPlayer().getBag().containsKey(item))
                    {
                        engine.getGameModel().getPlayer().getBag().get(item).increaseNb(hm.get(item).getItemNb());
                    } //if
                    else
                    {
                        engine.getGameModel().getPlayer().getBag().addItem(hm.get(item).getItemName(), hm.get(item));
                    } //else
                    lastTalk.getBag().removeItem(item);
                    engine.getTextView().printBuyItem(item);
                    engine.getTextView().printCarriedWeight(engine.getGameModel().getPlayer().getCarriedWeight());
                    engine.getTextView().printTeethNb(engine.getGameModel().getPlayer().getTeethNb());
                } //if
                
                else
                {
                    engine.getTextView().show("\n" + "J'ai pas assez de dents en or pour acheter \u00e7a !" + "\n");
                    return;
                } //else
            } //if
            else
            {
                engine.getTextView().show("\n" + "J'ai plus de place dans mon sac !" + "\n");
            } //else
        } //else
    } //execute(.)
} //BuyCommand
