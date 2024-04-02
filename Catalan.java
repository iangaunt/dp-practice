import java.util.Scanner;

public class Catalan {
    static long[] factorials;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a number n: ");
        int n = input.nextInt();
        input.close();

        factorials = new long[2 * n];

        System.out.println(catalan(n));
    }

    public static long catalan(int n) {
        long fac2n = factorial(2 * n);
        long facn1 = factorial(n + 1);
        long facn = factorial(n);

        return (fac2n) / (facn1 * facn);
    }

    public static long factorial(int n) {
        if (n == 0) return 1L;
        if (factorials[n - 1] != 0) return factorials[n - 1];

        long fac = n * factorial(n - 1);
        factorials[n - 1] = fac;
        return fac;
    }
}
