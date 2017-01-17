package mvc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mvc.model.Battle;

/**
 * Created by pc on 15.01.2017.
 */
public class SquadsController extends ObjController {

    @FXML
    private TextField firstSquadName;
    @FXML
    private TextField secondSquadName;
    @FXML
    private Label squadInfo;

    public SquadsController() {
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
        String firstName = firstSquadName.getText();
        String secondName = secondSquadName.getText();
        if (firstName.equals("") && secondName.equals("")) {
            squadInfo.setText("Необходимо сначала задать имена обоим отрядам!");
        } else {
            Battle.getInstance().createSquads(firstName, secondName);
            super.getMain().showWarriorsWindow();
        }

    }
}
