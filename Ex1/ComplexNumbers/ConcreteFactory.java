package Ex1.ComplexNumbers;

public class ConcreteFactory {
    public static Complex createComplex() {
        return new Complex(0, 0);
    }

    public static Complex createComplex(final double real, final double image) {
        return new Complex(real, image);
    }
}
