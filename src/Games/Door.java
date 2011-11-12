package Games;
import java.util.ArrayList;

/**
 * D�crivez votre classe Doors ici.
 * 
 * @author  Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (avril 2009)
 */
public class Door
{
    private ArrayList<Room> corresRooms;
    private boolean isLocked;
    
    private static ArrayList<Door> allDoors = new ArrayList<Door>();
    
    /**
     * Constructor for objects of class Doors.
     */
    public Door(Room room1, Room room2, boolean locked)
    {
        corresRooms = new ArrayList<Room>();
        corresRooms.add(room1);
        corresRooms.add(room2);
        isLocked = locked;
    } //Door(.)
    
    /**
     * @return True if the door is locked
     *         False if it is not.
     */
    public boolean isLocked()
    {
        return isLocked;
    } //isLocked
    
    /**
     * Lock the door.
     */
    public void lock()
    {
        isLocked = true;
    } //lock()
    
    /**
     * Unlock the door.
     */
    public void unlock()
    {
        isLocked = false;
    } //unlock()
    
    /**
     * @return The list of the correspondant rooms.
     */
    public ArrayList<Room> getCorresRooms()
    {
        return corresRooms;
    } //getCorresRooms()
    
    /**
     * @return The list of all the doors in the game.
     */
    public static ArrayList<Door> getAllDoors()
    {
        return allDoors;
    } //getAllDoors()
} //Door
