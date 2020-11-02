package Ex1.ComplexNumbers;

public interface ComplexAbstractFactory {
    Complex createComplex();

    Complex createComplex(final double real, final double image);
}
