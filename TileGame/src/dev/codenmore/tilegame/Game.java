package dev.codenmore.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.State;

public class Game implements Runnable {

	private Display display;	
	public int width, height;
	
	private Thread thread;
	private boolean running = false;
	public String title;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	
	
	private KeyManager keyManager;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		
	}

	private void init(){		
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
	
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
		
	}

	
	
	private void tick(){
		keyManager.tick();
		
		if(State.getState() !=null){
			State.getState().tick();
		}
	
	}
	
	private void render(){
		
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
		if(State.getState() !=null){
			State.getState().render(g);
		}
	
	
		
		
		bs.show();
		g.dispose();
		
		
	}
	

	@Override
	public void run() {		
		init();
		
		int fps = 60;
		
		//bcoz 1 billion nano secs in 1 second		
		double timePerTick  = 1000000000/fps;
		double delta = 0;
		
		long now;
		long lastTime = System.nanoTime();
		long timer =0;
		int ticks = 0;
		
		
		
		while(running){
			now = System.nanoTime();
			delta +=(now - lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >=1){
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000){
				System.out.println(ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running) return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
