package Interfaces;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Characters.Figure;
import Sprites.Coord;

/**
 * @author Nicolas Kniebihler
 *
 */
public class CharacLabel extends JLabel {
	private static final long serialVersionUID = -4812781411148504627L;
	
	private Figure figure;
	private Coord imgPanPos;
	
	public CharacLabel(int x, int y, Figure f) {
		this.figure = f;
		ImageIcon icon = new ImageIcon(f.getSprite().getObject(f.getPosture()));
        setIcon(icon);
        imgPanPos = new Coord(x, y);
        setBounds(x + f.getCoord().getX(), y + f.getCoord().getY(), icon.getIconWidth(), icon.getIconHeight());
    }
	
	public void setLabel() {
		setIcon(new ImageIcon(figure.getSprite().getObject(figure.getPosture())));
        setLocation(imgPanPos.getX() + figure.getCoord().getX(), imgPanPos.getY() + figure.getCoord().getY());
    }
	
	public void setLabel(int x, int y, Figure f) {
		setIcon(new ImageIcon(f.getSprite().getObject(f.getPosture())));
        setLocation(x + f.getCoord().getX(), y + f.getCoord().getY());
    }
	
	public void setImgPanPos(int x, int y) {
		imgPanPos = new Coord(x, y);
	}
	
	public Coord getImgPanPos() {
		return this.imgPanPos;
	}
	
	public void setFigure(Figure f) {
		this.figure = f;
	}
	
	public Figure getFigure() {
		return figure;
	}
}
