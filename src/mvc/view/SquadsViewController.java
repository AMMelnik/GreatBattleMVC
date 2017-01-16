package mvc.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mvc.Main;

/**
 * Created by pc on 15.01.2017.
 */
public class SquadsViewController {

    @FXML
    private TextField firstSquadName;
    @FXML
    private TextField secondSquadName;
    @FXML
    private Label squadInfo;
    @FXML
    private Button next;

    private Main main;

    public SquadsViewController() {
    }

    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        firstSquadName.setText("Альфа");
        secondSquadName.setText("Дельта");
        squadInfo.setText("");
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void clickNextButton() {
        main.showWarriorsWindow();
    }
}
