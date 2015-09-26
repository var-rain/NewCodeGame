package newcode.game.ohtworld;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * 项目名称: Game.
 * 项目所属: NewCode.
 * 创 建 人: Var "雨中行".
 * 创建时间: 2015/9/27 0:54.
 * 类 描 述: 监听输入事件的类
 */
public class InputListener implements InputProcessor {

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.BACK){
            System.out.println("Back is Down...");
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
