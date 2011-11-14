package Characters;

import java.util.LinkedList;

/**
 * This Class contains the instruction for LoopMovingCharacter.
 * 
 * @author Pierre Charlet, Nicolas Kniebihler, Kévin Provost
 * @version November 2011
 */
public class LoopMovingCharacter extends MovingCharacter
{
    private LinkedList<String> loop;

    /**
     * Create a LoopMovingCharacter object
     */
    public LoopMovingCharacter(String name, String description, String talk)
    {
        super(name, description, talk);
        loop = new LinkedList<String>();
    }    

    /**
     * Add a direction to the loop.
     */
    public void addDirection(String direction)
    {
        loop.addLast(direction);
    }
    
    /**
     * Return the next direction and put it at the end of the loop.
     */
    public String getNextDirection()
    {
        loop.addLast(loop.getFirst());
        return loop.pop();
    }
    
    /**
     * Move the character in a random direction.
     * If it is a wall or a locked door, do nothing.
     * @param str Always null.
     */
    @Override public void move(String str)
    {
        String direction = getNextDirection();
        
        if (super.getCurrentRoom().getDoor(direction) != null)
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
} //LoopMovingCharacter
