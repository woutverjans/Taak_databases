package be.kuleuven.dbproject;

import be.kuleuven.dbproject.controllers.MyController;
import be.kuleuven.dbproject.models.ConnectionManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

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
        scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        ConnectionManager.createDb();
        System.out.println("database aangemaakt");
        launch();
    }

    public static void terugNaarStart() throws IOException {
        FXMLLoader loader = new FXMLLoader(Application.class.getResource("start-menu.fxml"));
        Parent root = loader.load();
        scene.setRoot(root);
    }
}