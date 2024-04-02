import java.util.Scanner;

public class MinimumSteps {
    static int[] memo;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a value n: ");
        int n = input.nextInt();
        input.close();

        memo = new int[n + 1];
        memo[0] = 0;
        for (int i = 1; i <= 3; i++) {
            memo[i] = 1;
        }

        for (int i = 4; i <= n; i++) {
            int m = Integer.MAX_VALUE;
            for (int j = 1; j <= 3; j++) {
                m = Math.min(m, memo[i - j] + 1);
            }
            memo[i] = m;
        }
        System.out.println(memo[n]);
    }
}
