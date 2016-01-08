package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.tile.Tile;

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
		moveX();
		moveY();
	}
	
	
	public void moveX(){
		if(xMove > 0){
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH ;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height)/ Tile.TILEHEIGHT)){
				x += xMove;
			}
		}else if(xMove < 0){
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH ;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height)/ Tile.TILEHEIGHT)){
				x += xMove;
			}
		}
	}
	
	public void moveY(){
		if(yMove < 0){
			int ty = (int) (y + yMove +bounds.y)/ Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x)/ Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width)/ Tile.TILEWIDTH, ty)){
				y += yMove;
			}
		}else if(yMove > 0){
			
	int ty = (int) (y + yMove +bounds.y + bounds.height)/ Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x)/ Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width)/ Tile.TILEWIDTH, ty)){
				y += yMove;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
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
