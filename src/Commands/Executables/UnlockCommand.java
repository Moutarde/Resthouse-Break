package Commands.Executables;

import Games.*;
import Commands.*;


/**
 * D�crivez votre classe GoCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class UnlockCommand extends Command
{
    /**
     * Constructor for objects of class GoCommand
     */
    public UnlockCommand()
    {
    }

    /**
     * Unlock the door in the specified direction.
     */
    public void execute(GameEngine engine)
    {
        if(!hasSecondWord()) {
            engine.getTextView().show("\n" + "Tu veux que je d\u00e9verrouille quoi ?" + "\n");
            return;
        } //if
        
        String direction = getSecondWord();
        Door door = engine.getGameModel().getPlayer().getCurrentRoom().getDoor(direction);
        
        if (door == null) {
            engine.getTextView().show("\n" + "Il y a pas de portes ici !" + "\n");
            return;
        } //if
        
        else if (!engine.getGameModel().getPlayer().hasKey(door)) {
            engine.getTextView().show("\n" + "Je n'ai pas la bonne clef !" + "\n");
            return;
        } //if
        
        else {
            door.unlock();
            for (Door d : Door.getAllDoors())
            {
                if (d.getCorresRooms().containsAll(door.getCorresRooms())) {
                    d.unlock();
                }
            }
            engine.getTextView().show("\n" + "La porte " + direction + " est maintenant d\u00e9verrouill\u00e9e." + "\n");
        } //else
    }
}
