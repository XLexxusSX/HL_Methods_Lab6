package com.alexeypopov1984;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;
import javafx.scene.canvas.Canvas;

public class Window2d3dFigures extends Application {
    private Canvas canvas = new Canvas(600, 400);

    @Override
    public void start(Stage stage) {
        Button circleButton = new Button("Нарисовать круг");
        circleButton.setOnAction(e -> drawCircle("circle"));

        VBox root = new VBox();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void drawCircle(String type) {

        Random rand = new Random();
        double x = rand.nextDouble() * (canvas.getWidth() - 100);
        double y = rand.nextDouble() * (canvas.getHeight() - 100);
    }
}
