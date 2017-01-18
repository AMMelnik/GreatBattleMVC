package mvc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import mvc.model.Battle;

/**
 * Created by pc on 16.01.2017.
 */
public class BattleController extends ObjController {

    @FXML
    TextArea battleInfoText;

    public BattleController() {
        super();
    }

    @FXML
    void initialize() {
        battleInfoText.setText(Battle.getInstance().showBattleInfo()); //модель должна оповещать представление об изменении!
    }
}
