package newcode.game.ohtworld;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MainGame extends Game {

    private Stage stage;
    private Skin skin;
    private Label label;
    public WelcomScreen welcomScreen;
    public StartScreen startScreen;
    public LoadScreen loadScreen;

	@Override
	public void create () {

	    stage = new Stage();
         skin = new Skin(Gdx.files.internal("json/resource.json"));
         label = new Label("FPS:", skin.get("default", Label.LabelStyle.class));
         label.setY(0);
         label.setX(Gdx.graphics.getWidth()-label.getWidth() * 1.6f);
         stage.addActor(label);

	    welcomScreen = new WelcomScreen(this);
	    startScreen = new StartScreen(this);
         loadScreen = new LoadScreen(this);
	    setScreen(welcomScreen);
	}

    /**
	* 获取舞台对象
	* @return 返回舞台对象
	*/
    public Stage getStage(){
	   return this.stage;
    }

    /**
     * 获取显示FPS的label
     * 注:此方法需在render方法中调用
     */
    public void updateFPS(){
        //如果FPS小于40并且大于30时,将label的颜色设置为yellow
        if (Gdx.graphics.getFramesPerSecond() < 40 && Gdx.graphics.getFramesPerSecond() >30 ){
            label.setColor(skin.getColor("yellow"));
        //如果FPS小等于30时,将label的颜色设置为red
        }else if (Gdx.graphics.getFramesPerSecond() <= 30){
            label.setColor(skin.getColor("red"));
        //其他情况下,Label颜色均为green
        }else {
            label.setColor(skin.getColor("green"));
        }
        label.setText("FPS:"+Gdx.graphics.getFramesPerSecond());
    }

    /**
     * 获取Skin对象
     * @return 返回skin
     */
    public Skin getSkin(){
        return this.skin;
    }
}
