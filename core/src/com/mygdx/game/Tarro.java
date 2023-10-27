package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;


public class Tarro {
	   private Rectangle bucket;
	   private Texture bucketImage;
	  // private Sound sonidoHerido;
	   private int vidas = 3;
	   private int puntos = 0;
	   private int velx = 400;
	   private boolean herido = false;
	   private int tiempoHeridoMax=50;
	   private int tiempoHerido;
	   
	   
	   public Tarro() {
		   bucketImage = new Texture(Gdx.files.internal("bucket.png"));
	   }
	   
		public int getVidas() {
			return vidas;
		}
	
		public int getPuntos() {
			return puntos;
		}
		public Rectangle getArea() {
			return bucket;
		}
		public void sumarPuntos(int pp) {
			puntos+=pp;
		}
		
	
	   public void crear() {
		      bucket = new Rectangle();
		      bucket.x = 800 / 2 - 64 / 2;
		      bucket.y = 20;
		      bucket.width = 64;
		      bucket.height = 64;
	   }
	   
	   public void dañar() {
		  vidas--;
		  herido = true;
		  tiempoHerido=tiempoHeridoMax;
	   }
	   
	   public void dibujar(SpriteBatch batch) {
		 if (!herido)  
		   batch.draw(bucketImage, bucket.x, bucket.y);
		 else {
		   batch.draw(bucketImage, bucket.x, bucket.y+ MathUtils.random(-5,5));
		   tiempoHerido--;
		   if (tiempoHerido<=0) herido = false;
		 }
	   } 
	   
	   
	   public boolean actualizarMovimiento() { 
		   //movimiento desde teclado
		   if(!estaHerido()) {
			   if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) actualizarPosicion("Izquierda");
			   if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) actualizarPosicion("Derecha");
			   // que no se salga de los bordes izq y der
			   if(bucket.x < 0) bucket.x = 0;
			   if(bucket.x > 800 - 64) bucket.x = 800 - 64;
			   return false;
		   }
		   return true;
	   }
	    

	   public void actualizarPosicion(String direccion) {
		   if(direccion.equals("Derecha")) {
			   bucket.x += velx * Gdx.graphics.getDeltaTime();
		   }
		   else {
			   bucket.x -= velx * Gdx.graphics.getDeltaTime();
		   }
		   
	   }
	public void destruir() {
		    bucketImage.dispose();
	   }
	
	public void explosion() {
		vidas = 0;
		herido = true;
		tiempoHerido=tiempoHeridoMax;
		bucketImage = new Texture(Gdx.files.internal("lessPoint.png"));
	}
   public boolean estaHerido() {
	   return herido;
   }

}
