package Interfaces;

import Games.*;

import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;

/**
 * ImageView is a graphic view of the Zuul game. It shows images on the 
 * screen.
 * 
 * @author Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version  1.0 (May 2009)
 */
public class ImageView implements Observer
{
    //private GameModel gameModel;
    private UserInterface gui;
    
    /**
     * Constructor for objects of class ImageView.
     */
    public ImageView(GameModel gameModel)
    {
        //this.gameModel = gameModel;
    } //TextView(.)
    
    /**
     * Initialises the user interface, and shows the start room.
     */
    public void setGUI(UserInterface userInterface)
    {
        gui = userInterface;
        gui.showImageAndCharacter();
    } //setGUI(.)
    
    /**
     * Updates the current room's image when the player changes location.
     */
    public void update(Observable o, Object arg)
    {
    	if(arg == null) {
    		gui.showImageAndCharacter();
    	}
    	else if(arg instanceof String) {
    		String word1;
            String word2;

            StringTokenizer tokenizer = new StringTokenizer((String)arg);

            if(tokenizer.hasMoreTokens())
                word1 = tokenizer.nextToken();      // get first word
            else
                word1 = null;
            if(tokenizer.hasMoreTokens())
                word2 = tokenizer.nextToken();      // get second word
            else
                word2 = null;
            
            if(word1.equals("move")) {
            	gui.animateCharacter(word2);
            }
            else {
            	System.out.println(word1);
            }
    	}
    } //update(.)
} //ImageView