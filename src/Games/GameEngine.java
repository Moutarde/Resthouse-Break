package Games;

import Commands.Command;
import Commands.Parser;
import Interfaces.ImageView;
import Interfaces.TextView;
import Interfaces.UserInterface;

/**
 *  Class GameEngine
 * This Class initialises the game
 * 
 * @author  Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version November 2011
 */

public class GameEngine
{
    private Parser parser;
    private GameModel gameModel;
    private TextView textView;
    private ImageView imageView;
    private UserInterface gui;

    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine() 
    {
        gameModel = new GameModel();
        textView = new TextView(gameModel);
        imageView = new ImageView(gameModel);
        gameModel.addObserver(textView);
        gameModel.addObserver(imageView);
        parser = new Parser();
    } //GameEngine()

    /**
     * Initialise the game's user interface.
     */
    public void setGUI(UserInterface userInterface)
    {
        gui = userInterface;
        textView.setGUI(gui);
        imageView.setGUI(gui);
    } //setGUI(.)

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public void interpretCommand(String commandLine) 
    {
        textView.show("\n"+commandLine);
        Command command = parser.getCommand(commandLine);

        if(command == null) {
            textView.show("\n" + "Y raconte quoi le petit jeune ?!" + "\n");
        } else {
            command.execute(this);
        }
    } //interpretCommand(.)

    // implementations of user commands:

    /**
     * @return The attribute parser
     */
    public Parser getParser()
    {
        return parser;
    }

    /**
     * @return The attribute gameModel
     */
    public GameModel getGameModel()
    {
        return gameModel;
    }

    /**
     * @return The attribute textView
     */
    public TextView getTextView()
    {
        return textView;
    }

    /**
     * @return The attribute imageView
     */
    public ImageView getImageView()
    {
        return imageView;
    }

    /**
     * @return The attribute gui
     */
    public UserInterface getGUI()
    {
        return gui;
    }

    /**
     * Print out a good bye message, and end the game.
     */
    public void endGame()
    {
        textView.printGoodBye();
        gui.enable(false);
    } //endGame
    
    /**
     * Print out a  game over message, and end the game.
     */
    public void gameOver()
    {
        textView.printGameOver();
        gui.enable(false);
    }
} //GameEngine
