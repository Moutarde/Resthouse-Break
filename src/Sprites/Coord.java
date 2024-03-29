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
	
	@Override public boolean equals(Object o) {
		if(o instanceof Coord) {
			if(this.getX() == ((Coord)o).getX() && this.getY() == ((Coord)o).getY()) {
				return true;
			}
		}
		return false;
	}
}
