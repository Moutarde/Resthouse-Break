package Commands.Executables;

import Commands.Command;
import Games.GameEngine;


/**
 * D�crivez votre classe GoCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class SeeCommand extends Command
{
    /**
     * Constructor for objects of class SeeCommand
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
