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

	@Override
	public void create () {

         inputListener = new InputListener();

	    welcomScreen = new WelcomScreen(this);
	    startScreen = new StartScreen(this);
         loadScreen = new LoadScreen(this);
         //设置初始Screen
	    setScreen(welcomScreen);
	}

    /**
     * 设置输入监听
     */
    public void getInputlistener(){
        Gdx.input.setInputProcessor(inputListener);
    }
}
