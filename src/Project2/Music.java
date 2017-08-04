package Project2;

import java.applet.AudioClip;
import java.io.*;
import java.applet.Applet;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URL;

public class Music extends Frame {
	static int clickTime = 0;
	AudioClip aau;
	boolean musicOn = false;

	//≤•∑≈±≥æ∞“Ù¿÷
	public Music() {
		super();
		try {
			URL cb;
			File f = new File("LetItGo.wav");
			cb = f.toURL();
			aau = Applet.newAudioClip(cb);
			if (musicOn == true)
				aau.play();
			else
				aau.stop();
			// aau.loop();// —≠ª∑≤•∑≈ aau.play() µ•«˙
			// aau.stop();//Õ£÷π≤•∑≈

			// Music frame = new Music();
			// frame.setBounds(0, 0, 300, 200);
			// frame.setVisible(true);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void sing(boolean musicOn1) {
		this.musicOn = musicOn1;
		if (musicOn == true)
			aau.play();
		else
			aau.stop();
	}
}
