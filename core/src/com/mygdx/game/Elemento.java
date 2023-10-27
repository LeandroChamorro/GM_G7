package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Elemento {
	
	
	public boolean movimiento();
	
	public boolean choca(Tarro tarro);
	
	public void dibujar(SpriteBatch batch);
	
	public void dispose();
}
