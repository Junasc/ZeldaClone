package com.juliana.entities;

import java.awt.image.BufferedImage;

public class Player extends Entity {

	public boolean right , left ,up , down ;
	
	public double speed = 0.5; 
	
	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
	}
	
	public void tick () {
		
		if(right)
		 x+=4 ;
		else if (left)
			x-=4;
		if(up)
			y-=4;
		else if(down)
			y+=4;
	}
	
}
