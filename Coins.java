import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Coins {
    static int[] coins = {1, 5, 10, 25};
    static Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a number: ");
        int n = input.nextInt();
        input.close();

        for (int i = 0; i < n; i++) {
            System.out.println(i + " : " + minimumCoins(i));
        }
    }

    public static int minimumCoins(int m) {
        if (m == 0) return 0;
        if (memo.containsKey(m)) return memo.get(m);

        int amount = Integer.MAX_VALUE;
        for (int c : coins) {
            int sub = m - c;
            if (sub < 0) continue;

            amount = Math.min(amount, minimumCoins(sub) + 1);
        }

        memo.put(m, amount);
        return amount;
    }
}