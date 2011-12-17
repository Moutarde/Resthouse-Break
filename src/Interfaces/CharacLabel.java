package Interfaces;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Sprites.Coord;

import Characters.Figure;

/**
 * @author Nicolas
 *
 */
public class CharacLabel extends JLabel {
	private static final long serialVersionUID = -4812781411148504627L;
	
	Figure figure;
	Coord imgPanPos;
	
	public CharacLabel(int x, int y, Figure f) {
		this.figure = f;
		ImageIcon icon = new ImageIcon(f.getSprite().getObject(f.getPosture()));
        setIcon(icon);
        imgPanPos = new Coord(x, y);
        setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
	}
	
	public void setLabel() {
		setIcon(new ImageIcon(figure.getSprite().getObject(figure.getPosture())));
        setLocation(imgPanPos.getX() + figure.getCoord().getX(), imgPanPos.getY() + figure.getCoord().getY());
    }
	
	public void setImgPanPos(int x, int y) {
		imgPanPos = new Coord(x, y);
	}
	
	public void setFigure(Figure f) {
		System.out.println("setFigure : "+f.getCoord().toString());
		this.figure = f;
	}
	
	public void setLabel(int x, int y, Figure f) {
		setIcon(new ImageIcon(f.getSprite().getObject(f.getPosture())));
        setLocation(x + f.getCoord().getX(), y + f.getCoord().getY());
    }

	@Override public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//setLocation(imgPanPos.getX() + figure.getCoord().getX(), imgPanPos.getY() + figure.getCoord().getY());
		System.out.println("paintComponent : " + getLocation());
		//g.drawImage(figure.getSprite().getObject(figure.getPosture()), 0, 0, this);
		
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
}
