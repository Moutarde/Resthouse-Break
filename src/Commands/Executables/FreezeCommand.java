package Commands.Executables;

import Characters.NPC;
import Characters.Nadia;
import Commands.Command;
import Games.GameEngine;


/**
 * This Class contains the instruction for FreezeCommand
 * 
 * @author Pierre Charlet, Nicolas Kniebihler, Kévin Provost
 * @version mai 2009
 */
public class FreezeCommand extends Command
{
    /**
     * Constructor for objects of class FreezeCommand
     */
    public FreezeCommand()
    {
    }

    /**
     * execute the FreezeCommand
     */
    public void execute(GameEngine engine)
    {
        if(!hasSecondWord())
        {
            return;
        }
        else
        {
            String str = getSecondWord();
            
            if(str.equals("Nadia"))
            {
                for(NPC character : engine.getGameModel().getNPCList())
                {
                    if (character.getNPCName().equals("Nadia"))
                    {
                        Nadia ch = (Nadia)character;
                        ch.freeze();
                    }
                }
            }
            return;
        }
    }
}
