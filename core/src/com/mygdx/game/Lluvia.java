package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Lluvia {
	//private Array<Rectangle> rainDropsPos;
	//private Array<Integer> rainDropsType;
    private Array <Elemento> elementos;
	private long lastDropTime;
    //private Texture gotaBuena;
    //private Texture gotaMala;
    //private Sound dropSound;
    private Music rainMusic;
	   
    public Lluvia() {
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
	}
	
	public void crear() {
		elementos = new Array <Elemento> ();
		crearElemento();
	    rainMusic.setLooping(true);
	    rainMusic.play();
	}
	
	private void crearElemento() {
	    int probabilidad = MathUtils.random(1,10);  
		
	    if (probabilidad < 5) {	 	  
	    	GotaAzul raindrop = new GotaAzul();
	    	elementos.add(raindrop);
	    }
	    if(probabilidad > 7) {
	    	GotaRoja raindrop = new GotaRoja();
	    	elementos.add(raindrop);
	    }	
		if (probabilidad == 6) {
			Meteorito met = new Meteorito(); 
			elementos.add(met);
		}
	      
	      lastDropTime = TimeUtils.nanoTime();
	   }
	
   public boolean actualizarMovimiento(Tarro tarro) {
	   // generar gotas de lluvia 
	   if(TimeUtils.nanoTime() - lastDropTime > 100000000) crearElemento();
	  
	   
	   // revisar si las gotas cayeron al suelo o chocaron con el tarro
	   for (int i=0; i < elementos.size; i++ ) {
		  Elemento elem = elementos.get(i);
		  
		  //cae al suelo y se elimina
	      if(elem.movimiento() == false) {
	    	  elementos.removeIndex(i);
	      }
	      
	      if(elem.choca(tarro)) {
	    	  elementos.removeIndex(i);
	      }
	      
	      if (tarro.getVidas() <= 0) {
	    	  return false; //se queda sin vidas
	      } 
	   }
	   return true;
   }
   
   public void actualizarDibujoLluvia(SpriteBatch batch) { 
	   
	  for (int i=0; i < elementos.size; i++ ) {		  
	      Elemento elem = elementos.get(i);
	      elem.dibujar(batch);
	   }
   }
   public void destruir() {

      for(int i=0; i < elementos.size; i++ ) {
    	  elementos.get(i).dispose();
      }
	  
	  rainMusic.dispose();
   }
   public void pausar() {
	  rainMusic.stop();
   }
   public void continuar() {
	  rainMusic.play();
   }
   
}
