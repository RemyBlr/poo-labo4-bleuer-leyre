import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    // test Data
    int n = 10;
    int[][] elementsM2 = {
            {0,1,2,3},
            {4,5,6,7},
            {9,8,2,1},
            {4,3,5,6}
    };
    int[][] elementsM3 = {
            {0,1,2,3},
            {4,5,6,7}
    };
    int[][] elementsM4 = {
            {1,0,0,0},
            {0,1,0,0},
            {0,0,1,0},
            {0,0,0,1}
    };

    // test Matrix
    Matrix m1 = new Matrix(4,4,n);
    Matrix m2 = new Matrix(elementsM2,n);
    Matrix m3 = new Matrix(elementsM3,n);
    Matrix m4 = new Matrix(elementsM4,n);

    @org.junit.jupiter.api.Test
    void TestAdd() {
        // result data
        int[][] elementsM2add4 = {
                {1,1,2,3},
                {4,6,6,7},
                {9,8,3,1},
                {4,3,5,7}
        };
        int[][] elementsM4add4 = {
                {2,0,0,0},
                {0,2,0,0},
                {0,0,2,0},
                {0,0,0,2}
        };
        int[][] elementsM3add4 = {
                {1,1,2,3},
                {4,6,6,7},
                {0,0,1,0},
                {0,0,0,1}
        };
        int[][] elementsM3add3 = {
                {0,2,4,6},
                {8,0,2,4},
                {0,0,0,0},
                {0,0,0,0}
        };

        // result Matrix
        Matrix m2add4 = new Matrix(elementsM2add4,n);
        Matrix m4add4 = new Matrix(elementsM4add4,n);
        Matrix m3add4 = new Matrix(elementsM3add4,n);
        Matrix m3add3 = new Matrix(elementsM3add3,n);

        // Test of matrix.add()
        try {
            assertArrayEquals(m2add4.getElements(),m2.add(m4).getElements());
            assertArrayEquals(m2add4.getElements(),m4.add(m2).getElements());
            assertArrayEquals(m4add4.getElements(),m4.add(m4).getElements());
            assertArrayEquals(m3add4.getElements(),m3.add(m4).getElements());
            assertArrayEquals(m3add4.getElements(),m4.add(m3).getElements());
            assertArrayEquals(m3add3.getElements(),m3.add(m3).getElements());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void TestSubtract() {
        // result data
        int[][] elementsM2sub4 = {
                {9,1,2,3},
                {4,4,6,7},
                {9,8,1,1},
                {4,3,5,5}
        };
        int[][] elementsM4sub2 = {
                {1,9,8,7},
                {6,6,4,3},
                {1,2,9,9},
                {6,7,5,5}
        };
        int[][] elementsM3sub3 = {
                {0,0,0,0},
                {0,0,0,0}
        };
        int[][] elementsM4sub3 = {
                {1,9,8,7},
                {6,6,4,3},
                {0,0,1,0},
                {0,0,0,1}
        };

        // result Matrix
        Matrix m2sub4 = new Matrix(elementsM2sub4,n);
        Matrix m4sub2 = new Matrix(elementsM4sub2,n);
        Matrix m3sub3 = new Matrix(elementsM3sub3,n);
        Matrix m4sub3 = new Matrix(elementsM4sub3,n);

        // Test of matrix.subtract()
        try {
            assertArrayEquals(m2sub4.getElements(),m2.subtract(m4).getElements());
            assertArrayEquals(m4sub2.getElements(),m4.subtract(m2).getElements());
            assertArrayEquals(m3sub3.getElements(),m3.subtract(m3).getElements());
            assertArrayEquals(m4sub3.getElements(),m4.subtract(m3).getElements());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void TestMultiply() {
        // result data
        int[][] elementsM2multi4 = {
                {0,0,0,0},
                {0,5,0,0},
                {0,0,2,0},
                {0,0,0,6}
        };
        int[][] elementsM3multi4 = {
                {0,0,0,0},
                {0,5,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        int[][] elementsM3multi3 = {
                {0,1,4,9},
                {6,5,6,9}
        };

        // result Matrix
        Matrix m2multi4 = new Matrix(elementsM2multi4,n);
        Matrix m3multi4 = new Matrix(elementsM3multi4,n);
        Matrix m3multi3 = new Matrix(elementsM3multi3,n);

        // Test of matrix.multiply()
        try {
            assertArrayEquals(m2multi4.getElements(),m2.multiply(m4).getElements());
            assertArrayEquals(m2multi4.getElements(),m4.multiply(m2).getElements());
            assertArrayEquals(m3multi4.getElements(),m3.multiply(m4).getElements());
            assertArrayEquals(m3multi3.getElements(),m3.multiply(m3).getElements());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void TestExeption() {
        Matrix alien = new Matrix(elementsM4,16);
        RuntimeException thrown = assertThrows(RuntimeException.class,() -> alien.add(m1),
                "Sizes does not match");
        assertTrue(thrown.getMessage().contains("Stuff"));
    }
}