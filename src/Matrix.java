public class Matrix {
    private int cols;
    private int rows;
    private int n; // modulus
    private int[][] elements;

    // Constructor with random numbers
    Matrix(int rows, int cols, int n) {
        this.rows = rows;
        this.cols = cols;
        this.n = n;
        elements = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                elements[i][j] = (int)(Math.random() * (n));
            }
        }
    }

    // Constructor with parameter
    Matrix(int[][] elements, int n) {
        this.rows = elements.length;
        this.cols = elements[0].length;
        this.n = n;
        this.elements = elements;
    }

    // Display matrix
    public void display() {
        for (int[] row : elements) {
            for (int e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    // Operate given operation on two matrices
    public Matrix operate(Matrix other, Operation operation) {
        checkModulo(other);
        checkSize(other);
        int[][] res = new int[this.rows][this.cols];

        // loop over double array
        for(int i = 0; i < this.rows; ++i) { // rows
            for(int j = 0; j < this.cols; ++j) { // columns
                // get elements
                int a = this.elements[i][j];
                int b = other.elements[i][j];
                // do operation
                res[i][j] = operation.doOperation(a, b, this.n);
            }
        }
        return new Matrix(res, this.n);
    }

    // Add two matrices
    public Matrix add(Matrix other) {
        return operate(other, new Addition());
    }

    // Subtract two matrices
    public Matrix subtract(Matrix other) {
        return operate(other, new Subtraction());
    }

    // Multiply two matrices
    public Matrix multiply(Matrix other) {
        return operate(other, new Multiplication());
    }

    // Check modulo
    private void checkModulo(Matrix other) {
        if (this.n != other.n) {
            throw new RuntimeException("Les modulos n des deux matrices ne correspondent pas");
        }
    }

    // Check size
    private void checkSize(Matrix other) {
        // max rows and columns
        int maxRows = Math.max(this.rows, other.rows);
        int maxCols = Math.max(this.cols, other.cols);
        // resize this matrix if needed
        if(this.rows != maxRows || this.cols != maxCols) {
            this.resize(maxRows, maxCols);
        }
        // resize other matrix if needed
        if(other.rows != maxRows || other.cols != maxCols) {
            other.resize(maxRows, maxCols);
        }
    }

    // Resize matrix
    public void resize(int newRows, int newCols) {
        int[][] newElem = new int[newRows][newCols];
        // loop over double array
        for(int i = 0; i < newRows; ++i) {
            for(int j = 0; j < newCols; ++j) {
                // place existing numbers in same spots
                if(i < this.rows && j < this.cols)
                    newElem[i][j] = this.elements[i][j];
                // resize with 0
                else
                    newElem[i][j] = 0;
            }
        }
        // set new values
        this.rows = newRows;
        this.cols = newCols;
        this.elements = newElem;
    }
}
