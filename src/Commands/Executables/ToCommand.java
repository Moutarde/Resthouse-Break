package Commands.Executables;

import Commands.*;
import Games.*;


/**
 * D�crivez votre classe GoCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class ToCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public ToCommand()
    {
    }

   /** 
     * Try to go directly to one room. If there is a room, enter
     * the new room, otherwise print an error message.
     */
    public void execute(GameEngine engine)
    {
        if(!hasSecondWord()) 
        {
            engine.getTextView().show("\n" + "O\u00f9 \u00e7a ?" + "\n");
            return;
        } //if

        String mot2 = getSecondWord();
        Room nextRoom = Room.getAllRoom(mot2);

        if (mot2.equals("help")) 
        {
            engine.getTextView().printToHelp();
        } //if
        
        if (nextRoom == null) 
        {
            engine.getTextView().show("\n" + "Cette pi\u00e8ce n'existe pas..." + "\n");
            return;
        } //if
        else {
            engine.getGameModel().goRoom(nextRoom);
            engine.getGameModel().getPlayer().setLastTalk(null);
        } //else
    }
}
