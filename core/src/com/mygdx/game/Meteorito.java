package com.mygdx.game;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Meteorito implements Elemento {
	private Rectangle hitRock;
	protected Texture rocaDibujo;
	protected Sound rocaSonido;
	private float velocidadX;
	private float velocidadY;
	private int direccion;

public Meteorito() {
	hitRock = new Rectangle();
	hitRock.x = MathUtils.random(0, 800-64);
	hitRock.y = 480;
	hitRock.width = 64;
	hitRock.height = 64;
    velocidadX = 300 * Gdx.graphics.getDeltaTime();
    velocidadY = 300 * Gdx.graphics.getDeltaTime();
    rocaDibujo = new Texture(Gdx.files.internal("VidaLluviasprite.png"));
    rocaSonido = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
    
    Random random = new Random();
    boolean esUno = random.nextBoolean();
    if(esUno) {
    	direccion = 1;
    }
    else {
    	direccion = -1;
    }
}

	public boolean choca(Tarro tarro) {
		if(hitRock.overlaps(tarro.getArea())) {
			tarro.explosion();
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean movimiento() {
		
		setY(hitRock.y - getVelocidadY());
		setX(hitRock.x - getVelocidadX()*direccion);
		if(getY() + 64 < 0) {
	  	  return false;
	    }
		else {
			return true;
		}
		
	}
	
	public float getVelocidadY() {
		velocidadY = 400 * Gdx.graphics.getDeltaTime();
		return velocidadY;
	}
	public float getVelocidadX() {
		velocidadX = 50 * Gdx.graphics.getDeltaTime();
		return velocidadX;
	}
	
	public float getY() {
		return hitRock.y;
	}
	public void setY(float actualizar) {
		hitRock.y = actualizar;
	}
	
	public float getX() {
		return hitRock.x;
	}
	public void setX(float actualizar) {
		hitRock.x = actualizar;
	}
	
	public Rectangle getRectangle() {
		return hitRock;
	}
	
	public void dispose() {
		rocaSonido.dispose();
	}
	
	
	public Sound getSound() {
		return rocaSonido;
	}
	
	public Texture getTextura() {
		return rocaDibujo;
	}
	
	public void dibujar(SpriteBatch batch) {
		batch.draw(getTextura(), getX(), getY());
	}




}