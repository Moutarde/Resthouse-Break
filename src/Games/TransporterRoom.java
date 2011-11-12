package Games;

import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class TransporterRoom here.
 * 
 * @author  Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (mai 2009)
 */
public class TransporterRoom extends Room
{
    /**
     * Constructor for objects of class TransporterRoom
     */
    public TransporterRoom(String description, String image, int[][] m)
    {
        super(description, image, m);
    } //TransporterRoom(.)
        
    /**
     * This room is a transporter room.
     * @return True.
     */
    @Override public boolean isTransporter()
    {
        return true;
    } //isTransporter()
    
    /**
     * Return a random room, independant of the direction
     * parameter.
     * @param direction Ignored.
     * @return A random room.
     */
    @Override public Room getExit(String direction)
    {
        return findRandomRoom();
    } //getExit(.)
    
    /**
     * Choose a random room.
     */
    private Room findRandomRoom()
    {
        ArrayList<String> list = new ArrayList<String>();
        Random rand = new Random();
        
        for (String room : Room.returnAllRoom().keySet())
        {
            list.add(room);
        } //for
        
        return Room.returnAllRoom().get(list.get(rand.nextInt(list.size())));
    } //findRandomRoom()
} //TransporterRoom
