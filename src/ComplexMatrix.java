public class ComplexMatrix {
    private int row;
    private int column;
    private ComplexNumber[][] matrix;

    public ComplexMatrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.matrix = new ComplexNumber[row][column];
    }

    public void set(int row, int column, ComplexNumber val) {
        matrix[row][column] = val;
    }

    public ComplexNumber get(int row, int column) {
        return matrix[row][column];
    }

    public ComplexMatrix addition(ComplexMatrix other) {
        if (row != other.row || column != other.column) {
            throw new RuntimeException("The matrices have different dimensions");
        }
        ComplexMatrix res = new ComplexMatrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                res.set(i, j, get(i, j).addition(other.get(i, j)));
            }
        }
        return res;
    }

    public ComplexMatrix division(ComplexMatrix other) {
        if (other.row != other.column) {
            throw new ArithmeticException("It cannot be divided into non-square matrix");
        }
        ComplexMatrix inv = other.inverse();
        return multiplication(inv);
    }

    private ComplexMatrix inverse() {
        ComplexMatrix ad = adjunct();
        ComplexNumber det = determinant();
        ComplexNumber mutually = new ComplexNumber(1, 0).division(determinant());

        ComplexMatrix inv = new ComplexMatrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                inv.set(i, j, ad.get(i, j).multiplication(mutually));
            }
        }
        return inv;
    }

    private ComplexMatrix adjunct() {
        ComplexMatrix ad = new ComplexMatrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                ComplexMatrix min = getMinor(i, j);
                ComplexNumber mult = min.determinant().multiplication(new ComplexNumber((i + j) % 2 == 0 ? 1 : -1, 0));
                ad.set(j, i, mult);
            }
        }
        return ad;
    }

    public ComplexMatrix subtraction(ComplexMatrix other) {
        if (row != other.row || column != other.column) {
            throw new RuntimeException("The matrices have different dimensions");
        }
        ComplexMatrix res = new ComplexMatrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                res.set(i, j, get(i, j).subtraction(other.get(i, j)));
            }
        }
        return res;
    }

    public ComplexMatrix multiplication(ComplexMatrix other) {
        if (column != other.row) {
            throw new RuntimeException("The matrices dimensions don't match for multiplication");
        }
        ComplexMatrix res = new ComplexMatrix(row, other.column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < other.column; j++) {
                ComplexNumber summa = new ComplexNumber(0, 0);
                for (int k = 0; k < column; k++) {
                    summa = summa.addition(get(i, k).multiplication(other.get(k, j)));
                }
                res.set(i, j, summa);
            }
        }
        return res;
    }

    public ComplexNumber determinant() {
        if (row != column) {
            throw new RuntimeException("The matrix isn't square");
        }
        if (row == 1) {
            return get(0, 0);
        }
        ComplexNumber det = new ComplexNumber(0, 0);
        for (int i = 0; i < column; i++) {
            ComplexMatrix min = getMinor(0, i);
            det = det.addition(get(0, i).multiplication(min.determinant()).multiplication(new ComplexNumber((i % 2 == 0) ? 1 : -1, 0)));
        }
        return det;
    }

    private ComplexMatrix getMinor(int r, int c) {
        int minor_rows = 0;
        int minor_columns = 0;
        for (int i = 0; i < row; i++) {
            if (i == r) continue;
            minor_rows++;
        }
        for (int j = 0; j < column; j++) {
            if (j == c) continue;
            minor_columns++;
        }
        ComplexMatrix minor = new ComplexMatrix(minor_rows, minor_columns);
        int minor_row = 0;
        for (int i = 0; i < row; i++) {
            if (i == r) continue;
            int minor_column = 0;
            for (int j = 0; j < column; j++) {
                if (j == c) continue;
                minor.set(minor_row, minor_column, get(i, j));
                minor_column++;
            }
            minor_row++;
        }
        return minor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sb.append(get(i, j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
