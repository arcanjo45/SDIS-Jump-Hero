package GUI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadFiles {

	private BufferedImage menu, highscore, enemybox, friendbox, instructions, floor, point1, point3, point5, onlyfloor;
	private BufferedImage[] avatarR = new BufferedImage[4];
	private BufferedImage[] avatarL = new BufferedImage[4];
	private BufferedImage[] avatarRU = new BufferedImage[4];
	private BufferedImage[] avatarLU = new BufferedImage[4];
	private AudioClip backsound, pointsound, boxsound;


	/**
	 * Constructor
	 */
	public LoadFiles() {
		try {
			this.menu = ImageIO.read(this.getClass().getResource("/resources/menu.png"));
			
			this.highscore = ImageIO.read(this.getClass().getResource("/resources/highscore.png"));
			
			this.instructions = ImageIO.read(this.getClass().getResource("/resources/instructions.png"));

			this.avatarR[0] = ImageIO.read(this.getClass().getResource("/resources/avatarR2.png"));
			this.avatarR[1] = ImageIO.read(this.getClass().getResource("/resources/avatarR1.png"));
			this.avatarR[2] = ImageIO.read(this.getClass().getResource("/resources/avatarR2.png"));
			this.avatarR[3] = ImageIO.read(this.getClass().getResource("/resources/avatarR3.png"));

			this.avatarRU[0] = ImageIO.read(this.getClass().getResource("/resources/avatarRU2.png"));
			this.avatarRU[1] = ImageIO.read(this.getClass().getResource("/resources/avatarRU1.png"));
			this.avatarRU[2] = ImageIO.read(this.getClass().getResource("/resources/avatarRU2.png"));
			this.avatarRU[3] = ImageIO.read(this.getClass().getResource("/resources/avatarRU3.png"));

			this.avatarL[0] = ImageIO.read(this.getClass().getResource("/resources/avatarL2.png"));
			this.avatarL[1] = ImageIO.read(this.getClass().getResource("/resources/avatarL1.png"));
			this.avatarL[2] = ImageIO.read(this.getClass().getResource("/resources/avatarL2.png"));
			this.avatarL[3] = ImageIO.read(this.getClass().getResource("/resources/avatarL3.png"));

			this.avatarLU[0] = ImageIO.read(this.getClass().getResource("/resources/avatarLU2.png"));
			this.avatarLU[1] = ImageIO.read(this.getClass().getResource("/resources/avatarLU1.png"));
			this.avatarLU[2] = ImageIO.read(this.getClass().getResource("/resources/avatarLU2.png"));
			this.avatarLU[3] = ImageIO.read(this.getClass().getResource("/resources/avatarLU3.png"));

			this.enemybox = ImageIO.read(this.getClass().getResource("/resources/enemybox.png"));
			this.friendbox = ImageIO.read(this.getClass().getResource("/resources/friendbox.png"));
			this.floor = ImageIO.read(this.getClass().getResource("/resources/floor.png"));	
			this.point1 = ImageIO.read(this.getClass().getResource("/resources/point1.png"));
			this.point3 = ImageIO.read(this.getClass().getResource("/resources/point3.png"));
			this.point5 = ImageIO.read(this.getClass().getResource("/resources/point5.png"));
			this.onlyfloor = ImageIO.read(this.getClass().getResource("/resources/onlyfloor.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.backsound = Applet.newAudioClip(this.getClass().getResource("/resources/backsound.wav"));
		this.pointsound = Applet.newAudioClip(this.getClass().getResource("/resources/pointsound.wav"));
		this.boxsound = Applet.newAudioClip(this.getClass().getResource("/resources/boxsound.wav"));
		
	}


	/**
	 * 
	 * @return menu screen
	 */
	public BufferedImage getMenu() {
		return menu;
	}

	/**
	 * 
	 * @return highscore background
	 */
	public BufferedImage getHighscore() {
		return highscore;
	}
	/**
	 * 
	 * @return instructions background
	 */
	public BufferedImage getInstructions() {
		return instructions;
	}

	/**
	 * 
	 * @return different stages of avatar's walk
	 */
	public BufferedImage[] getAvatarR() {
		return avatarR;
	}
	
	/**
	 * 
	 * @return different stages of avatar's walk
	 */
	public BufferedImage[] getAvatarL() {
		return avatarL;
	}
	
	/**
	 * 
	 * @return different stages of avatar's walk
	 */
	public BufferedImage[] getAvatarRU() {
		return avatarRU;
	}
	
	/**
	 * 
	 * @return different stages of avatar's walk
	 */
	public BufferedImage[] getAvatarLU() {
		return avatarLU;
	}

	/**
	 * 
	 * @return harmful obstacle
	 */
	public BufferedImage getEnemybox() {
		return enemybox;
	}
	
	/**
	 * 
	 * @return harmless obstacle
	 */
	public BufferedImage getFriendbox() {
		return friendbox;
	}
	
	/**
	 * 
	 * @return	background image
	 */
	public BufferedImage getFloor() {
		return floor;
	}
	
	/**
	 * 
	 * @return point1 image
	 */
	public BufferedImage getPoint1() {
		return point1;
	}
	
	/**
	 * 
	 * @return point3 image
	 */
	public BufferedImage getPoint3() {
		return point3;
	}
	
	/**
	 * 
	 * @return point5 image
	 */
	public BufferedImage getPoint5() {
		return point5;
	}
	
	/**
	 * 
	 * @return floor image
	 */
	public BufferedImage getOnlyfloor() {
		return onlyfloor;
	}

	/**
	 * 
	 * @return ambient sound
	 */
	public AudioClip getBacksound() {
		return backsound;
	}
	
	/**
	 * 
	 * @return point collected sound
	 */
	public AudioClip getPointsound() {
		return pointsound;
	}
	
	/**
	 * 
	 * @return obstacle reaches the ground sound
	 */
	public AudioClip getBoxsound() {
		return boxsound;
	}



}
