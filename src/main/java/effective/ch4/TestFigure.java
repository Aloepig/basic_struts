package effective.ch4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestFigure {

    @Test
    @DisplayName("계층화")
    public void figureTest() {

    }
}

abstract class Figure {
    abstract double area();
}

class Circle extends Figure {
    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Figure {
    final double width;
    final double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return height * width;
    }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side,side);
    }

}
