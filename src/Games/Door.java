package Games;
import java.util.ArrayList;
import java.util.HashMap;

import Sprites.Coord;

/**
 * D�crivez votre classe Doors ici.
 * 
 * @author  Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (avril 2009)
 */
public class Door
{
    //private HashMap<Room, ArrayList<Coord>> corresRooms;
    private ArrayList<SideOfDoor> sides;
    private boolean isLocked;
    
    private static ArrayList<Door> allDoors = new ArrayList<Door>();
    
    /**
     * Constructor for objects of class Doors.
     */
    public Door(Room room1, ArrayList<Coord> list1, Coord c1,
    			Room room2, ArrayList<Coord> list2, Coord c2,
    			boolean locked)
    {
        //corresRooms = new HashMap<Room, ArrayList<Coord>>();
        //corresRooms.put(room1, coord1);
        //corresRooms.put(room2, coord2);
    	this.sides = new ArrayList<SideOfDoor>();
    	this.sides.add(new SideOfDoor(room1, list1, c1));
    	this.sides.add(new SideOfDoor(room2, list2, c2));
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
    	ArrayList<Room> l = new ArrayList<Room>();
        l.add(sides.get(0).getRoom());
        l.add(sides.get(1).getRoom());
        return l;
    } //getCorresRooms()
    
    public HashMap<Room, ArrayList<Coord>> getRoomsAndCoords() {
    	HashMap<Room, ArrayList<Coord>> h = new HashMap<Room, ArrayList<Coord>>();
    	h.put(sides.get(0).getRoom(), sides.get(0).getDoorCoords());
    	h.put(sides.get(1).getRoom(), sides.get(1).getDoorCoords());
    	return h;
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

	public Coord getStartCoord(Room nextRoom) {
		for (SideOfDoor s : this.sides)
        {
            if (s.getRoom() == nextRoom)
            {
                return s.getStartCoord();
            } //if
        } //foreach
		return null;
	}
	
	public SideOfDoor getSideOfDoor(Room room) {
		for(SideOfDoor s : sides) {
			if(s.getRoom() == room) {
				return s;
			}
		}
		return null;
	}

	public boolean containsCoord(Coord caseCoord, Room room) {
		for(Coord c : this.getSideOfDoor(room).getDoorCoords()) {
			if(c.equals(caseCoord)) {
				return true;
			}
		}
		return false;
	}
} //Door
