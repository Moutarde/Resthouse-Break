package Commands.Executables;

import Commands.*;
import Games.*;


/**
 * D�crivez votre classe GoCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class SeeCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public SeeCommand()
    {
    }

    /**
     * Print out Room Descrption
     */
    public void execute(GameEngine engine)
    {
         engine.getTextView().printVoir();
    }
}
