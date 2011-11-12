package Commands;

import java.util.StringTokenizer;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (mai 2009)
 */

public class Parser 
{
    private CommandWords commands;  // holds all valid command words

    /**
     * Create a new Parser.
     */
    public Parser() 
    {
        commands = new CommandWords();
    } //Parser()
        
    /**
     * Get a new command from the user. The command is read by
     * parsing the 'inputLine'.
     */
    public Command getCommand(String inputLine) 
    {
        //String inputLine = "";   // will hold the full input line
        String word1;
        String word2;

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();      // get first word
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();      // get second word
        else
            word2 = null;

        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        Command command = commands.get(word1);
        if(command != null) {
            command.setSecondWord(word2);
        }
        return command;
    } //getCommand(.)
    
    /**
     * get the validcommand
     */
    public CommandWord getVal( String pKey )
    {
        return commands.getVal( pKey );
    } //getVal(.)
    
    /**
     * Return a list of valid command words.
     * 
     * @return the list of valid command words.
     */
    public String showCommands()
    {
        return commands.showAll();
    } //showCommands()
} //Parser
