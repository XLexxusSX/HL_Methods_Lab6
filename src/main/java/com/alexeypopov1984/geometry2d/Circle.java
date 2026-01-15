package com.alexeypopov1984.geometry2d;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class Circle implements Figure {
    private final double radius;
    private double x, y;
    private Color color;

    public Circle(double radius, double x, double y, Color color) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public boolean contains(double mouseX, double mouseY) {
        double distance = Math.sqrt(Math.pow(mouseX - x, 2) + Math.pow(mouseY - y, 2));
        return distance <= radius;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}