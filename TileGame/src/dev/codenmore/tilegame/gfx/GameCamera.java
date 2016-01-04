package dev.codenmore.tilegame.gfx;

public class GameCamera {

	private float xOffset, yOffset;
	
	public GameCamera(float xOffset, float yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	
	public void move(float xAmt, float yAmt){
		xOffset +=xAmt;
		yOffset +=yAmt;
	}
	
	
	protected float getxOffset() {
		return xOffset;
	}

	protected void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	protected float getyOffset() {
		return yOffset;
	}

	protected void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
