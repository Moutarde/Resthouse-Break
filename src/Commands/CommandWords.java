package Commands;

import Commands.Executables.*;

import java.util.HashMap;

/**
 * This Class contains the instruction for CommandWords
 * 
 * @author Pierre Charlet, Nicolas Kniebihler, Kevin Provost
 * @version November 2011
 */

public class CommandWords
{
    private HashMap<CommandWord, Command> commands;
    
    // a constant array that holds all valid command words
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) 
        {
            if(command != CommandWord.UNKNOWN) 
            {
                validCommands.put(command.toString(), command);
            }
        }
        
        commands = new HashMap<CommandWord, Command>();
        commands.put(CommandWord.GO, new GoCommand());
        commands.put(CommandWord.HELP, new HelpCommand());
        commands.put(CommandWord.QUIT, new QuitCommand());
        commands.put(CommandWord.EAT, new EatCommand());
        commands.put(CommandWord.SEE, new SeeCommand());
        commands.put(CommandWord.TAKE, new TakeCommand());
        commands.put(CommandWord.DROP, new DropCommand());
        //commands.put(CommandWord.TO, new ToCommand());
        //commands.put(CommandWord.LOCK, new LockCommand());
        //commands.put(CommandWord.UNLOCK, new UnlockCommand());
        commands.put(CommandWord.USEITEM, new UseCommand());
        commands.put(CommandWord.INSPECT, new InspectCommand());
        commands.put(CommandWord.TEST, new TestCommand());
        commands.put(CommandWord.INSPECTBAG, new InspectBagCommand());
        //commands.put(CommandWord.BACK, new BackCommand());
        commands.put(CommandWord.TALK, new TalkCommand());
        commands.put(CommandWord.BUY, new BuyCommand());
        commands.put(CommandWord.ALEA, new AleaCommand());
        commands.put(CommandWord.FREEZE, new FreezeCommand());
    }

    /**
     * Given a command word, find and return the matching command object.
     * Return null if there is no command with this name.
     */
    public Command get(String word)
    {
        return (Command)commands.get(validCommands.get(word));
    }

    /*
     * Print all valid commands to System.out.
     */
    /**
    * Return all valid commands.
    * @return a string of all valid commands.
    */
    public String showAll()
    {
        StringBuilder commandList = new StringBuilder();
        
        for(String command : validCommands.keySet()) 
        {
            commandList.append( command + " " );
        } //for
        
        return commandList.toString();
    } //showAll()
    
    /**
     * get the validcommand
     */
    public CommandWord getVal( String pKey )
    {
        CommandWord vRet = validCommands.get( pKey );
        
        if( vRet == null )
        {
            return CommandWord.UNKNOWN;
        }
        else
            return vRet;
    }
} //CommandWords
