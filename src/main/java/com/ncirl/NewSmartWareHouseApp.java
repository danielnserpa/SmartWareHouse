package com.ncirl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class NewSmartWareHouseApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent parent = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/com/ncirl/NewSmartWarehouseForm.fxml")));
        Scene scene = new Scene(parent, 800, 600);
stage.setTitle("New Smart Warehouse");
stage.centerOnScreen();
stage.setScene(scene);
stage.show();
}
}