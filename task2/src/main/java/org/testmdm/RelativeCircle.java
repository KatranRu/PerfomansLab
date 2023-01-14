package org.testmdm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RelativeCircle {
    public static void main(String[] args) {
        try {
            Circle circle = readFileInitializationCircle(args[0]);
            if (null == circle) {
                System.out.println("Error initialization circle");
            } else {
                readFileCoordinateDot(args[1], circle);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: empty arguments");
        }
    }

    public static void relativeCircle(Circle circle, Coordinate coordinate) {
        if (Math.sqrt(Math.pow(coordinate.getX() - circle.getCoordinate().getX(), 2)
                + Math.pow(coordinate.getY() - circle.getCoordinate().getY(), 2)) == circle.getRadius()) {
            System.out.println("0");
        }
        if (Math.sqrt(Math.pow(coordinate.getX() - circle.getCoordinate().getX(), 2)
                + Math.pow(coordinate.getY() - circle.getCoordinate().getY(), 2)) < circle.getRadius()) {
            System.out.println("1");
        }
        if (Math.sqrt(Math.pow(coordinate.getX() - circle.getCoordinate().getX(), 2)
                + Math.pow(coordinate.getY() - circle.getCoordinate().getY(), 2)) > circle.getRadius()) {
            System.out.println("2");
        }
    }

    public static void readFileCoordinateDot(String str, Circle circle) {
        int count = 0;
        BufferedReader rer;
        try {
            if (null == str) {
                System.out.println("Error reading file");
            } else {
                rer = new BufferedReader(new FileReader(str));
                try {
                    String buf;
                    while ((buf = rer.readLine()) != null) {
                        Coordinate dot = initCoordinates(buf);
                        if (null == dot) {
                            System.out.println("Incorrect coordinates");
                        } else {
                            relativeCircle(circle, dot);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file");
                }
                try {
                    rer.close();
                } catch (IOException e) {
                    System.out.println("Error closing file");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File open error");
        }
    }

    public static Circle readFileInitializationCircle(String str) {
        Circle circle = new Circle();
        if (null == str) {
            return null;
        }
        BufferedReader rer;
        try {
            rer = new BufferedReader(new FileReader(str));
            try {
                circle.setCoordinate(initCoordinates(rer.readLine()));
                circle.setRadius(initRadius(rer.readLine()));
            } catch (IOException e) {
                System.out.println("Error reading file");
            }
            try {
                rer.close();
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File open error");
        }
        if (null == circle.getCoordinate() || null == circle.getRadius()) {
            System.out.println("Incorrect circle");
            circle = null;
        }
        return circle;
    }

    public static Double initRadius(String str) {
        Double result;
        try {
            result = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            result = null;
            System.out.println("Error parse radius to integer");
        }
        return result;
    }

    public static Coordinate initCoordinates(String str) {
        String[] mas = str.split(" ");
        Coordinate coordinate = new Coordinate();
        if (2 > mas.length) {
            System.out.println("Missing arguments to initialize coordinates");
            coordinate = null;
        } else {
            try {
                coordinate.setX(Double.parseDouble(mas[0]));
            } catch (NumberFormatException e) {
                coordinate.setX(null);
                System.out.println("First coordinate is not an integer");
            }
            try {
                coordinate.setY(Double.parseDouble(mas[1]));
            } catch (NumberFormatException e) {
                coordinate.setY(null);
                System.out.println("The second coordinate is not an integer");
            }
        }
        if (null == coordinate || null == coordinate.getY() || null == coordinate.getX()) {
            System.out.println("Incorrect coordinates");
            coordinate = null;
        }
        return coordinate;
    }

}