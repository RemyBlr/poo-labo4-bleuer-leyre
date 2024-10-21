public class Main {
    public static void main(String[] args) {
        // scanner for user input
        // size and modulo
        int n = 10;

        // matrix 1
        Matrix matrix1 = new Matrix(4,4,n);
        // matrix 2
        int[][] elementsM2 = {
                {0,1,2,3},
                {4,5,6,7},
                {9,8,2,1},
                {4,3,5,6}
                };
        Matrix matrix2 = new Matrix(elementsM2,n);

        System.out.println("The modulus is " + n);

        // Show intial matrices
        System.out.println("one");
        matrix1.display();

        System.out.println("two");
        matrix2.display();

        // Add
        // Matrix add = matrix1.add(matrix2);
        System.out.println("one + two");
        // add.display();

        // Subtract
        // Matrix subtract = matrix1.subtract(matrix2);
        System.out.println("one - two");
        // subtract.display();

        // Multiply
        // Matrix multiply = matrix1.multiply(matrix2);
        System.out.println("one x two");
        // multiply.display();
    }
}