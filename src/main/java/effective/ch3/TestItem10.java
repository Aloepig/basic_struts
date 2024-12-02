package effective.ch3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Objects;

public class TestItem10 {

    @Test
    @DisplayName("상속한 클래스와 상위 클래스를 비교시 대칭성 위배")
    public void item10Test() {
        Point point = new Point(10, 20);
        ColorPoint colorPoint = new ColorPoint(10, 20, Color.BLACK);
        ColorPoint colorPoint2 = new ColorPoint(10, 20, Color.RED);

        Assertions.assertTrue(point.equals(colorPoint));
        Assertions.assertTrue(colorPoint.equals(point));
        Assertions.assertTrue(colorPoint2.equals(colorPoint));
    }

    @Test
    @DisplayName("기존클래스에 값 추가하고 equals 를 재정의 한 예시")
    public void item10NewTest() {
        NewColorPoint newColorPoint1 = new NewColorPoint(Color.BLACK,10, 20 );
        NewColorPoint newColorPoint2 = new NewColorPoint(Color.BLACK,10, 20 );

        Assertions.assertTrue(newColorPoint1.equals(newColorPoint2));
        Assertions.assertTrue(newColorPoint2.equals(newColorPoint1));
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class ColorPoint extends Point {

        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ColorPoint)) return false;
            if (!super.equals(o)) return false;
            ColorPoint that = (ColorPoint) o;
            return Objects.equals(color, that.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), color);
        }
    }

    // 상속대신 멤버로
    static class NewColorPoint {
        private final Color color;
        private final Point point;

        public NewColorPoint(Color color, int x, int y) {
            this.color = Objects.requireNonNull(color);
            this.point = new Point(x,y);
        }

        public Point getPoint() {
            return point;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof NewColorPoint)) return false;
            NewColorPoint that = (NewColorPoint) o;
            return Objects.equals(color, that.color) && Objects.equals(point, that.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(color, point);
        }
    }

}
