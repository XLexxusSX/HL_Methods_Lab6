package com.alexeypopov1984.geometry2d;

import javafx.scene.paint.Color;

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

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Radius okruzhnosti: " + radius;
    }
}