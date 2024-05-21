package be.kuleuven.dbproject;

import be.kuleuven.dbproject.controllers.MyController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private static Scene scene;
    public static void setScene(String fxmlfile, int width, int height, MyController controller, Object data) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(fxmlfile));
        fxmlLoader.setController(controller);
        controller.setData(data);
        Parent root = fxmlLoader.load();
        scene.setRoot(root);
        scene.getWindow().setWidth(width);
        scene.getWindow().setHeight(height);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("start-menu.fxml"));
        scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}