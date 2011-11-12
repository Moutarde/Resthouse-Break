package Commands.Executables;

import Games.*;
import Commands.*;


/**
 * D�crivez votre classe GoCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class BackCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public BackCommand()
    {
    }

     /** 
     * Back to the last room.
     */
    public void execute(GameEngine engine)
    {

        if (engine.getGameModel().getBackRoom().empty())
        {
            engine.getTextView().show("\n"+"Tu veux que je revienne avant de partir !!");
        } //if
        else
        {
            engine.getGameModel().goBack();
            engine.getGameModel().getPlayer().setLastTalk(null);
        } //else

    }
}
