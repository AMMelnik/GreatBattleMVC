package mvc.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mvc.model.Battle;

/**
 * Created by pc on 16.01.2017.
 */
public class WarriorsViewController extends ViewController {

    @FXML
    private Label savedFirstSquadName;
    @FXML
    private Label savedSecondSquadName;
    @FXML
    private TextField warriorNameInFirstSquad;
    @FXML
    private TextField warriorNameInSecondSquad;
    @FXML
    private ComboBox warriorClassInFirstSqaud;
    @FXML
    private ComboBox warriorClassInSecondSqaud;
    @FXML
    private Button addToFirstSquad;
    @FXML
    private Button addnToSecondSquad;
    @FXML
    private Label warriorInFirstSquadInfo;
    @FXML
    private Label warriorInSecondSquadInfo;
    @FXML
    private Button goBattle;

    private Battle battle;

    public WarriorsViewController() {
        super();
    }

    @Override
    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    @FXML
    void initialize() {
        savedFirstSquadName.setText(battle.getFirstSquadName());
        savedSecondSquadName.setText(battle.getSecondSquadName());
        warriorNameInFirstSquad.setText("Victor");
        warriorNameInSecondSquad.setText("Bill");
    }

    @FXML
    private void clickGoBattleButton() {
        super.getMain().showBattleWindow();
    }

    @FXML
    private void clickAddFirstButton() {

    }

    @FXML
    private void clickAddSecondButton() {

    }

}
