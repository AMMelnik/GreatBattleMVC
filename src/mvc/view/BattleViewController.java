package mvc.view;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import mvc.model.Battle;


/**
 * Created by pc on 16.01.2017.
 */
public class BattleViewController extends ViewController {

    @FXML
    TextField battleInfoText;

    public BattleViewController() {

    }

    @FXML
    void initialize() {
        battleInfoText.setText("Да свершится Великая Битва!");
        battleInfoText.setAlignment(Pos.TOP_CENTER);
    }
}
