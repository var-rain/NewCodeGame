package newcode.game.ohtworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * 显示logo的Screen
 * NewCode 创建于 2015/9/22.
 */
public class WelcomScreen implements Screen {

    MainGame game;
    private Texture texture;
    private int TextureWidth;
    private int TextureHeight;
    private Tools tools;
    private Stage stage;
    private Image image;
    private Action endAction;

    public WelcomScreen(MainGame game){
        this.game = game;
    }

    @Override
    public void show() {
        texture = new Texture(Gdx.files.internal("logo.png"));
        tools = new Tools();
        stage = game.getStage();
        image = new Image(texture);
        TextureWidth = tools.centerWidth(texture);
        TextureHeight = tools.centerHeight(texture);
        image.setX(TextureWidth);
        image.setY(TextureHeight);
//        设置动作监听
        endAction = Actions.run(new Runnable() {
            /**
             * 监听动作完成之后
             */
            @Override
            public void run() {
//                设置显示的Screen
                game.setScreen(game.loadScreen);
                System.out.println("This Screen will be Dispose...");
//                销毁此Screen
                dispose();
            }
        });
//        设置渐变动作
        SequenceAction alpha = Actions.sequence(Actions.fadeIn(3),Actions.fadeOut(3), endAction);
//        为演员添加动作
        image.addAction(alpha);
//        为舞台添加演员
        stage.addActor(image);
    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0, 0, 0, 0);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        game.updateFPS();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.texture.dispose();
//        this.stage.dispose();
    }
}
