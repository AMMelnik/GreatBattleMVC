package mvc.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mvc.Main;

/**
 * Created by pc on 16.01.2017.
 */
public class WarriorsViewController {

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

    private Main main;

    public WarriorsViewController() {
    }

    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        warriorNameInFirstSquad.setText("Victor");
        warriorNameInSecondSquad.setText("Bill");
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void clickGoBattleButton() {
        main.showBattleWindow();
    }
}
