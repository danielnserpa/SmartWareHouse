package com.ncirl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class NewSmartWareHouseApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/com/ncirl/NewSmartWarehouseForm.fxml")));
        Scene scene = new Scene(parent, 800, 600);
        primaryStage.setTitle("Smart WareHouse");
        primaryStage.centerOnScreen();
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}