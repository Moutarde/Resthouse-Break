package Commands.Executables;

import Commands.Command;
import Games.GameEngine;
import Games.Room;
import Sprites.Coord;


/**
 * D�crivez votre classe GoCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class GoCommand extends Command
{
	/**
	 * Constructor for objects of class GoCommand
	 */
	public GoCommand()
	{
	}

	/** 
	 * Try to go to one direction. If there is an exit, enter the new
	 * room, otherwise print an error message. Returns always 'false'.
	 */
	public void execute(GameEngine engine)
	{
		if(!hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			engine.getTextView().show("\n"+"Hein ?! Tu veux aller ou ?" + "\n");
			return;
		} //if

		if(!engine.getGameModel().getPlayer().controlStepNb())
		{
			engine.getTextView().show("\n"+"Je suis trop fatigu\u00e9e, je ne peux plus aller plus loin" + "\n");
			return;
		}

		String direction = getSecondWord();

		int nextCaseValue = engine.getGameModel().getPlayer().canGoTo(direction);
		if(nextCaseValue == 1) {
			engine.getGameModel().walk(direction);
		}
		else if (nextCaseValue == 2) {
			// Try to leave current room.
			Coord nextCaseCoords = engine.getGameModel().getPlayer().getCaseCoords(direction);
			Room currentRoom = engine.getGameModel().getPlayer().getCurrentRoom();
			Room nextRoom = currentRoom.getExit(nextCaseCoords);

			if (nextRoom == null) {
				engine.getTextView().show("\n"+"Change tes lunettes mamy, c'est un mur par l\u00e0" + "\n");
			} //if
			else {
				String dirOfNextRoom = currentRoom.getRelativePositionWith(nextRoom);

				if (dirOfNextRoom != null) {
					if (engine.getGameModel().getPlayer().getCurrentRoom().getDoor(dirOfNextRoom).isLocked())
					{
						engine.getTextView().show("\n" + "Cette porte est ferm\u00e9e, il faut trouver la cl\u00e9..." + "\n");
						return;
					} //if

					else
					{
						/*for (NPC character : engine.getGameModel().getNPCList())
	            		{
	                		if (character.canMove())
	                		{
	                    		MovingCharacter mC = (MovingCharacter)character;
	                    		mC.move(null);
	                		} //if
	            		} //foreach*/

						engine.getGameModel().goRoom(nextRoom, dirOfNextRoom);
						engine.getTextView().show("\n" + "nombre de pas restant : " +engine.getGameModel().getPlayer().getStepNb()+ "\n");
						engine.getGameModel().getPlayer().setLastTalk(null);
					} //else
				}
			}

			if (engine.getGameModel().getPlayer().getCurrentRoom() == Room.getAllRoom("dehors"))
			{
				engine.endGame();
			}
		}

		/*
        // Try to leave current room.
        Room nextRoom = engine.getGameModel().getPlayer().getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            engine.getTextView().show("\n"+"Change tes lunettes mamy, c'est un mur par l\u00e0" + "\n");
        } //if

        else if (engine.getGameModel().getPlayer().getCurrentRoom().getDoor(direction).isLocked())
        {
            engine.getTextView().show("\n" + "Cette porte est ferm\u00e9e, il faut trouver la cl\u00e9..." + "\n");
            return;
        } //if

        else
        {
            for (NPC character : engine.getGameModel().getNPCList())
            {
                if (character.canMove())
                {
                    MovingCharacter mC = (MovingCharacter)character;
                    mC.move(null);
                } //if
            } //foreach

            engine.getGameModel().goRoom(nextRoom);
            engine.getTextView().show("\n" + "nombre de pas restant : " +engine.getGameModel().getPlayer().getStepNb()+ "\n");
            engine.getGameModel().getPlayer().setLastTalk(null);
        } //else

        if (engine.getGameModel().getPlayer().getCurrentRoom() == Room.getAllRoom("dehors"))
        {
            engine.endGame();
        }
		 */
	}
}
