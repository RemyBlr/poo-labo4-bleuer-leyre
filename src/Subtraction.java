public class Subtraction implements Operation {
    @Override
    public int doOperation(int a, int b, int n) {
        return Math.floorMod(a - b, n);
    }
}
