package mvc.controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;


/**
 * Created by pc on 16.01.2017.
 */
public class BattleController extends ObjController {

    @FXML
    TextField battleInfoText;

    public BattleController() {

    }

    @FXML
    void initialize() {
        battleInfoText.setText("Да свершится Великая Битва!");
        battleInfoText.setAlignment(Pos.TOP_CENTER);
    }
}
