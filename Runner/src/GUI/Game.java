package GUI;
import javax.swing.*;

import LOGIC.Avatar;
import LOGIC.ListBox;
import LOGIC.Score;
import sun.audio.AudioPlayer;
import sun.audio.ContinuousAudioDataStream;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class Game extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	Timer t = new Timer(17, this);
	int frame = 0;
	LoadFiles loadfiles;
	Menu menu;
	HighScores highscores;
	Avatar avatar;
	Avatar avatar2;
	ListBox listbox;	
	Score score;
	Instructions instructions;

	public static enum STATE{
		MENU,
		GAME,
		HIGHSCORE,
		NEWHIGHSCORE,
		INSTRUCTIONS,
	};

	public static STATE State = STATE.MENU;

	
	/**
	 * Game Constructor
	 */
	public Game(){

		requestFocus();
		t.start();
		loadfiles = new LoadFiles();
		avatar = new Avatar(0, 475, getLoadFiles().getAvatarR()[0], this);
		//avatar2 = new Avatar(0, 475, getLoadFiles().getAvatarR()[0], this);
		listbox = new ListBox(this);
		score = new Score(this);
		menu = new Menu(this);
		highscores = new HighScores(this);
		instructions = new Instructions(this);
		AudioPlayer musicPlayer = AudioPlayer.player;
		try {
			ContinuousAudioDataStream loop = new ContinuousAudioDataStream(getLoadFiles().getBacksound().getData());
			//musicPlayer.start(loop);
		} catch (IOException e) {
			e.printStackTrace();
		}
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	
	/**
	 * Paints components on the screen
	 * 
	 * @param g Graphics Object
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (State == STATE.MENU){
			g.drawImage(getLoadFiles().getMenu(), 0, 0, 500, 510, this);
			menu.draw(g);
		}
		else if (State == STATE.GAME){
			frame();
			//System.out.println(getScore().getScore());
			g.drawImage(getLoadFiles().getFloor(), 0, 0, 500, 510, this);
			listbox.draw(g);
			score.draw(g);
			avatar.draw(g);
//			avatar2.draw(g);
			g.drawImage(getLoadFiles().getOnlyfloor(), 0, 500, 500, 10, this);
			g.setFont(new Font("Aharoni", Font.BOLD, 18)); 
			g.drawString(Integer.toString(score.getScore()), 478, 510);
		}
		else if (State == STATE.HIGHSCORE){
			g.drawImage(getLoadFiles().getHighscore(), 0, 0, 500, 510, this);
			highscores.draw(g);
		}
		else if (State == STATE.NEWHIGHSCORE){
			g.drawImage(getLoadFiles().getHighscore(), 0, 0, 500, 510, this);
			highscores.draw(g);
		}
		else if (State == STATE.INSTRUCTIONS){
			g.drawImage(getLoadFiles().getInstructions(), 0, 0, 500, 510, this);
			instructions.draw(g);
		}

	}	
	
	
	/**
	 * Updates the screen
	 */
	public void frame(){
		score.frame();
		listbox.frame();
		avatar.frame();
		//avatar2.frame();
	}

	/**
	 * Listens to keyboard events and acts accordingly
	 * 
	 * @param e key pressed
	 */
	public void keyPressed(KeyEvent e) {
		if (State == STATE.MENU){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				menu.setOption(-1);
				break;
			case KeyEvent.VK_DOWN:
				menu.setOption(1);
				break;
			case KeyEvent.VK_ENTER:
				menu.nextState();
			}
		}
		else if (State == STATE.GAME){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
//				avatar2.setVelX(2);
				avatar.setVelX(-2);
				break;
			case KeyEvent.VK_RIGHT:
				avatar.setVelX(2);
				break;
			}
		}
		else if (State == STATE.HIGHSCORE){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				State = STATE.MENU;
				break;
			}
		}
		else if (State == STATE.NEWHIGHSCORE){
			highscores.wirteNickname(e);
		}
		else if (State == STATE.INSTRUCTIONS){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				State = STATE.MENU;
				break;
			}
		}
	}

	/**
	 * Listens to keyboard events and acts accordingly
	 * 
	 * @param e key released
	 */
	public void keyReleased(KeyEvent e) {
		if (State == STATE.GAME){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				avatar.setVelX(0);
				break;
			case KeyEvent.VK_RIGHT:
				avatar.setVelX(0);
				break;
			}
		}

	}
	
	public void keyTyped(KeyEvent arg0) {}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e){
		frame++;
		repaint();
	}
	
	/**
	 * Resets variables to their original value once the user loses the game
	 */
	public void resetvariaveis() {
		//avatar reset
		getAvatar().setX(0);
		getAvatar().setY(475);	
		//list of box all empty
		while (getListbox().getlbox().size() > 0){
			int i = 0;
			getListbox().getlbox().remove(getListbox().getlbox().get(i));
		}		
		for (int i = 0; i < getListbox().getFloor().length; i++)
			getListbox().getFloor()[i] = 0;
		getListbox().setBox(0);
		getListbox().setCont(0);
		getListbox().setnBox(1);
		//list of gifts/points all empty
		while (getScore().getListpoint().size() > 0){
			int i = 0;
			getScore().getListpoint().remove(getScore().getListpoint().get(i));
		}		
		getScore().setScore(0);
		getScore().setNewscorepoint(0);
	}	

	/**
	 * 
	 * @return user controlled sprite
	 */
	public Avatar getAvatar() {
		return avatar;
	}

	/**
	 * 
	 * @return other resources
	 */
	public LoadFiles getLoadFiles() {
		return loadfiles;
	}

	/**
	 * 
	 * @return list of obstacles
	 */
	public ListBox getListbox() {
		return listbox;
	}

	/**
	 * 
	 * @return list of high scores
	 */
	public HighScores getHighscores() {
		return highscores;
	}

	/**
	 * 
	 * @return user score as game progresses
	 */
	public Score getScore() {
		return score;
	}

	/**
	 * 
	 * @return number of frames passed
	 */
	public int getFrame() {
		return frame;
	}
} 