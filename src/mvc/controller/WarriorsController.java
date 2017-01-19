package mvc.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import mvc.model.Battle;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by pc on 16.01.2017.  Changed on 20.01.17
 */
public class WarriorsController extends ObjController implements Observer {

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
    @FXML
    Label emptySquadsMsg;

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
        Battle.getInstance().register(this);
    }

    @FXML
    private void clickGoBattleButton() {
        if (Battle.getInstance().getSquadSize(1) == 0 || Battle.getInstance().getSquadSize(2) == 0) {
            emptySquadsMsg.setText("Нужно добавить бойцов в оба отряда!");
        } else {
            Battle.getInstance().startBattle();
            super.getMain().showBattleWindow();
        }
    }

    @FXML
    private void clickAddFirstButton() {
        warriorInFirstSquadInfo.setText("");
        String firstName = warriorNameInFirstSquad.getText();
        if (!firstName.equals("")) {
            Battle.getInstance().addWarriorToSquad(1, firstName, getWarClassName(1));
        } else {
            warriorInFirstSquadInfo.setText("Укажите имя бойца!");
        }
    }

    @FXML
    private void clickAddSecondButton() {
        warriorInSecondSquadInfo.setText("");
        String secondName = warriorNameInSecondSquad.getText();
        if (!secondName.equals("")) {
            Battle.getInstance().addWarriorToSquad(2, secondName, getWarClassName(2));
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

    @Override
    public void update(Observable b, Object msg) {
       /* если неправильно использовать произвольные event
        String warriorName = (String) name;
        if (Battle.getInstance().check(1, warriorName)) {*/

        String event = (String) msg;
        if (event.equals("New warrior added to Squad 1")) {
            firstSquadWarriors.setText(Battle.getInstance().showSquad(1));
        }
        if (event.equals("New warrior added to Squad 2")) {
            secondSquadWarriors.setText(Battle.getInstance().showSquad(2));
        }
    }
}
