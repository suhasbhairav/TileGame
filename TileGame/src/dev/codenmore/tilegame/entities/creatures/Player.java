package dev.codenmore.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;

public class Player extends Creature {

	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 30;
	}

	@Override
	public void tick() {	
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		
		if(handler.getKeyManager().up)	yMove = -speed;
		if(handler.getKeyManager().down)	yMove = speed;
		if(handler.getKeyManager().left)	xMove = -speed;
		if(handler.getKeyManager().right)	xMove = speed;
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffset()), width , height, null);
		
		g.setColor(Color.red);
		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
	
	
	

}
