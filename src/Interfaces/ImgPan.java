package Interfaces;

import Characters.Figure;
import Sprites.Coord;
import Sprites.Sprite;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * @author Nicolas Kniebihler
 *
 */
public class ImgPan extends JPanel {
	private BufferedImage bgImage;
	
	public ImgPan(BufferedImage bgImage) {
		super();
		this.bgImage = bgImage;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		int xPos = (this.getWidth()/2) - (bgImage.getWidth()/2);
		int yPos = (this.getHeight()/2) - (bgImage.getHeight()/2);
		
		g.drawImage(bgImage, xPos, yPos, this);
	}
	
	public void setBgImage(BufferedImage bgImage) {
		this.bgImage = bgImage;
		this.repaint();
	}
	
	public BufferedImage getBgImage() {
		return this.bgImage;
	}
}
