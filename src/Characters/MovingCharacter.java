//package Characters;
//
//import Games.*;
//
//
///**
// * D�crivez votre classe MovingCharacter ici.
// * 
// * @author (votre nom) 
// * @version (un num�ro de version ou une date)
// */
//public class MovingCharacter extends NPC
//{
//    private Room currentRoom;
//
//    /**
//     * Constructor for objects of class MovingCharacter.
//     */
//    public MovingCharacter(String name, String description, String talk)
//    {
//        super(name, description, talk);
//    }
//    
//    /**
//     * Initialise the current room with the room given in parameter.
//     */
//    public void setCurrentRoom(Room room)
//    {
//        currentRoom = room;
//    }
//    
//    /**
//     * @return The current room.
//     */
//    public Room getCurrentRoom()
//    {
//        return currentRoom;
//    }
//    
//    /**
//     * Move the character in the room in the direction in parameter.
//     * If it is a wall or a locked door, do nothing.
//     */
//    public void move(String direction)
//    {
//        if (currentRoom.getDoor(direction) != null)
//        {
//            if (!currentRoom.getDoor(direction).isLocked())
//            {
//                if (currentRoom.getExit(direction) != null)
//                {
//                    currentRoom.getCharacters().removeCharacter(super.getNPCName());
//                    currentRoom = currentRoom.getExit(direction);
//                    currentRoom.getCharacters().addCharacter(super.getNPCName(), this);
////                     System.out.println("" + currentRoom.getShortDescription());
//                } //if
//            } //if
//        } //if
//    } //move()
//    
//    /**
//     * @return True by default (moving characters can move).
//     */
//    public boolean canMove()
//    {
//        return true;
//    } //canMove()
//
//} //MovingCharacter
