package com.alexeypopov1984.geometry2d;

import java.util.Scanner;
import com.alexeypopov1984.exceptions.InvalidWidthOrLengthException;

public class Rectangle implements Figure {
    private Scanner scannerTask_6 = new Scanner(System.in);
    private double shirina;
    private double dlina;
    private String inputDlina;
    private String inputShirina;

    public Rectangle() throws InvalidWidthOrLengthException {
        boolean dlinaBolsheShiriny = true;
        do {
            System.out.print("Vvedite shirinu pryamougol'nika ili \"q\" dlya vyhoda: ");
            inputShirina = scannerTask_6.nextLine();
            if (inputShirina.equalsIgnoreCase("q")) {
                break;
            } else {
                try {
                    shirina = Double.parseDouble(inputShirina);
                    if (shirina <= 0) {
                        throw new InvalidWidthOrLengthException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("\nNeverniy vvod, povtorite. ");
                }
            }
        } while (true);

        do {
            System.out.print("Vvedite dlinu pryamougol'nika ili \"q\" dlya vyhoda: ");
            inputDlina = scannerTask_6.nextLine();
            if (inputDlina.equalsIgnoreCase("q")) {
                break;
            } else {
                try {
                    dlina = Double.parseDouble(inputDlina);
                    if (dlina <= 0) {
                        throw new InvalidWidthOrLengthException();
                    }

                    if (dlina > shirina) {
                        dlinaBolsheShiriny = true;
                        break;
                    }
                    else {
                        System.out.print("\nDlina dolzhna byt' bol'she shiriny. ");
                        dlinaBolsheShiriny = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("\nNeverniy vvod, povtorite. ");
                }
            }
        } while (true);

        if (dlinaBolsheShiriny) {
            System.out.println("\nPloschad' pryamougol'nika: " + area());
            System.out.println("Perimetr pryamougol'nika: " + perimeter());
            System.out.println(toString());
        }
        else System.out.print("\nDlina dolzhna byt' bol'she shiriny. ");
    }

    @Override
    public double area() {
        return shirina * dlina;
    }

    @Override
    public double perimeter() {
        return 2 * (shirina + dlina);
    }

    @Override
    public String toString() {
        return "Shirina pryamougol'nika: " + shirina + "\nDlina pryamougol'nika: " + dlina;
    }
}