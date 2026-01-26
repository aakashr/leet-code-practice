public class Recursion {
    private void recursion(int n) {
        if (n == 0) { return; }
        System.out.println(n);
        recursion(n-1);
    }
    public static void main(String[] args) {
        Recursion r = new Recursion();
        r.recursion(5);



    }
}
