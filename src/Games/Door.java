package Games;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import Sprites.Coord;

/**
 * D�crivez votre classe Doors ici.
 * 
 * @author  Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (avril 2009)
 */
public class Door
{
    private HashMap<Room, Coord> corresRooms;
    private boolean isLocked;
    
    private static ArrayList<Door> allDoors = new ArrayList<Door>();
    
    /**
     * Constructor for objects of class Doors.
     */
    public Door(Room room1, Coord coord1, Room room2, Coord coord2, boolean locked)
    {
        corresRooms = new HashMap<Room, Coord>();
        corresRooms.put(room1, coord1);
        corresRooms.put(room2, coord2);
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
    public Set<Room> getCorresRooms()
    {
        return corresRooms.keySet();
    } //getCorresRooms()
    
    public HashMap<Room, Coord> getRoomsAndCoords(){
    	return corresRooms;
    }
    
    /**
     * @return The list of all the doors in the game.
     */
    public static ArrayList<Door> getAllDoors()
    {
        return allDoors;
    } //getAllDoors()

	public Room getNeighborRoom(Room room) {
        for (Room neighbor : this.getCorresRooms())
        {
            if (neighbor != room)
            {
                return neighbor;
            } //if
        } //foreach
		return null;
	}
} //Door
