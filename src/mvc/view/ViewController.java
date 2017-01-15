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
public class ViewController {

    @FXML
    private TextField firstSquadName;
    @FXML
    private TextField secondSquadName;
    @FXML
    private Label squadInfo;
    @FXML
    private Button next;

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

    @FXML
    private TextField battleInfoText;

    // Ссылка на главное приложение.
    private Main main;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public ViewController() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        firstSquadName.setText("Альфа");
        secondSquadName.setText("Дельта");
        squadInfo.setText("");
        warriorNameInFirstSquad.setText("Victor");
        warriorNameInSecondSquad.setText("Bill");
        
    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;
/*
        // Добавление в таблицу данных из наблюдаемого списка
        personTable.setItems(main.getPersonData());*/
    }
}
