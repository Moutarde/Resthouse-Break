package Interfaces;

import java.awt.Graphics;
import java.util.LinkedList;
import javax.swing.JPanel;

import Characters.Figure;

/**
 * @author Nicolas Kniebihler
 *
 */
public class CharacPan extends JPanel {
	private static final long serialVersionUID = 6824100793455062135L;
	private LinkedList<Figure> figures;
	
	public CharacPan() {
		super();
		
		this.figures = new LinkedList<Figure>();
	}

	@Override public void paintComponent(Graphics g){
		super.paintComponent(g);

		if(figures.isEmpty()) {
			System.out.println("No figures to print...");
		}
		else {
			if(figures.size() == 1) {
				Figure figure = figures.getFirst();

				int x = figure.getCoord().getX();
				int y = figure.getCoord().getY();

				g.drawImage(figure.getSprite().getObject(figure.getPosture()), x, y, this);
			}
			else if(figures.size() > 1) {
				Figure figure = figures.removeFirst();

				int x = figure.getCoord().getX();
				int y = figure.getCoord().getY();

				g.drawImage(figure.getSprite().getObject(figure.getPosture()), x, y, this);
				this.repaint();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void clearFigures() {
		figures.clear();
	}
	
	public void addFigure(Figure figure) {
		if(!(!figures.isEmpty() && figures.getLast().equals(figure))) {
			this.figures.addLast(figure);
		}
		this.repaint();
	}
	
	public LinkedList<Figure> getFigures() {
		return this.figures;
	}
}
