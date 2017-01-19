package mvc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import mvc.model.Battle;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by pc on 16.01.2017.  Changed on 20.01.17
 */
public class BattleController extends ObjController implements Observer {

    @FXML
    TextArea battleInfoText;

    public BattleController() {
        super();
    }

    @FXML
    void initialize() {
        Battle.getInstance().register(this);
        Battle.getInstance().needInfo();
    }

    @Override
    public void update(Observable o, Object msg) {
        String event = (String) msg;
        if (event.equals("The Great Battle is finished")) {
            battleInfoText.setText(Battle.getInstance().showBattleInfo());
        }
    }
}
