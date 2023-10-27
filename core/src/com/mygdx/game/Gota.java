package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public abstract class Gota implements Elemento {
	private Rectangle raindrop;
	protected Texture gotaDibujo;
	protected Sound dropSound;
	private float velocidad;

public Gota() {
	 raindrop = new Rectangle();
    raindrop.x = MathUtils.random(0, 800-64);
    raindrop.y = 480;
    raindrop.width = 64;
    raindrop.height = 64;
    velocidad = 300 * Gdx.graphics.getDeltaTime();
}

	public boolean choca(Tarro tarro) {
		if(raindrop.overlaps(tarro.getArea())) {
			efecto(tarro);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean movimiento() {
		setY(raindrop.y - getVelocidad());
		if(getY() + 64 < 0) {
	  	  return false;
	    }
		else {
			return true;
		}
	}
	
	public float getVelocidad() {
		velocidad = 300 * Gdx.graphics.getDeltaTime();
		return velocidad;
	}
	
	public float getY() {
		return raindrop.y;
	}
	public void setY(float actualizar) {
		raindrop.y = actualizar;
	}
	
	public float getX() {
		return raindrop.x;
	}
	public void setX(float actualizar) {
		raindrop.x = actualizar;
	}
	
	public Rectangle getRectangle() {
		return raindrop;
	}
	
	public void dispose() {
		dropSound.dispose();
	}
	
	protected abstract void efecto(Tarro tarro);
	
	public Sound getSound() {
		return dropSound;
	}
	
	public Texture getTextura() {
		return gotaDibujo;
	}
	
	public void dibujar(SpriteBatch batch) {
		batch.draw(getTextura(), getX(), getY());
	}




}