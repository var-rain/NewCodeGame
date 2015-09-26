package newcode.game.ohtworld;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * 项目名称: Game.
 * 项目所属: NewCode.
 * 创 建 人: Var "雨中行".
 * 创建时间: 2015/9/25 16:55.
 * 类 描 述: Screen的管理器
 */
public class MainGame extends Game {

    public static AssetManager manager;
    private InputListener inputListener;
    private boolean result;
    private boolean diagnosed = false;

    public WelcomScreen welcomScreen;
    public StartScreen startScreen;
    public LoadScreen loadScreen;
    public AboutScreen aboutScreen;

	@Override
	public void create () {

         inputListener = new InputListener();
         manager = new AssetManager();
         result = manager.update();
         if (result &! diagnosed){
             diagnosed = true;
             load();
             diagnosed = false;
         }

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
    public void getInputlistener() {
        Gdx.input.setInputProcessor(inputListener);
    }

    /**
     * 资源加载
     */
    public void load(){
        //将资源添加到预加载列表
        manager.load("image/load.plist", TextureAtlas.class);
        manager.load("image/load.png",Texture.class);
        manager.load("fonts/loading.fnt", BitmapFont.class);
        manager.load("fonts/loading.png", Texture.class);
        manager.finishLoading();
    }

    /**
     * 资源释放
     */
    public void unload(){
        manager.unload("image/load.plist");
        manager.unload("image/load.png");
        manager.unload("fonts/loading.fnt");
        manager.unload("fonts/loading.png");
        manager.clear();
    }
}
