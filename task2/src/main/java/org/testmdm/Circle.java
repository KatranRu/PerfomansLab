package org.testmdm;

public class Circle {
    Coordinate coordinate;
    Double radius;

    public Circle() {
    }

    public Circle(Coordinate coordinate, Double radius) {
        this.coordinate = coordinate;
        this.radius = radius;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
