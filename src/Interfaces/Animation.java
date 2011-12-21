package Interfaces;

import java.util.concurrent.Semaphore;

import Sprites.Coord;
import Sprites.Sprite;
import Characters.Figure;
import Games.Matrix;

/**
 * @author Nicolas Kniebihler
 *
 */
public class Animation implements Runnable {
	Thread t = null;

	public final static Semaphore sem = new Semaphore(1);
	private static boolean running;
	
	private CharacLabel charLab;
	private Figure f;
	private int x;
	private int y;
	private String direction;
	
	public Animation(CharacLabel charLab, int x, int y, Figure f, String dir) {
		this.charLab = charLab;
		this.f = f;
		this.x = x;
		this.y = y;
		this.direction = dir;
		t = new Thread(this);
		t.start();
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			sem.acquire();
			running = true;
			
			f.setMoveDirection(direction);
			this.charLab.setFigure(f);
			this.charLab.setLabel();

			if(direction.equals("est")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3 + Matrix.CASE_SIZE/4, y * Matrix.CASE_SIZE - 5));
				f.setPosture(Sprite.goRight1);
			}
			else if(direction.equals("ouest")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3 - Matrix.CASE_SIZE/4, y * Matrix.CASE_SIZE - 5));
				f.setPosture(Sprite.goLeft1);
			}
			else if(direction.equals("nord")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5 - Matrix.CASE_SIZE/4));
				f.setPosture(Sprite.goUp1);
			}
			else if(direction.equals("sud")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5 + Matrix.CASE_SIZE/4));
				f.setPosture(Sprite.goDown1);
			}

			charLab.setLabel();
			charLab.repaint();

			try {
				Thread.sleep(80);
			}
			catch (InterruptedException evt) {}

			if(direction.equals("est")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3 + Matrix.CASE_SIZE/2, y * Matrix.CASE_SIZE - 5));
				f.setPosture(Sprite.showRight);
			}
			else if(direction.equals("ouest")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3 - Matrix.CASE_SIZE/2, y * Matrix.CASE_SIZE - 5));
				f.setPosture(Sprite.showLeft);
			}
			else if(direction.equals("nord")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5 - Matrix.CASE_SIZE/2));
				f.setPosture(Sprite.showUp);
			}
			else if(direction.equals("sud")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5 + Matrix.CASE_SIZE/2));
				f.setPosture(Sprite.showDown);
			}

			charLab.setLabel();
			charLab.repaint();

			try {
				Thread.sleep(80);
			}
			catch (InterruptedException evt) {}

			if(direction.equals("est")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3 + 3 * Matrix.CASE_SIZE/4, y * Matrix.CASE_SIZE - 5));
				f.setPosture(Sprite.goRight2);
			}
			else if(direction.equals("ouest")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3 - 3 * Matrix.CASE_SIZE/4, y * Matrix.CASE_SIZE - 5));
				f.setPosture(Sprite.goLeft2);
			}
			else if(direction.equals("nord")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5 - 3 * Matrix.CASE_SIZE/4));
				f.setPosture(Sprite.goUp2);
			}
			else if(direction.equals("sud")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5 + 3 * Matrix.CASE_SIZE/4));
				f.setPosture(Sprite.goDown2);
			}

			charLab.setLabel();
			charLab.repaint();

			try {
				Thread.sleep(80);
			}
			catch (InterruptedException evt) {}

			if(direction.equals("est")) {
				f.setCoord(new Coord((x + 1) * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5));
				f.setPosture(Sprite.showRight);
			}
			else if(direction.equals("ouest")) {
				f.setCoord(new Coord((x - 1) * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5));
				f.setPosture(Sprite.showLeft);
			}
			else if(direction.equals("nord")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, (y - 1) * Matrix.CASE_SIZE - 5));
				f.setPosture(Sprite.showUp);
			}
			else if(direction.equals("sud")) {
				f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, (y + 1) * Matrix.CASE_SIZE - 5));
				f.setPosture(Sprite.showDown);
			}

			charLab.setLabel();
			charLab.repaint();

			try {
				Thread.sleep(80);
			}
			catch (InterruptedException evt) {}
			
			running = false;
			sem.release();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static boolean isNotRunning() {
		return !(running);
	}
}
