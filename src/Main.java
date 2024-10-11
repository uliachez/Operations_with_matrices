class Main {
    public static void main(String[] args) {
        ComplexMatrix obj1 = new ComplexMatrix(2, 2);
        obj1.set(0,0, new ComplexNumber(1, 2));
        obj1.set(0,1, new ComplexNumber(3, 4));
        obj1.set(1,0, new ComplexNumber(5,6));
        obj1.set(1,1, new ComplexNumber(7,8));

        ComplexMatrix obj2 = new ComplexMatrix(2,2);
        obj2.set(0, 0, new ComplexNumber(8,7));
        obj2.set(0,1, new ComplexNumber(6, 5));
        obj2.set(1,0, new ComplexNumber(4, 3));
        obj2.set(1,1, new ComplexNumber(2, 1));

        ComplexMatrix res = obj1.addition(obj2);
        ComplexMatrix res1 = obj1.subtraction(obj2);
        ComplexMatrix res2 = obj1.multiplication(obj2);
        ComplexNumber det1 = obj1.determinant();
        ComplexNumber det2 = obj2.determinant();
        ComplexMatrix res3 = obj1.division(obj2);

        System.out.println("Matrix №1:");
        System.out.println(obj1.toString());
        System.out.println("Matrix №2:");
        System.out.println(obj2.toString());
        System.out.println("Determinant №1:");
        System.out.println(det1.toString());
        System.out.println();
        System.out.println("Determinant №2:");
        System.out.println(det2.toString());
        System.out.println();
        System.out.println("Result addition:");
        System.out.println(res.toString());
        System.out.println("Result subtraction:");
        System.out.println(res1.toString());
        System.out.println("Result multiplication:");
        System.out.println(res2.toString());
        System.out.println("Result division:");
        System.out.println(res3.toString());
    }
}