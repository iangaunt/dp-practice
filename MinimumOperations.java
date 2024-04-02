import java.util.Scanner;

public class MinimumOperations {
    static int[] memo;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a value k: ");
        int k = input.nextInt();
        input.close();

        memo = new int[k + 1];
        memo[1] = 1;

        for (int i = 0; i < memo.length; i++) {
            operationsTo(i);
        }
        System.out.println(operationsTo(k));
    }

    public static int operationsTo(int k) {
        if (k == 0) return 0;
        if (memo[k] != 0) return memo[k];

        int sub = memo[k - 1] + 1;

        int result = k % 2 == 0 ? Math.min(sub, memo[k / 2] + 1) : sub;
        memo[k] = result;
        return k;
    }
}
