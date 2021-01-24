package com.juliana.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.juliana.main.Game;

public class Player extends Entity {

	public boolean right , left ,up , down ;
	public double speed = 0.2; 
	
	
	public int turned_right = 0 , turned_left = 1, turned_up = 2,  turned_down = 3;
	public int turned = turned_right ;
	public boolean moved = false ; 
	
	private int frames = 0 , maxFrames = 6 , index = 0 , maxIndex = 3 ; 
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
	private BufferedImage[] upPlayer;
	private BufferedImage[] downPlayer;
	
	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		rightPlayer = new BufferedImage[4];
		leftPlayer = new BufferedImage[4];
		upPlayer = new BufferedImage[4];
		downPlayer = new BufferedImage[4];
		
		
		for(int i = 0; i < 4  ; i++ ) {
		rightPlayer[i] = Game.spritesheet.getSprite(32 + (i *16), 0 , 16, 16);
		}
		for(int i = 0; i < 4 ; i++) {
		leftPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 16, 16, 16);
		}
		for(int i = 0; i < 4 ; i++ ) {
			upPlayer[i] = Game.spritesheet.getSprite(32 + (i *16), 48 , 16, 16);
		}
		for(int i = 0; i < 4 ; i++ ) {
			downPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16 ), 32 , 16 , 16);
		}
	}
	
	public void tick () {
		moved =  false; 
		
		if(right) {
			moved = true;
			turned = turned_right;
		 x+=2 ;
		}
		
		else if (left) {
			moved = true;
			turned = turned_left;
			x-=2;
		}
		
		if(up) {
			moved = true;
			turned = turned_up;
			y-=2;
		}
		else if(down) {
			moved = true;
			turned = turned_down;
			y+=2;
		}
		
		if(moved) {
			frames++;
			if( frames == maxFrames) {
				frames=0;
				index++;
				if(index > maxIndex ) 
					index = 0;
				
			}
		}
	}
	
	public void render(Graphics g) {
		if(turned == turned_right) {
		g.drawImage(rightPlayer[index], this.getX(), this.getY(), null);
		}
		else if(turned == turned_left) {
			g.drawImage(leftPlayer[index], this.getX(), this.getY(), null);
		}
		if(turned == turned_up) {
			g.drawImage(upPlayer[index], this.getX(), this.getY(), null);
		}
		else if(turned == turned_down) {
			g.drawImage(downPlayer[index], this.getX(), this.getY() , null);
		}
	}	
		
}
