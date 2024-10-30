/*
* Authors : Bleuer Rémy, Leyre Arnaut
* Date : 30.10.2024
* Classe : POO-A
*/
public class Main {
    public static void main(String[] args) {
        if (args.length != 5) {
            throw new RuntimeException("Invalid Format: [N1] [M1] [N2] [M2] [n]");
        }

        // args
        int N1 = Integer.parseInt(args[0]);
        int M1 = Integer.parseInt(args[1]);
        int N2 = Integer.parseInt(args[2]);
        int M2 = Integer.parseInt(args[3]);
        int n = Integer.parseInt(args[4]);

        // matrix 1
        Matrix matrix1 = new Matrix(N1,M1,n);

        // matrix 2
        Matrix matrix2 = new Matrix(N2,M2,n);

        System.out.println("The modulus is " + n  + "\n");

        // Show intial matrices
        System.out.println("one");
        System.out.println(matrix1.toString() + "\n");

        System.out.println("two");
        System.out.println(matrix2.toString() + "\n");

        // Add
        Matrix add = matrix1.add(matrix2);
        System.out.println("one + two");
        System.out.println(add.toString() + "\n");

        // Subtract
        Matrix subtract = matrix1.subtract(matrix2);
        System.out.println("one - two");
        System.out.println(subtract.toString() + "\n");

        // Multiply
        Matrix multiply = matrix1.multiply(matrix2);
        System.out.println("one x two");
        System.out.println(multiply.toString() + "\n");
    }
}