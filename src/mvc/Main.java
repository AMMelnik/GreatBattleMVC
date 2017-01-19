package mvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mvc.controller.ObjController;
import mvc.controller.WarriorsController;
import mvc.model.Battle;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("GreatBattle v3.0");
        initRootLayout();
        prepareToShow("view/SquadsWindow.fxml");
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void prepareToShow(String pathToFXML) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(pathToFXML));
            AnchorPane window = loader.load();
            rootLayout.setCenter(window);
            ObjController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showWarriorsWindow() {
        prepareToShow("view/WarriorsWindow.fxml");
    }

    public void showBattleWindow() {
        prepareToShow("view/BattleWindow.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
