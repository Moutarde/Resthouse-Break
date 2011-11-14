package Commands.Executables;

import Commands.Command;
import Games.GameEngine;


/**
 * D�crivez votre classe GoCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class HelpCommand extends Command
{
    /**
     * Constructor for objects of class HelpCommand
     */
    public HelpCommand()
    {
    }
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    public void execute(GameEngine engine)
    {
        engine.getTextView().printHelp();
        engine.getTextView().show("Les commandes sont : " + engine.getParser().showCommands() + "\n");
    }
}
