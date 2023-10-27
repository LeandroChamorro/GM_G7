package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class GotaAzul extends Gota{
	
	
	public GotaAzul() {
		super();
		gotaDibujo = new Texture(Gdx.files.internal("drop.png"));
		dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
	}
	
	
	protected void efecto(Tarro tarro) {
		tarro.sumarPuntos(10);
        getSound().play();
	}
	
}
