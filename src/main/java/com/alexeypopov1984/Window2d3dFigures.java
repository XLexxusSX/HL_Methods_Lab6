package com.alexeypopov1984;

import com.alexeypopov1984.geometry2d.Rectangle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
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

    private Canvas canvas = new Canvas(1000, 350);
    private GraphicsContext gc = canvas.getGraphicsContext2D();
    private final List<Figure> figuresList = new ArrayList<>();

    public void start(Stage stage) {
        int shirinaOkna = 1000;
        Button circleButton = new Button("Нарисовать круг");
        circleButton.setOnAction(e -> drawFigure("Circle"));

        Button rectangleButton = new Button("Нарисовать прямоугольник");
        rectangleButton.setOnAction(e -> drawFigure("Rectangle"));

        canvas.setOnMousePressed(e -> {
                if (e.isSecondaryButtonDown()) {
                for (Figure fig : figuresList) {
                    //isInside(fig, e.getX(), e.getY());
                        redrawCanvas();
                        break;
                    }
                }
        });


         HBox hBox = new HBox(20, circleButton, rectangleButton);
         hBox.setAlignment(Pos.CENTER);

         VBox vBox = new VBox(50, canvas, hBox);
         vBox.setAlignment(Pos.BASELINE_CENTER);



 //     hBox.setPadding(new Insets(10));
        vBox.setPadding(new Insets(10));

        Scene scene = new Scene(vBox, shirinaOkna, 500);
        stage.setTitle("Геометрические фигуры");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private void drawFigure(String type) {
        Figure figure = null;
        Random random = new Random();

        double x = random.nextDouble() * (canvas.getWidth());
        double y = random.nextDouble() * (canvas.getHeight());

        Color color = randomColor();

        if ("Circle".equals(type)) {
            double radius = 20 + random.nextDouble() * 70;
            figure = new Circle(radius, x, y, color);
        }

        if ("Rectangle".equals(type)) {
            double width = 20 + random.nextDouble() * 70;
            double height = 20 + random.nextDouble() * 70;
            figure = new Rectangle(width, height, x, y, color);
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
