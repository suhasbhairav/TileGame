package dev.codenmore.tilegame.entities;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;

public abstract class Entity {

	protected Game game;
	protected  float x, y;
	protected int width, height;
	
	public Entity(Game game, float x, float y, int width, int height){
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public float getX() {
		return x;
	}

	protected void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	protected void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	protected void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	protected void setHeight(int height) {
		this.height = height;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	
}
