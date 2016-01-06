package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;

public abstract class Creature extends Entity{

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	
	
	protected  int health;
	protected float speed;
	protected float xMove, yMove;
	
	
	public Creature(Handler handler,float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove =0;
		yMove = 0;
	}

	public void move(){
		x += xMove;
		y += yMove;
	}
	
	
	
	
	
	
	
	
	
	protected float getxMove() {
		return xMove;
	}

	protected void setxMove(float xMove) {
		this.xMove = xMove;
	}

	protected float getyMove() {
		return yMove;
	}

	protected void setyMove(float yMove) {
		this.yMove = yMove;
	}

	protected int getHealth() {
		return health;
	}

	protected void setHealth(int health) {
		this.health = health;
	}

	protected float getSpeed() {
		return speed;
	}

	protected void setSpeed(float speed) {
		this.speed = speed;
	}

	
	
	

	

}
