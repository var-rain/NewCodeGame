package newcode.game.ohtworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * 项目名称: Game.
 * 项目所属: NewCode.
 * 创 建 人: Var "雨中行".
 * 创建时间: 2015/9/27 0:07.
 * 类 描 述: 显示进度条的演员类
 */
public class LoadActor extends Actor {

    private Animation rotate;
    private TextureAtlas atlas;
    private float stateTime;
    private float AnimotionTime = 0.01f;

    /**
     * 构造函数
     */
    public LoadActor(){
        /**
         * 在构造函数中进行初始化
         */
        atlas = new TextureAtlas(Gdx.files.internal("image/load.plist"));
        rotate = new Animation(AnimotionTime,atlas.findRegions("load"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        stateTime += Gdx.graphics.getDeltaTime();
        batch.draw(rotate.getKeyFrame(stateTime, true),Gdx.graphics.getWidth()/2-50,Gdx.graphics.getHeight()/2,100,100);
    }

    /**
     * 销毁资源,防止内存浪费
     */
    @Override
    public void clear() {
        super.clear();
        atlas.dispose();
    }

    /**
     * 设置动画每帧持续时间
     * @param time
     */
    public void setAnimotionTime(Float time){
        this.AnimotionTime = time;
    }
}
