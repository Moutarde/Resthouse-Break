package Commands.Executables;

import Commands.Command;
import Games.GameEngine;
import Games.GameModel;


/**
 * This Class contains the instruction for AleaCommand
 * 
 * @author Pierre Charlet, Nicolas Kniebihler, Kévin Provost
 * @version mai 2009
 */
public class AleaCommand extends Command
{
    /**
     * Constructor for objects of class AleaCommand
     */
    public AleaCommand()
    {
    }

    /**
     * execute the AleaCommand
     */
    public void execute(GameEngine engine)
    {
        if(hasSecondWord())
        {
            GameModel.setAleaS(getSecondWord());
            return;
        }
        else
        {
            GameModel.setAleaS("");
            return;
        }
    }
}
