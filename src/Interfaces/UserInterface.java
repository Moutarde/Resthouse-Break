package Interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Characters.Figure;
import Games.GameEngine;

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
	private CharacLabel characPan;

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
	 * Show an image file in the interface
	 * and the characters' images on it.
	 */
	public void showImageAndCharacter() {
		new Thread(new Runnable() {
			public void run() {
				try {
					String imageName = engine.getGameModel().getPlayer().getCurrentRoom().getImageName();
					URL imageURL = this.getClass().getClassLoader().getResource(imageName);
					if(imageURL == null) {
						System.out.println("Image non trouv\u00e9e.");
					}
					BufferedImage bg = ImageIO.read(imageURL);
					try {
						Animation.sem.acquire();

						engine.getGameModel().getPlayer().reloadFigureCoord();

						imgPan.setBgImage(bg);

						int xPos = (imgPan.getWidth()/2) - (bg.getWidth()/2);
						int yPos = (imgPan.getHeight()/2) - (bg.getHeight()/2);

						characPan.setImgPanPos(xPos, yPos);
						characPan.setLabel();

						imgPan.repaint();

						characPan.repaint();

						Animation.sem.release();
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				} catch (IOException e) {
					System.out.println("URL does'nt exist...");
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void showCharacter(String dir, Figure f, int x, int y) {
		new Animation(characPan, x, y, f, dir);
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
		imgPan.setSize(new Dimension(1000, 527));

		int xPos = (imgPan.getWidth()/2) - (imgPan.getBgImage().getWidth()/2);
		int yPos = (imgPan.getHeight()/2) - (imgPan.getBgImage().getHeight()/2);
		characPan = new CharacLabel(xPos, yPos, engine.getGameModel().getPlayer().getFigure());

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
		myFrame.setResizable(false);
		myFrame.setVisible(true);
		myFrame.requestFocus();
		
		characPan.setLabel();
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
		clearText();

		engine.interpretCommand(input);
	} //processCommand()

	public void clearText()
	{
		entryField.setText("");
	}

	public static GameEngine getGE()
	{
		return engine;
	}
	
	public CharacLabel getCharacLabel() {
		return characPan;
	}
} //UserInterface