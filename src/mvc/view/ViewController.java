package mvc.view;

import mvc.Main;
import mvc.model.Battle;

/**
 * Created by pc on 16.01.2017.
 */
public abstract class ViewController {

    private Main main;

    public ViewController() {
    }

    public void setMain(Main main) {
        this.main = main;
    }

    Main getMain() {
        return main;
    }

}
