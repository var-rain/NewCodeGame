package newcode.game.ohtworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;


/**
 * 项目名称: Game.
 * 项目所属: NewCode.
 * 创 建 人: Var "雨中行".
 * 创建时间: 2015/9/25 16:56.
 * 类 描 述: 加载资源时显示的正在加载中
 */
public class LoadScreen implements Screen {

    MainGame game;
    private Stage stage;
    private LoadActor loadActor;
    private TextureAtlas atlas;
    private Image image;
    private Label label;
    private Label.LabelStyle style;
    private String labelText = "正在加载中...";

    public LoadScreen(MainGame game){
        this.game = game;
    }

    @Override
    public void show() {

        loadActor = new LoadActor();
        atlas = new TextureAtlas("image/load.plist");
        //设置加载界面的背景图
        image = new Image(atlas.findRegion("loadback"));
        image.setX(0);
        image.setY(0);
        image.setWidth(Gdx.graphics.getWidth());
        image.setHeight(Gdx.graphics.getHeight());
        //设置Label的样式
        style = new Label.LabelStyle(new BitmapFont(Gdx.files.internal("fonts/loading.fnt")), Color.WHITE);
        label = new Label(labelText,style);
        label.setX(Gdx.graphics.getWidth()/2-label.getWidth()/2);
        label.setY(Gdx.graphics.getHeight() / 3);
        //初始化舞台并为舞台添加演员
        stage = new Stage();
        stage.addActor(image);
        stage.addActor(loadActor);
        stage.addActor(label);
}

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0, 0, 0, 0);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void dispose() {
    }

    /**
     * 设置加载时显示的文本
     * @param labelText 传入一个字符串
     */
    public void setLabelText(String labelText){
        this.labelText = labelText;
    }

    /**
     * 设置动画每帧播放的时间(进度条)
     * @param time
     */
    public void setAnimoTime(float time){
        loadActor.setAnimotionTime(time);
    }
}
