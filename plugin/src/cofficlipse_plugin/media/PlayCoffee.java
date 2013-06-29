package cofficlipse_plugin.media;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import javazoom.jl.decoder.JavaLayerException;
import cofficlipse_plugin.media.jlayer.PausablePlayer;

public class PlayCoffee {
	public static PlayCoffee COFFEE3 = new PlayCoffee();
	private static boolean isPlaying = false;
	private boolean isCheckThreadRun = false;
	private PausablePlayer pplayer;
	private URI uri;

	private PlayCoffee() {
		try {
			uri = (Thread.currentThread().getContextClassLoader().getResource("resc/cleanupcut.mp3").toURI());
			pplayer = new PausablePlayer(uri.toURL().openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void letsPlay() {
		if(isPlaying){
			pplayer.pause();
		}else{
			try {
				pplayer.play();
			} catch (JavaLayerException e) {
				e.printStackTrace();
			}
		}
		isPlaying = !isPlaying;
		if(false == isCheckThreadRun){
			Runnable r = new Runnable(){
				@Override
				public void run() {		
					while(true){
						if(pplayer.getPlayerStatus() == PausablePlayer.FINISHED){
							try {
								pplayer = new PausablePlayer(uri.toURL().openStream());
								pplayer.play();
								isPlaying = true;
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}				
			};
			Thread t = new Thread(r);
			t.start();
			isCheckThreadRun = true;
		}
	}
}