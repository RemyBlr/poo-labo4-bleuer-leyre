public class Matrix {
    private int cols;
    private int rows;
    private int n; // modulus
    private int[][] elements;

    // Constructor with random numbers
    Matrix(int rows, int cols, int n) {
        if (rows < 0 || cols < 0 || n <= 0) {
            throw new RuntimeException("Invalid matrix arguments");
        }
        if ((rows == 0 && cols > 0) || (cols == 0 && rows > 0)) {
            throw new RuntimeException("Invalid matrix arguments");
        }
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
        if (n <= 0 || !ERangeCheck(elements, n)) {
            throw new RuntimeException("Invalid matrix arguments");
        }
        this.rows = elements.length;
        this.cols = elements[0].length;
        this.n = n;
        this.elements = elements;
    }

    //Elements getter
    public int[][] getElements() {
        return elements;
    }

    //Elements range check
    public boolean ERangeCheck(int[][] elements,int n){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int e = elements[i][j];
                if (e >= n || e < 0){
                    return false;
                }
            }
        }
        return true;
    }

    // Operate given operation on two matrices
    public Matrix operate(Matrix other, Operation operation) {
        checkModulo(other);
        Matrix[] matrices = checkSize(other);
        Matrix matrixThis = matrices[0];
        Matrix matrixOther = matrices[1];

        int[][] res = new int[matrixThis.rows][matrixThis.cols];

        // loop over double array
        for(int i = 0; i < matrixThis.rows; ++i) { // rows
            for(int j = 0; j < matrixThis.cols; ++j) { // columns
                // get elements
                int a = matrixThis.elements[i][j];
                int b = matrixOther.elements[i][j];
                // do operation
                res[i][j] = operation.doOperation(a, b, this.n);
            }
        }
        return new Matrix(res, this.n);
    }

    // Check modulo
    private void checkModulo(Matrix other) {
        if (this.n != other.n) {
            throw new RuntimeException("Les modulos n des deux matrices ne correspondent pas");
        }
    }

    // Check size
    private Matrix[] checkSize(Matrix other) {
        // max rows and columns
        int maxRows = Math.max(this.rows, other.rows);
        int maxCols = Math.max(this.cols, other.cols);
        // resize this matrix if needed
        Matrix resizedThis = (this.rows != maxRows || this.cols != maxCols) ? resizedCopy(this, maxRows, maxCols) : this;
        // resize other matrix if needed
        Matrix resizedOther = (other.rows != maxRows || other.cols != maxCols) ? resizedCopy(other, maxRows, maxCols) : other;

        return new Matrix[]{resizedThis, resizedOther};
    }

    // Resize matrix
    public Matrix resizedCopy(Matrix m, int newRows, int newCols) {
        int[][] newElem = new int[newRows][newCols];
        // loop over double array
        for(int i = 0; i < newRows; ++i) {
            for(int j = 0; j < newCols; ++j) {
                // place existing numbers in same spots
                if(i < m.rows && j < m.cols)
                    newElem[i][j] = m.elements[i][j];
                // resize with 0
                else
                    newElem[i][j] = 0;
            }
        }
        // return copy
        return new Matrix(newElem, m.n);
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

    @Override
    // Display matrix
    public String toString() {
        String m = "";
        if (this.rows <= 1)
            m += "[";
        if (this.cols == 0)
            m += "[]";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                m += elements[i][j];
                if (j < elements[i].length - 1)
                    m += " ";
            }
            if (i < rows - 1)
                m += "\n";
        }
        if (this.rows <= 1)
            m += "]";
        return m;
    }
}
