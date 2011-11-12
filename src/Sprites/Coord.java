package Sprites;

/**
 * @author Nicolas Kniebihler
 *
 */
public class Coord {
	private int x;
	private int y;
	
	public Coord(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Coord clone() {
		return new Coord(this.getX(), this.getY());
	}
}
