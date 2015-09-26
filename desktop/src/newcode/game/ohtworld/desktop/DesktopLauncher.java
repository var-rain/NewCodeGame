package newcode.game.ohtworld.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import newcode.game.ohtworld.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	    	config.width = 600;
	    	config.height = 320;
		new LwjglApplication(new MainGame(), config);
	}
}
