package Commands;

/**
 * Representations for all the valid command words for the game.
 * 
 * @author Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (mai 2009)
 */
public enum CommandWord
{

    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), QUIT("quitter"), HELP("15"), SEE("voir"), EAT("manger"), INSPECT("inspecter"), BACK("back"),
    TO("to"), TEST("test"), TAKE("prendre"), DROP("jeter"), INSPECTBAG("inspecterSac"), UNKNOWN("?"), USEITEM("utiliser"),
    UNLOCK("deverrouiller"), LOCK("verrouiller"), TALK("parler"), BUY("acheter");

    // The command string.
    private String commandString;
    
    /**
    * Initialize with the corresponding command word.
    * @param commandString The command string.
    */
    CommandWord(String commandString)
    {
      this.commandString = commandString;
    }
    
    /**
    * @return The command word as a string.
    */
    public String toString()
    {
      return commandString;
    }

} //CommandWord