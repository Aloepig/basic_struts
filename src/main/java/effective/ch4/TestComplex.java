package effective.ch4;

import org.junit.jupiter.api.DisplayName;

import java.util.Objects;

public class TestComplex {

    @DisplayName("불변 복소수 클래스. complex number: a +bi 실수부, 허수부")
    public static final class Complex {
        private final double re;
        private final double im;

        private Complex(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public static Complex of(double re, double im) {
            return new Complex(re, im);
        }

        public double realPart() {
            return re;
        }

        public double imaginaryPart() {
            return im;
        }

        public Complex plus(Complex complex) {
            return new Complex(re + complex.re, im + complex.im);
        }

        public Complex minus(Complex complex) {
            return new Complex(re - complex.re, im - complex.im);
        }

        public Complex times(Complex complex) {
            return new Complex(re * complex.re, im * complex.im);
        }

        public Complex divideBy(Complex complex) {
            double temp = complex.re * complex.re + complex.im * complex.im;
            return new Complex((re * complex.re + im * complex.im / temp), (im * complex.re - re * complex.im / temp));
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true; // 좀더 명확하고 빠르게 하기위한 return.
            if (!(o instanceof Complex)) return false;
            Complex complex = (Complex) o;
            return Double.compare(re, complex.re) == 0 && Double.compare(im, complex.im) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(re, im);
        }

        @Override
        public String toString() {
            return "Complex{" +
                    "re=" + re +
                    ", im=" + im +
                    '}';
        }
    }
}
