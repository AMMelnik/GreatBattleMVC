package mvc.view;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mvc.Main;

/**
 * Created by pc on 16.01.2017.
 */
public class BattleViewController {

    @FXML
    TextField battleInfoText;

    private Main main;

    public BattleViewController() {
    }

    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        battleInfoText.setText("Да свершится Великая Битва!");
        battleInfoText.setAlignment(Pos.TOP_CENTER);
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
