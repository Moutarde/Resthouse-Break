package Games;

import java.util.ArrayList;

import Sprites.Coord;

/**
 * @author Nicolas
 *
 */
public class SideOfDoor {
	private Room room;
    private ArrayList<Coord> doorCoords;
    private Coord startCoord;
    
    public SideOfDoor(Room room, ArrayList<Coord> coords, Coord c) {
    	this.room = room;
    	this.doorCoords = coords;
    	this.startCoord = c;
    }

	public Room getRoom() {
		return this.room;
	}

	public ArrayList<Coord> getDoorCoords() {
		return this.doorCoords;
	}

	public Coord getStartCoord() {
		return this.startCoord;
	}
    
    
}
