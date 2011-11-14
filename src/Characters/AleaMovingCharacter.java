package Characters;

import java.util.Random;
import Games.*;

/**
 * This Class contains the instruction for AleaMovingCharacter.
 * 
 * @author Pierre Charlet, Nicolas Kniebihler, Kevin Provost
 * @version November 2011
 */
public class AleaMovingCharacter extends MovingCharacter
{
	/**
	 *Create an AleaMovingCharacter object 
	 */
	public AleaMovingCharacter(String name, String description, String talk)
	{
		super(name, description, talk);
	}    

	/**
	 * Move the character in a random direction.
	 * If it is a wall or a locked door, do nothing.
	 * @param str Always null.
	 */
	@Override public void move(String str)
	{
		Random rand = new Random();

		String direction = GameModel.getExitStrings()[rand.nextInt(GameModel.getExitStrings().length)];

		if(super.getCurrentRoom().getDoor(direction) != null)
		{
			if (!super.getCurrentRoom().getDoor(direction).isLocked())
			{
				if (super.getCurrentRoom().getExit(direction) != null)
				{
					super.getCurrentRoom().getCharacters().removeCharacter(super.getNPCName());
					super.setCurrentRoom(super.getCurrentRoom().getExit(direction));
					super.getCurrentRoom().getCharacters().addCharacter(super.getNPCName(), this);
				} //if
			} //if
		} //if
	} //move()

	/**
	 * @return isNadia
	 */
	 @Override public boolean isNadia()
	{
		return false;
	}
} //AleaMovingCharacter
