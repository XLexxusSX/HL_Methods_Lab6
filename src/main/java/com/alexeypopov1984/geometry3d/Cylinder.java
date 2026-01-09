package com.alexeypopov1984.geometry3d;

import com.alexeypopov1984.geometry2d.Figure;
import com.alexeypopov1984.exceptions.InvalidWidthOrLengthException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Scanner;

public class Cylinder implements Figure {
    private double radius;
    private double x, y;
    private Color color;
    private double vysota;
    private String inputVysota, inputRadius;
    private Scanner scannerTask_6 = new Scanner(System.in);

    public Cylinder() throws InvalidWidthOrLengthException {

        do {
            System.out.print("Vvedite vysotu tsilindra ili \"q\" dlya vyhoda: ");
            inputVysota = scannerTask_6.nextLine();
            if (inputVysota.equalsIgnoreCase("q")) {
                break;
            } else {
                try {
                    vysota = Double.parseDouble(inputVysota);
                    if (vysota <= 0) {
                        throw new InvalidWidthOrLengthException("Vysota dolzhna byt' > 0");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("\nNeverniy vvod, povtorite. ");
                }
            }
        } while (true);

        do {
            System.out.print("Vvedite radius osnovaniya tsilindra ili \"q\" dlya vyhoda: ");
            inputRadius = scannerTask_6.nextLine();
            if (inputRadius.equalsIgnoreCase("q")) {
                break;
            } else {
                try {
                    radius = Double.parseDouble(inputRadius);
                    if (radius <= 0) {
                        throw new InvalidWidthOrLengthException("Radius dolzhen byt' > 0");
                    } else {
                        System.out.print("\nDlina okruzhnosti osnovaniya tsilindra: " + (double) Math.round(perimeter() * 1000) / 1000);
                        System.out.print("\nPloschad' osnovaniya tsilindra: " + (double) Math.round(area() * 1000) / 1000);
                        System.out.print("\nOb'em tsilindra: " + (double) Math.round(vysota * area() * 1000) / 1000 + "\n");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("\nNeverniy vvod, povtorite. ");
                }
            }
        } while (true);
    }


    public double getX() {
        return x;
    }


    public void setX(double x) {
        this.x = x;
    }


    public double getY() {
        return y;
    }


    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }


    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return "Osnovanie tsilindra: " + toString() + "\nVysota tsilindra: " + vysota;
    }


}