package newcode.game.ohtworld;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

/**
 * 项目名称: Game.
 * 项目所属: NewCode.
 * 创 建 人: Var "雨中行".
 * 创建时间: 2015/9/25 16:55.
 * 类 描 述: Screen的管理器
 */
public class MainGame extends Game {

    private InputListener inputListener;

    public WelcomScreen welcomScreen;
    public StartScreen startScreen;
    public LoadScreen loadScreen;
    public AboutScreen aboutScreen;

	@Override
	public void create () {

         inputListener = new InputListener();

	    welcomScreen = new WelcomScreen(this);
	    startScreen = new StartScreen(this);
         loadScreen = new LoadScreen(this);
         aboutScreen = new AboutScreen(this);
         //设置初始Screen
	    setScreen(welcomScreen);
	}

    /**
     * 监听输入
     */
    public void getInputlistener(){
        Gdx.input.setInputProcessor(inputListener);
    }
}
