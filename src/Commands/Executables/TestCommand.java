package Commands.Executables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Commands.Command;
import Games.GameEngine;


/**
 * D�crivez votre classe GoCommand ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class TestCommand extends Command
{
    /**
     * Constructor for objects of class TestCommand
     */
    public TestCommand()
    {
    }

    /**
    * Test the game with the file given in parameter.
    */
    public void execute(GameEngine engine)
    {
        if(!hasSecondWord()) {
            engine.getTextView().show("\n" + "Tester \u00e0 partir de quel fichier ?" + "\n");
            return;
        } //if
        
        Scanner sr; //declare the scanner
        try
        {
            String nameFile = getSecondWord();
            sr = new Scanner(new File("test/" + nameFile ) ); //initialise the scanner
            
            while ( sr.hasNext() ) 
            {
                String ligne = sr.nextLine();
                engine.interpretCommand(ligne);
            } //while
                sr.close(); //close the file
        } //try
        
        catch(FileNotFoundException e)
        {
            String nameFile = getSecondWord();
            engine.getTextView().show("\n" + "Le fichier "+nameFile+" n'existe pas" + "\n");
        } //catch
    }
}
