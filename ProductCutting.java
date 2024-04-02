import java.util.Scanner;

public class ProductCutting {
    static int[] memo;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a value n: ");
        int n = input.nextInt();
        input.close();

        memo = new int[n + 1];
        memo[0] = 1;

        for (int i = 2; i <= n; i++) {
            int m = 0;
            for (int j = 0; j <= i / 2; j++) {
                m = Math.max(m, memo[j] * memo[i - j]);
            }
            memo[i] = Math.max(m, i);
        }
        System.out.println(memo[n]);
    }
}
