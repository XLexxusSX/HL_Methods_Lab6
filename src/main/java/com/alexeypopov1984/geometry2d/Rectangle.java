package com.alexeypopov1984.geometry2d;

//import java.util.Scanner;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import com.alexeypopov1984.exceptions.InvalidWidthOrLengthException;

public class Rectangle implements Figure {
    private double shirina;
    private double vysota;
    private double x, y;
    private Color color;

    public Rectangle(double shirina, double vysota, double x, double y, Color color) {
        this.shirina = shirina;
        this.vysota = vysota;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, shirina, vysota);
    }

    public double area() {
        return shirina * vysota;
    }

    public double perimeter() {
        return 2 * shirina + 2 * vysota;
    }

    @Override
    public String toString() {
        return "Shirina pryamougol'nika: " + shirina + "\nVysota pryamougol'nika: " + vysota;
    }
}