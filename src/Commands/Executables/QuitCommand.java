package Commands.Executables;

import Commands.*;
import Games.*;


/**
 * D�crivez votre classe GoCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class QuitCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public QuitCommand()
    {
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public void execute(GameEngine engine)
    {
        engine.endGame();
    }
}
