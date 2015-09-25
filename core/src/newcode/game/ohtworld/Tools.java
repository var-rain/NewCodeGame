package newcode.game.ohtworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * NewCode 创建于 2015/9/22.
 */
public class Tools {

    private int Width;
    private int Height;

    /**
     * Texture横向居中
     * @param texture 纹理对象
     * @return Width 返回横向居中的Width
     */
    public int centerWidth(Texture texture){
//        计算Width
        Width = Gdx.graphics.getWidth()/2-texture.getWidth()/2;
        return Width;
    }

    /**
     * Texture垂直居中
     * @param texture 纹理对象
     * @return Height 返回垂直居中的Height
     */
    public int centerHeight(Texture texture){
//        计算Height
        Height = Gdx.graphics.getHeight()/2-texture.getHeight()/2;
        return Height;
    }
}
