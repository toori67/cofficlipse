package cofficlipse_plugin.media;

import java.net.URI;

import javazoom.jl.decoder.JavaLayerException;
import cofficlipse_plugin.media.jlayer.Audio;
import cofficlipse_plugin.media.jlayer.PausablePlayer;

public class PlayCoffee {
	public static PlayCoffee COFFEE3 = new PlayCoffee();

	private PausablePlayer pplayer;

	private PlayCoffee() {
		try {
			URI uri = (Thread.currentThread().getContextClassLoader().getResource("resc/cleanupcut.mp3").toURI());
//			player = new AdvancedPlayer(uri.toURL().openStream());
			pplayer = new PausablePlayer(uri.toURL().openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void letsPlay() {
		try {
			 Audio.setMasterOutputVolume(0.5f);
			pplayer.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
	public void stopPlay(){
		pplayer.pause();
	}

}
