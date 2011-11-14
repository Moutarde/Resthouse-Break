import java.applet.Applet;

import Interfaces.*;
import Games.*;

/**
 *  This class is the main class of the "RESTHOUSE BREAK" application. 
 * 
 *  This main class creates the necessary implementation objects and starts the game off.
 * 
 * @author  Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (may 2009)
 */

public class Game extends Applet
{
	private static final long serialVersionUID = -2625172347154287733L;
	
	private UserInterface gui;
	private GameEngine engine;

	public void init(){}

	public static void main( String[] args )
	{
	    new Game();
	} //main(.)
	
    /**
     * Create the game and initialize its internal map.
     */
    public Game() 
    {
		engine = new GameEngine();
		gui = new UserInterface(engine);
		engine.setGUI(gui);
    } //Game()
} //Game
