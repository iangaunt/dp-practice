import java.util.Scanner;

public class RodCutting {
    static int[] costs = {1, 5, 8, 9, 10, 17, 17, 20};

    static int[] memo;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a value n: ");
        int n = input.nextInt();
        input.close();

        memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = costs[0];

        for (int i = 2; i <= n; i++) {
            int profit = 0;
            
            for (int j = 0; j <= i / 2; j++) {
                profit = Math.max(profit, memo[j] + memo[i - j]);
            }
            if (i < costs.length) profit = Math.max(profit, costs[i - 1]);

            memo[i] = profit;
        }

        System.out.println(memo[n]);
    }
}
