package mvc;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mvc.view.BattleViewController;
import mvc.view.SquadsViewController;
import mvc.view.WarriorsViewController;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("GreatBattle v3.0");
        initRootLayout();
        showSquadsWindow();
    }

    private void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();
            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSquadsWindow() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loaderS = new FXMLLoader();
            loaderS.setLocation(Main.class.getResource("view/SquadsWindow.fxml"));
            AnchorPane squadsWindow = loaderS.load();
            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(squadsWindow);
            // Даём контроллеру доступ к главному приложению.
            SquadsViewController controllerS = loaderS.getController();
            controllerS.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showWarriorsWindow() {
        try {
            FXMLLoader loaderW = new FXMLLoader();
            loaderW.setLocation(Main.class.getResource("view/WarriorsWindow.fxml"));
            AnchorPane warriorsWindow = loaderW.load();
            rootLayout.setCenter(warriorsWindow);
            WarriorsViewController controllerW = loaderW.getController();
            controllerW.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBattleWindow() {
        try {
            FXMLLoader loaderB = new FXMLLoader();
            loaderB.setLocation(Main.class.getResource("view/BattleWindow.fxml"));
            ScrollPane battleWindow = loaderB.load();
            rootLayout.setCenter(battleWindow);
            BattleViewController controllerB = loaderB.getController();
            controllerB.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
