package Interfaces;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * D�crivez votre classe Touche ici.
 * 
 * @author (votre nom) 
 * @version (un num�ro de version ou une date)
 */
public class Touche implements KeyListener
{
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_DOWN :UserInterface.getGE().interpretCommand("go sud");
            break;

            case KeyEvent.VK_UP :UserInterface.getGE().interpretCommand("go nord");
            break;

            case KeyEvent.VK_RIGHT :UserInterface.getGE().interpretCommand("go est");
            break;

            case KeyEvent.VK_LEFT :UserInterface.getGE().interpretCommand("go ouest");
            break;

            case KeyEvent.VK_V :UserInterface.getGE().interpretCommand("voir");
            break;

            case KeyEvent.VK_S :UserInterface.getGE().interpretCommand("inspecterSac");
            break;

            case KeyEvent.VK_B :UserInterface.getGE().interpretCommand("back");
            break;

            case KeyEvent.VK_H :UserInterface.getGE().interpretCommand("15");
            break;
        }

    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}
}
