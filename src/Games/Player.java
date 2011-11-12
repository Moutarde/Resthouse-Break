package Games;

import Characters.Figure;
import Characters.NPC;
import Objets.Item;
import Objets.ItemList;
import Objets.Key;
import Sprites.Coord;

/**
 * 
 * 
 * @author Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (mai 2009)
 */
public class Player
{
    private Room currentRoom;
    private String name;
    private ItemList bag;
    private int teethNb;
    private int maxWeight;
    private int carriedWeight;
    private int stepNb;
    private int xPosition;
    private int yPosition;
    private NPC lastTalk;
    private Figure figure;

    /**
     * Create a new player. A player has a current room (the place where he is),
     * a bag that contains items, and a number of golden teeth.
     */
    public Player(Room startRoom, String name, int startSaving, int maxWeight, int startStep, int x, int y, Figure figure)
    {
        currentRoom = startRoom;
        this.name = name;
        teethNb = startSaving;
        this.maxWeight = maxWeight;
        stepNb = startStep;
        bag = new ItemList();
        xPosition = x;
        yPosition = y;
        this.figure = figure;
        lastTalk = null;
    } //Player(.)

    /**
     * @return The current room.
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    } //getCurrentRoom()
    
    /**
     * @return The player's name.
     */
    public String getName()
    {
        return name;
    } //getName()
    
    /**
     * @return The player's bag.
     */
    public ItemList getBag()
    {
        return bag;
    } //getBag()
    
    /**
     * @return The number of teeth that the player has.
     */
    public int getTeethNb()
    {
        return teethNb;
    } //getTeethNb()
    
    /**
     * @return The max weight the player can carry.
     */
    public int getMaxWeight()
    {
        return maxWeight;
    } //getMaxWeight()
    
    /**
     * @return The weight actually carried by the player.
     */
    public int getCarriedWeight()
    {
        return carriedWeight;
    } //getCarriedWeight()
    
    /**
     * @return The number of steps the player can go.
     */
    public int getStepNb()
    {
        return stepNb;
    } //getStepNb()
    
    /**
     * @return The last character the player talked with.
     */
    public NPC getLastTalk()
    {
        return lastTalk;
    }
    
    public int getX() {
    	return xPosition;
    }
    
    public int getY() {
    	return yPosition;
    }
    
    public Figure getFigure() {
    	return figure;
    }

	public void walk(String direction) {
		if(direction.equals("nord")) {
			this.yPosition--;
		}
		else if(direction.equals("sud")) {
			this.yPosition++;
		}
		else if(direction.equals("ouest")) {
			this.xPosition--;
		}
		else if(direction.equals("est")) {
			this.xPosition++;
		}
		else {
			System.out.println("Wrong direction : " + direction);
		}
	}
	
	public void setPosition(Coord c) {
		this.xPosition = c.getX();
		this.yPosition = c.getY();
		this.figure.setCoord(new Coord(c.getX() * Matrix.CASE_SIZE - 3, c.getY() * Matrix.CASE_SIZE - 5));
	}
    
    /**
     * Replace the current room by the room in parameter.
     */
    public void goRoom(Room nextRoom, String direction)
    {
    	this.setPosition(currentRoom.getDoor(direction).getRoomsAndCoords().get(nextRoom));
        currentRoom = nextRoom;
    } //goRoom(.)
    
    /**
     * @return A description of the items in the player's bag.
     */
    public String getBagContent()
    {
        StringBuilder returnString = new StringBuilder( "Objets dans le sac :" );
        
        if (!bag.isEmpty())
        {
            for ( String item : bag.keySet() )
                returnString.append( " " + bag.get(item).getItemNb() + " " + item + "\n");
        } //if
        else
        {
            returnString.append( " aucun");
        } //else
            
        return returnString.toString();
    } //getBagContent()
    
    /**
     * Add the weight in parameter to the weight actually carried
     * by the player.
     */
    public void addWeight(int weight)
    {
        carriedWeight += weight;
    } //addWeight(.)
    
    /**
     * Remove the weight in parameter to the weight actually carried
     * by the player.
     */
    public void removeWeight(int weight)
    {
        carriedWeight -= weight;
    } //removeWeight(.)
    
    /**
     * Add the number of teeth in parameter to the number of
     * teeth the player has.
     */
    public void addTeeth(int teeth)
    {
        teethNb += teeth;
    } //addTeeth(.)
    
    /**
     * Remove the number of teeth in parameter to the number of
     * teeth the player has.
     */
    public void removeTeeth(int teeth)
    {
        teethNb -= teeth;
    } //removeTeeth(.)
    
    /**
     * Increase the max weight the player can carry.
     */
    public void increaseMaxWeight(int weight)
    {
        maxWeight += weight;
    } //increaseMaxWeight(.)
    
    /**
     * Decrease the max weight the player can carry.
     */
    public void decreaseMaxWeight(int weight)
    {
        maxWeight -= weight;
    } //decreaseMaxWeight(.)
    
    /**
     * Increase the max weight the player can carry.
     */
    public void increaseStepNb(int step)
    {
        stepNb += step;
    } //increaseStepNb(.)
    
    /**
     * Decrease the max weight the player can carry.
     */
    public void decreaseStepNb(int step)
    {
        stepNb -= step;
    } //decreaseStepNb(.)
    
    /**
     * Control if the weight in parameter is positive and under the max weight.
     * @return True if the weight can be carried by the player.
     *         False if it can not.
     */
    public boolean controlCarriedWeight(int weight)
    {
        return weight >= 0 && weight <= maxWeight;
    } //controlCarriedWeight(.)
    
    /**
     * Control if the weight in parameter is positive and under the max weight.
     * @return True if the weight can be carried by the player.
     *         False if it can not.
     */
    public boolean controlStepNb()
    {
        return stepNb > 0;
    } //controlStepNb()
    
    /**
     * Control if the number of teeth in parameter is positive and under the number of teeth the player has.
     * @return True if the player has enough teeth.
     *         False if he has not.
     */
    public boolean controlTeethNb(int teeth)
    {
        return teeth >= 0 && teeth <= teethNb;
    } //controlTeethNb(.)
    
    /**
     * 
     */
    public boolean hasKey(Door door)
    {
        for ( Item item : bag.values() )
        {
            if (item.isAKey())
            {
                Key key = (Key)item;
                if (key.getDoor().getCorresRooms().containsAll(door.getCorresRooms()))
                    return true;
            } //if
        } //foreach
        return false;
    } //hasKey(.)
    
    /**
     * Initialise the lastTalk attribute with the character given 
     * in parameter.
     */
    public void setLastTalk(NPC character)
    {
        lastTalk = character;
    }
    
    public int canGoTo(String direction) {
    	int[][] m = this.getCurrentRoom().getMatrix();
    	if(direction.equals("est")) {
    		if(getX() != m[0].length-1) {
    			return m[this.getY()][this.getX()+1];
    		}
    	}
    	if(direction.equals("ouest")) {
    		if(getX() != 0) {
    			return m[this.getY()][this.getX()-1];
    		}
    	}
    	if(direction.equals("nord")) {
    		if(getY() != 0) {
    			return m[this.getY()-1][this.getX()];
    		}
    	}
    	if(direction.equals("sud")) {
    		if(getY() != m.length-1) {
    			return m[this.getY()+1][this.getX()];
    		}
    	}
    	return 0;
    }
} //Player
