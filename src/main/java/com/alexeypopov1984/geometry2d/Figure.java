package com.alexeypopov1984.geometry2d;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface Figure {
    double area();
    double perimeter();
    void draw(GraphicsContext gc);
}
