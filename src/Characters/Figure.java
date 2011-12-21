package Characters;

import Sprites.Coord;
import Sprites.Sprite;

/**
 * @author Nicolas
 *
 */
public class Figure {
	private Sprite sprite;
	private Coord coord;
	private Coord posture;
	private String moveDirection;
	
	public Figure(Sprite sprite, Coord coord, Coord posture) {
		this.sprite = sprite;
		this.coord = coord;
		this.posture = posture;
		this.moveDirection = "";
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	public Coord getCoord() {
		return this.coord;
	}
	
	public Coord getPosture() {
		return this.posture;
	}
	
	public String getMoveDirection() {
		return this.moveDirection;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	
	public void setPosture(Coord posture) {
		this.posture = posture;
	}
	
	public void setMoveDirection(String moveDirection) {
		this.moveDirection = moveDirection;
	}
	
	public Figure clone() {
		Figure f = new Figure(this.sprite, this.coord.clone(), this.posture.clone());
		f.setMoveDirection(this.moveDirection);
		return f;
	}
	
	public boolean equals(Figure figure) {
		return this.getCoord().getX() == figure.getCoord().getX() && this.getCoord().getY() == figure.getCoord().getY();
	}
}
