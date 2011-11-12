package Interfaces;

import Characters.Figure;
import Games.*;
import Sprites.Coord;
import Sprites.Sprite;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (mai 2009)
 */

public class UserInterface implements ActionListener
{
	private static GameEngine engine;
	private JFrame myFrame;
	private JTextField entryField;
	private JTextArea log;
	private ImgPan imgPan;
	private CharacPan characPan;

	/**
	 * Construct a UserInterface. As a parameter, a Game Engine
	 * (an object processing and executing the game commands) is
	 * needed.
	 * 
	 * @param gameEngine  The GameEngine object implementing the game logic.
	 */
	public UserInterface(GameEngine gameEngine)
	{
		engine = gameEngine;
		createGUI();
	} //UserInterface(.)

	/**
	 * Print out some text into the text area.
	 */
	public void print(String text)
	{
		log.append(text);
		log.setCaretPosition(log.getDocument().getLength());
	} //print(.)

	/**
	 * Print out some text into the text area, followed by a line break.
	 */
	public void println(String text)
	{
		log.append(text + "\n");
		log.setCaretPosition(log.getDocument().getLength());
	} //println(.)

	/**
	 * Show an image file in the interface.
	 */
	public void showImage()
	{
		new Thread(new Runnable() {
			public void run() {
				try {
					String imageName = engine.getGameModel().getPlayer().getCurrentRoom().getImageName();
					URL imageURL = this.getClass().getClassLoader().getResource(imageName);
					if(imageURL == null) {
						System.out.println("Image non trouv\u00e9e.");
					}
					else {
						final BufferedImage bg = ImageIO.read(imageURL);
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								imgPan.setBgImage(bg);
							}
						});
					}
				} catch (IOException e) {
					System.out.println("URL does'nt exist...");
					e.printStackTrace();
				}
			}
		}).start();

		myFrame.pack();
	} //showImage(.)

	public void showCharacter() {
		new Thread(new Runnable() {
			public void run() {
				final int xPos = (imgPan.getWidth()/2) - (imgPan.getBgImage().getWidth()/2);
				final int yPos = (imgPan.getHeight()/2) - (imgPan.getBgImage().getHeight()/2);
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						characPan.setLocation(xPos, yPos);
						characPan.setPreferredSize(new Dimension(imgPan.getBgImage().getWidth(), imgPan.getBgImage().getHeight()));
						characPan.addFigure(engine.getGameModel().getPlayer().getFigure());
					}
				});
			}
		}).start();
	}

	public void animateCharacter(String direction) {
		Figure f = engine.getGameModel().getPlayer().getFigure();

		int x = engine.getGameModel().getPlayer().getX();
		int y = engine.getGameModel().getPlayer().getY();

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

		final Figure f1 = f.clone();

		new Thread(new Runnable() {
			public void run() {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						characPan.addFigure(f1);
					}
				});
			}
		}).start();

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

		final Figure f2 = f.clone();

		new Thread(new Runnable() {
			public void run() {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						characPan.addFigure(f2);
					}
				});
			}
		}).start();

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

		final Figure f3 = f.clone();

		new Thread(new Runnable() {
			public void run() {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						characPan.addFigure(f3);
					}
				});
			}
		}).start();

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

		final Figure f4 = f.clone();

		new Thread(new Runnable() {
			public void run() {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						characPan.addFigure(f4);
					}
				});
			}
		}).start();
	}

	
	/**
	 * Enable or disable input in the input field.
	 */
	public void enable(boolean on)
	{
		entryField.setEditable(on);
		if(!on)
			entryField.getCaret().setBlinkRate(0);
	} //enable(.)

	/**
	 * Set up graphical user interface.
	 */
	private void createGUI()
	{
		myFrame = new JFrame("RESTHOUSE BREAK");
		myFrame.setFocusable(true);
		myFrame.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				myFrame.requestFocus();
			}
		});

		entryField = new JTextField(34);
		log = new JTextArea();
		log.setEditable(false);
		JScrollPane listScroller = new JScrollPane(log);
		listScroller.setPreferredSize(new Dimension(200, 200));
		listScroller.setMinimumSize(new Dimension(100,100));

		JPanel panel = new JPanel();
		URL imageURL = this.getClass().getClassLoader().getResource("room/ginetteRoom.jpg");
		try {
			BufferedImage bg = ImageIO.read(imageURL);
			imgPan = new ImgPan(bg);
		} catch (IOException e) {
			System.out.println("URL does'nt exist...");
			e.printStackTrace();
		}
		imgPan.setPreferredSize(new Dimension(1000, 527));
		
		characPan = new CharacPan(engine.getGameModel().getPlayer().getFigure());
		characPan.setOpaque(false);
		int xPos = (imgPan.getWidth()/2) - (imgPan.getBgImage().getWidth()/2);
		int yPos = (imgPan.getHeight()/2) - (imgPan.getBgImage().getHeight()/2);
		this.characPan.setPreferredSize(new Dimension(imgPan.getBgImage().getWidth(), imgPan.getBgImage().getHeight()));
		this.characPan.setLocation(xPos, yPos);
		
		imgPan.add(characPan);

		panel.setLayout(new BorderLayout());
		panel.add(imgPan, BorderLayout.NORTH);
		panel.add(listScroller, BorderLayout.CENTER);
		panel.add(entryField, BorderLayout.SOUTH);

		myFrame.setContentPane(panel);
		myFrame.addKeyListener(new Touche());

		// add some event listeners to some components
		myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});

		entryField.addActionListener(this);

		myFrame.pack();
		myFrame.setVisible(true);
		myFrame.requestFocus();
	} //createGUI()

	/**
	 * Actionlistener interface for entry textfield.
	 */
	public void actionPerformed(ActionEvent e) 
	{
		// no need to check the type of action at the moment.
		// there is only one possible action: text entry
		processCommand();
	} //actionPerformed(.)

	/**
	 * A command has been entered. Read the command and do whatever is 
	 * necessary to process it.
	 */
	private void processCommand()
	{
		String input = entryField.getText();
		entryField.setText("");

		engine.interpretCommand(input);
	} //processCommand()

	public static GameEngine getGE()
	{
		return engine;
	}
} //UserInterface