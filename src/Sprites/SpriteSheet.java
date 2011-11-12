package Sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * @author Nicolas Kniebihler
 *
 */
public class SpriteSheet {
	private BufferedImage image;
	
	private int spriteWidth;
	private int spriteHeight;
	
	public SpriteSheet(String fileName, int spriteWidth, int spriteHeight) {
		URL fileURL = this.getClass().getClassLoader().getResource(fileName);
		try {
			image = ImageIO.read(fileURL);
		} catch (IOException e) {
			System.out.println("URL does'nt exist...");
			e.printStackTrace();
		}
		this.spriteHeight = spriteHeight;
		this.spriteWidth = spriteWidth;
	}
	
	public Sprite getSprite(int x, int y) {
		/*int x = spriteX * this.spriteWidth;
		int y = spriteY * this.spriteHeight;
		return this.image.getSubimage(x, y, this.objectWidth, this.objectHeight);*/
		return new Sprite(this.image.getSubimage(x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight), spriteWidth/3, spriteHeight/4);
	}
}
