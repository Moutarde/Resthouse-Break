package Commands.Executables;

import Characters.NPC;
import Commands.Command;
import Games.GameEngine;


/**
 * D�crivez votre classe GoCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class TalkCommand extends Command
{
    /**
     * Constructor for objects of class TalkCommand
     */
    public TalkCommand()
    {
    }

    /**
     * Print out the message that the character talks.
     */
    public void execute(GameEngine engine)
    {
         if(!hasSecondWord()) {
            // if there is no second word, we don't know whom to talk...
            engine.getTextView().show("\n"+"Tu veux parler \u00e0 qui ?" + "\n");
            return;
        } //if
        
        String name = getSecondWord();
        
        NPC character = engine.getGameModel().getPlayer().getCurrentRoom().getCharacters().get(name);
        
        if (character == null) {
            engine.getTextView().show("\n"+"Y a personne qui porte ce nom ici..." + "\n");
            return;
        } //if
        
        else
        {
            engine.getTextView().show(character.getNPCTalk());
            engine.getGameModel().getPlayer().setLastTalk(character);
        } //if

    }
}
