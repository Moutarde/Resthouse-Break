//package Characters;
//
//import java.util.Random;
//import Games.*;
//
///**
// * D�crivez votre classe AleaMovingCharacter ici.
// * 
// * @author (votre nom) 
// * @version (un num�ro de version ou une date)
// */
//public class AleaMovingCharacter extends MovingCharacter
//{
//    public AleaMovingCharacter(String name, String description, String talk)
//    {
//        super(name, description, talk);
//    }    
//
//    /**
//     * Move the character in a random direction.
//     * If it is a wall or a locked door, do nothing.
//     * @param str Allways null.
//     */
//    @Override public void move(String str)
//    {
//        Random rand = new Random();
//        
//        String direction = GameModel.getExitStrings()[rand.nextInt(GameModel.getExitStrings().length)];
//        
//        if(super.getCurrentRoom().getDoor(direction) != null)
//        {
//            if (!super.getCurrentRoom().getDoor(direction).isLocked())
//            {
//                if (super.getCurrentRoom().getExit(direction) != null)
//                {
//                    super.getCurrentRoom().getCharacters().removeCharacter(super.getNPCName());
//                    super.setCurrentRoom(super.getCurrentRoom().getExit(direction));
//                    super.getCurrentRoom().getCharacters().addCharacter(super.getNPCName(), this);
//                    System.out.println("" + super.getNPCName() + super.getCurrentRoom().getShortDescription());
//                } //if
//            } //if
//        } //if
//    } //move()
//    
//} //AleaMovingCharacter
