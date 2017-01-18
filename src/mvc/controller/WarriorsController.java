package mvc.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import mvc.model.Battle;

/**
 * Created by pc on 16.01.2017.
 */
public class WarriorsController extends ObjController {

    @FXML
    private Label savedFirstSquadName;
    @FXML
    private Label savedSecondSquadName;
    @FXML
    private TextField warriorNameInFirstSquad;
    @FXML
    private TextField warriorNameInSecondSquad;
    @FXML
    private ComboBox warriorClassInFirstSquad;
    @FXML
    private ComboBox warriorClassInSecondSquad;
    @FXML
    private Label warriorInFirstSquadInfo;
    @FXML
    private Label warriorInSecondSquadInfo;
    @FXML
    TextArea firstSquadWarriors;
    @FXML
    TextArea secondSquadWarriors;

    private ObservableList<String> classes = FXCollections.observableArrayList("Разведчик", "Борец", "Подрывник");

    public WarriorsController() {
        super();
    }

    @FXML
    void initialize() {
        savedFirstSquadName.setText(Battle.getInstance().getFirstSquadName());
        savedSecondSquadName.setText(Battle.getInstance().getSecondSquadName());
        warriorNameInFirstSquad.setText("Victor");
        warriorNameInSecondSquad.setText("Bill");
        warriorClassInFirstSquad.setItems(classes);
        warriorClassInSecondSquad.setItems(classes);
        warriorClassInFirstSquad.setValue(classes.get(0));
        warriorClassInSecondSquad.setValue(classes.get(2));
    }

    @FXML
    private void clickGoBattleButton() {
        Battle.getInstance().startBattle();
        super.getMain().showBattleWindow();
    }

    @FXML
    private void clickAddFirstButton() {
        warriorInFirstSquadInfo.setText("");
        String firstName = warriorNameInFirstSquad.getText();
        if (!firstName.equals("")) {
            Battle.getInstance().addWarriorToSquad1(firstName, getWarClassName(1));
            firstSquadWarriors.setText(Battle.getInstance().showSquad(1));//модель должна оповещать представление об изменении!
            //в данном случае добавление бойца в отряд происходит быстро, но мы могли бы добавить, например, запись на удаленный сервер, добавление не успевало бы завершиться
            //до вызова setText и представление бы ничего не узнало о новом бойце.
        } else {
            warriorInFirstSquadInfo.setText("Укажите имя бойца!");
        }
    }

    @FXML
    private void clickAddSecondButton() {
        warriorInSecondSquadInfo.setText("");
        String secondName = warriorNameInSecondSquad.getText();
        if (!secondName.equals("")) {
            Battle.getInstance().addWarriorToSquad2(secondName, getWarClassName(2));
            secondSquadWarriors.setText(Battle.getInstance().showSquad(2));
        } else {
            warriorInSecondSquadInfo.setText("Укажите имя бойца!");
        }
    }

    private int getWarClassName(int squad) {
        if (squad == 1) {
            return warriorClassInFirstSquad.getSelectionModel().getSelectedIndex();
        } else {
            return warriorClassInSecondSquad.getSelectionModel().getSelectedIndex();
        }
    }
}
