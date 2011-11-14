package Commands.Executables;

import Commands.Command;
import Games.Door;
import Games.GameEngine;


/**
 * D�crivez votre classe GoCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class LockCommand extends Command
{
    /**
     * Constructor for objects of class LockCommand
     */
    public LockCommand()
    {
    }

    /**
     * Lock the door in the specified direction.
     */
    public void execute(GameEngine engine)
    {
        if(!hasSecondWord()) {
            engine.getTextView().show("\n" + "Tu veux que je verrouille quoi ?" + "\n");
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
            door.lock();
            for (Door d : Door.getAllDoors())
            {
                if (d.getCorresRooms().containsAll(door.getCorresRooms())) {
                    d.lock();
                }
            }
            engine.getTextView().show("\n" + "La porte " + direction + " est maintenant verrouill\u00e9e." + "\n");
        } //else
    }
}
