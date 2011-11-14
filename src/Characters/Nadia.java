package Characters;


/**
 * This Class contains the instruction for Nadia
 * 
 * @author Pierre Charlet, Nicolas Kniebihler, Kévin Provost
 * @version mai 2009
 */
public class Nadia extends AleaMovingCharacter
{
    private boolean freeze;

    /**
     * Create a Nadia object
     */
    public Nadia(String name, String description, String talk, boolean freeze)
    {
        super(name, description, talk);
        this.freeze = freeze;
    }

    public boolean isFrozen()
    {
        return freeze;
    }
    
    public void freeze()
    {
        freeze = true;
    }
    
    @Override public boolean isNadia()
    {
        return true;
    }
    
    @Override public void move(String str)
    {
        if(!freeze)
        {
            super.move(str);
        }
    }

}
