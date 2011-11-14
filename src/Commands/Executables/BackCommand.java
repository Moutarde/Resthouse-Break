package Commands.Executables;

import Commands.Command;
import Games.GameEngine;


/**
 * This Class contains the instruction for BackCommand
 * 
 * @author Pierre Charlet, Nicolas Kniebihler, Kevin Provost
 * @version November 2011
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
