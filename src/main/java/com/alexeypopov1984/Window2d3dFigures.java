package com.alexeypopov1984;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import com.alexeypopov1984.geometry2d.Figure;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.alexeypopov1984.geometry2d.Circle;
import javafx.scene.canvas.GraphicsContext;

public class Window2d3dFigures extends Application {

    private final Canvas canvas = new Canvas(500, 500);
    private GraphicsContext gc = canvas.getGraphicsContext2D();
    private final List<Figure> figuresList = new ArrayList<>();

    public void start(Stage stage) {
        Button circleButton = new Button("Нарисовать круг");
        circleButton.setOnAction(e -> drawFigure("Circle"));

        Button rectangleButton = new Button("Нарисовать прямоугольник");
        rectangleButton.setOnAction(e -> drawFigure("Rectangle"));

        HBox buttonBox = new HBox(10, circleButton, canvas);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));

        Scene scene = new Scene(buttonBox, 700, 500);
        stage.setTitle("Геометрические фигуры");
        stage.setScene(scene);
        stage.show();
    }

    private void drawFigure(String type) {
        Figure figure = null;
        Random random = new Random();
        double x = random.nextDouble() * (canvas.getWidth() - 100);
        double y = random.nextDouble() * (canvas.getHeight() - 100);
        Color color = randomColor();

        if ("Circle".equals(type)) {
            double radius = 20 + random.nextDouble() * 50;
            figure = new Circle(radius, x, y, color);
        }

        figuresList.add(figure);
        redrawCanvas();
    }

    private void redrawCanvas() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Figure fig : figuresList) {
            fig.draw(gc);
        }
    }

    private Color randomColor() {
        Random rand = new Random();
        return Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
}
