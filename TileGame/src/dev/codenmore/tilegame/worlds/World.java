package dev.codenmore.tilegame.worlds;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.tile.Tile;
import dev.codenmore.tilegame.utils.Utils;

public class World  {

	private Game game;
	private int width, height;
	private int spawnx, spawny;
	private int[][] tiles;
	
	
	
	
	public World(Game game, String path){
		this.game = game;
		loadWorld(path);
	}
	
	public void tick(){
		
	}
	public void render(Graphics g){
		for(int y=0;y< height; y++){
			for(int x=0;x<width;x++){
				getTile(x,y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
			}
		}
		
		
		
	}
	
	
	public Tile getTile(int x, int y){
		Tile t  = Tile.tiles[tiles[x][y]];
		if(t == null){
			return Tile.dirtTile;
		}
		return t;
		
		
	}
	
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnx = Utils.parseInt(tokens[2]);
		spawny = Utils.parseInt(tokens[3]);
		
		
		tiles = new int[width][height];
		for(int y=0;y<height;y++){
			for(int x=0;x<width;x++){
				tiles[x][y]= Utils.parseInt(tokens[(x+y*width)+4]);
			}
		}
		
	}
}
