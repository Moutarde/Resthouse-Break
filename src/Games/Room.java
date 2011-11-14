package Games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Objets.*;
import Sprites.Coord;
import Characters.*;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled nord, 
 * est, sud, ouest.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (mai 2009)
 */
public class Room 
{
    private String description;
    private HashMap<String, Door> doors;
    private ItemList items;
    private CharacterList characters;
    private String imageName;
    private int [][] matrix;
    
    private static HashMap<String, Room> allRoom = new HashMap<String, Room>();
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, String image, int[][] m) 
    {
        this.description = description;
        doors = new HashMap<String, Door>();
        items = new ItemList();
        characters = new CharacterList();
        imageName = image;
        matrix = m;
    } //Room(.)

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor The room in the given direction.
     * @param locked True if the door in this direction is locked, false if it is not.
     */
    public void setExit(String direction,
    					ArrayList<Coord> roomCoords, Coord roomStartCoord,
    					Room neighbor, ArrayList<Coord> neighborCoord, Coord neighborStartCoord,
    					boolean locked)
    {
        Door door = new Door(this,
        					 roomCoords, roomStartCoord,
        					 neighbor, neighborCoord, neighborStartCoord,
        					 locked);
//         Door testDoor = new Door(neighbor,this,locked);
//         if (!doors.containsValue(testDoor)) {
            doors.put(direction, door);
//         }
        Door.getAllDoors().add(door);
    } //setExit(.)
    
    /**
     * Add a room to the list of all the rooms : allRoom.
     */
    public static void setAllRoom(String nom, Room r)
    {
        allRoom.put(nom, r);
    } //setAllRoom(.)
    
    /**
     * Get the room that corresponds to the name in parameter
     * in the list of all the rooms : allRoom.
     */
    public static Room getAllRoom(String direction)
    {
        return allRoom.get(direction);
    } //getAllRoom(.)
    
    /**
     * @return The list of all rooms.
     */
    public static HashMap<String, Room> returnAllRoom()
    {
        return allRoom;
    } //returnAllRoom()
    
    /**
     * Return the description of the room (the one that was defined in the
     * constructor).
     *
     * @return The description of the room.
     */
    public String getShortDescription()
    {
        return description;
    } //getShortDescription()

    /**
     * Return a long description of this room, of the form:
     *      You are in the kitchen.
     *      Exits: north west
     * @return A description of the room, including exits.
     */
     public String getLongDescription()
     {
         return "\n" + "Vous \u00eates " + description + ".\n"
                                         + getExitString() + "\n"
                                         + getItemString() + "\n"
                                         + getCharacterString() + "\n";
     } //getLongDescription()
    
    /**
     * Return the room that is reached if we go from this
     * room in direction "direction". If there is no room in
     * that direction, return null.
     * @return The room that corresponds with the direction given in parameter.
     */
    public Room getExit(Coord caseCoord)
    {
    	Door door = null;
    	
        for(Door d : doors.values()) {
        	if(d.containsCoord(caseCoord, this)){
        		door = d;
        	}
        }
        
        if (door != null)
        {
        	return door.getNeighborRoom(this);
        } //if
        else {
        	return null;
        }
    } //getExit(.)
    
    /**
     * @return The door that is in this direction.
     */
    public Door getDoor(String direction)
    {
        return doors.get(direction);
    } //getDoor(.)
    
    /**
     * @return The list of all the items in the room.
     */
    public ItemList getItems()
    {
        return items;
    } //getItems()
    
    /**
     * @return The list of all the characters in the room.
     */
    public CharacterList getCharacters()
    {
        return characters;
    } //getCharacters()
    
    /**
     * Return a description of the room's exits,
     * for example, "Sorties : nord ouest".
     * @return A description of the available exits.
     */
    private String getExitString()
    {
        StringBuilder returnString = new StringBuilder( "Sorties :" );
        
        for ( String exit : doors.keySet() )
            returnString.append( "\n" + "   " + exit );
            
        return returnString.toString();
    } //getExitString()
    
    /**
     * Return a description of the room's items,
     * for example, "Objets : verre, dentier".
     * @return A description of the items in the room.
     */
    private String getItemString()
    {
        StringBuilder returnString = new StringBuilder( "Objets :" );
        
        for ( String item : items.keySet() )
            returnString.append( "\n" + "   " + items.get(item).getItemNb() + " " + item );
            
        return returnString.toString();
    } //getitemString()
    
    /**
     * Return a description of the room's characters,
     * for example, "Personnes : Houss".
     * @return A description of the present characters.
     */
    private String getCharacterString()
    {
        StringBuilder returnString = new StringBuilder( "Personnes :" );
        
        for ( String character : characters.keySet() )
            returnString.append( "\n" + "   " + characters.get(character).getNPCDescription() );
            
        return returnString.toString();
    } //getCharacterString()

    /**
     * Return a string describing the room's image name
     */
    public String getImageName()
    {
        return imageName;
    } //getImageName()

    /**
     * @return False by default (the classic rooms are not transporters)
     */
    public boolean isTransporter()
    {
        return false;
    } //isTransporter()
    
    public int[][] getMatrix(){
    	return matrix;
    }

	public String getRelativePositionWith(Room room) {
		for(Map.Entry<String, Door> e : doors.entrySet()) {
			if(e.getValue().getCorresRooms().contains(room)) {
				return e.getKey();
			}
		}
		return null;
	}
} //Room
