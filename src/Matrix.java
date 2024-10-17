public class Matrix {
    private int cols;
    private int rows;
    private int n; // modulus
    private int[][] elements;

    // Constructor with random numbers

    // Constructor with parameter

    // Display matrix

    // Operate given operation on two matrices
    public Matrix operate(Matrix other, Operation operation) {
        // Je m'occuperai de cette méthode -Rémy

        // check modulo
        // check max row
        // check max column
        // int[][] res = new int[][];

        /*
        for() { // rows
            for() { // columns
                int a = 0;
                int b = 0;
                res[i][j] = operation.doOperation(a, b, this.n);
            }
        }
        return new Matrix(res, this.n);
        */
        return null;
    }

    // Add two matrices
    public Matrix add(Matrix other) {
        // maybe check dimensions here
        return operate(other, new Addition());
    }

    // Subtract two matrices
    public Matrix subtract(Matrix other) {
        // maybe check dimensions here
        return operate(other, new Subtraction());
    }

    // Multiply two matrices
    public Matrix multiply(Matrix other) {
        // maybe check dimensions here
        return operate(other, new Multiplication());
    }

    // Check modulo

    // Check size

    // Resize matrix


}
