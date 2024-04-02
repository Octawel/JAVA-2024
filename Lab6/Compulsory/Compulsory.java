package Compulsory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Compulsory extends Application {

    @Override
    public void start(Stage primaryStage) {
        ConfigPanel configPanel = new ConfigPanel();
        ControlPanel controlPanel = new ControlPanel();
        GameBoard gameBoard = new GameBoard(configPanel);

        BorderPane root = new BorderPane();
        root.setTop(configPanel);
        root.setCenter(gameBoard);
        root.setBottom(controlPanel);

        Scene scene = new Scene(root, 900, 900);
        primaryStage.setTitle("Grid Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
