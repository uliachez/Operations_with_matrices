public class ComplexNumber {
    private double real_part;
    private double imaginary_part;

    public ComplexNumber(double real_part, double imaginary_part) {
        this.real_part = real_part;
        this.imaginary_part = imaginary_part;
    }

    public ComplexNumber addition(ComplexNumber other) {
        return new ComplexNumber(real_part + other.real_part, imaginary_part + other.imaginary_part);
    }

    public ComplexNumber subtraction(ComplexNumber other) {
        return new ComplexNumber(real_part - other.real_part, imaginary_part - other.imaginary_part);
    }

    public ComplexNumber multiplication(ComplexNumber other) {
        double realPart = real_part * other.real_part - imaginary_part * other.imaginary_part;
        double imaginaryPart = real_part * other.imaginary_part + imaginary_part * other.real_part;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber division(ComplexNumber other) {
        double znamenatel = other.real_part * other.real_part + other.imaginary_part * other.imaginary_part;
        double realPart = (real_part * other.real_part + imaginary_part * other.imaginary_part) / znamenatel;
        double imaginaryPart = (imaginary_part * other.real_part - real_part * other.imaginary_part) / znamenatel;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public String toString() {
        return String.format("%.2f + %.2fi", real_part, imaginary_part);
    }
}
