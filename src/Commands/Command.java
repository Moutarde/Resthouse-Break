package Commands;
import Games.*;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two strings: a command word and a second
 * word (for example, if the command was "take map", then the two strings
 * obviously are "take" and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is <null>.
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * @author  Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (mai 2009)
 */

public abstract class Command
{
    private String secondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null. The command word should be null to
     * indicate that this was a command that is not recognised by this game.
     */
    public Command()
    {
        secondWord = null;
    }

    /**
     * Return the second word of this command. If no
     * second word was entered, the result is null.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * Check whether a second word was entered for this 
     * command.
     */
    public boolean hasSecondWord()
    {
        return secondWord != null;
    }

    /**
     * Define the second word of this command (the word
     * entered after the command word). Null indicates that 
     * there was no second word.
     */
    public void setSecondWord(String secondWord)
    {
        this.secondWord = secondWord;
    }

    /**
     * Execute this command. A flag is returned indicating whether
     * the game is over as a result of this command.
     * 
     * @return True, if game should exit; false otherwise.
     */
    public abstract void execute(GameEngine engine);

//     private String commandWord;
//     private String secondWord;
// 
//     /**
//      * Create a command object. First and second word must be supplied, but
//      * either one (or both) can be null.
//      * @param firstWord The first word of the command. Null if the command
//      *                  was not recognised.
//      * @param secondWord The second word of the command.
//      */
//     public Command(String firstWord, String secondWord)
//     {
//         commandWord = firstWord;
//         this.secondWord = secondWord;
//     } //Command(.)
// 
//     /**
//      * Return the command word (the first word) of this command. If the
//      * command was not understood, the result is null.
//      * @return The command word.
//      */
//     public String getCommandWord()
//     {
//         return commandWord;
//     } //getCommandWord()
// 
//     /**
//      * @return The second word of this command. Returns null if there was no
//      * second word.
//      */
//     public String getSecondWord()
//     {
//         return secondWord;
//     } //getSecondWord()
// 
//     /**
//      * @return true if this command was not understood.
//      */
//     public boolean isUnknown()
//     {
//         return (commandWord == null);
//     } //isUnknown()
// 
//     /**
//      * @return true if the command has a second word.
//      */
//     public boolean hasSecondWord()
//     {
//         return (secondWord != null);
//     } //hasSecondWord()
} //Command

