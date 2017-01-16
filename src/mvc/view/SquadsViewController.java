package mvc.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mvc.model.Battle;

/**
 * Created by pc on 15.01.2017.
 */
public class SquadsViewController extends ViewController {

    @FXML
    private TextField firstSquadName;
    @FXML
    private TextField secondSquadName;
    @FXML
    private Label squadInfo;
    @FXML
    private Button next;

    public SquadsViewController() {
        super();
    }

    @FXML
    void initialize() {
        firstSquadName.setText("Альфа");
        secondSquadName.setText("Дельта");
        squadInfo.setText("");
    }

    @FXML
    private void clickNextButton() {
        Battle battle = new Battle();
        String firstName = firstSquadName.getText();
        String secondName = secondSquadName.getText();
        if (!firstName.equals("") && !secondName.equals("")) {
            battle.createSquads(firstName, secondName);
            super.getMain().showWarriorsWindow();
        } else squadInfo.setText("Необходимо сначала задать имена обоим отрядам!");
    }
}
