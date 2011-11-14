//package Characters;
//
//import java.util.LinkedList;
//
///**
// * D�crivez votre classe LoopMovingCharacter ici.
// * 
// * @author (votre nom) 
// * @version (un num�ro de version ou une date)
// */
//public class LoopMovingCharacter extends MovingCharacter
//{
//    private LinkedList<String> loop;
//
//
//    public LoopMovingCharacter(String name, String description, String talk)
//    {
//        super(name, description, talk);
//        loop = new LinkedList<String>();
//    }    
//
//    /**
//     * Add a direction to the loop.
//     */
//    public void addDirection(String direction)
//    {
//        loop.addLast(direction);
//    }
//    
//    /**
//     * Return the next direction and put it at the end of the loop.
//     */
//    public String getNextDirection()
//    {
//        loop.addLast(loop.getFirst());
//        return loop.pop();
//    }
//    
//    /**
//     * Move the character in a random direction.
//     * If it is a wall or a locked door, do nothing.
//     * @param str Allways null.
//     */
//    @Override public void move(String str)
//    {
//        String direction = getNextDirection();
//        
//        if (super.getCurrentRoom().getDoor(direction) != null)
//        {
//            if (!super.getCurrentRoom().getDoor(direction).isLocked())
//            {
//                if (super.getCurrentRoom().getExit(direction) != null)
//                {
//                    super.getCurrentRoom().getCharacters().removeCharacter(super.getNPCName());
//                    super.setCurrentRoom(super.getCurrentRoom().getExit(direction));
//                    super.getCurrentRoom().getCharacters().addCharacter(super.getNPCName(), this);
//                    System.out.println("" + super.getNPCName() + super.getNPCName() + super.getCurrentRoom().getShortDescription());
//                } //if
//            } //if
//        } //if
//    } //move()
//    
//} //LoopMovingCharacter
