package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class GotaRoja extends Gota{
	
	public GotaRoja() {
		super();
		gotaDibujo = new Texture(Gdx.files.internal("dropBad.png"));
		dropSound = Gdx.audio.newSound(Gdx.files.internal("hurt.ogg"));
	}
	
	//@override
	protected void efecto(Tarro tarro) {
		tarro.dañar();
		getSound().play();
	}
}
