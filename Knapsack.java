public class Knapsack {
    static int[] weights = {10, 20, 30};
    static int[] costs = {60, 100, 120};
    static int avWeight = 50;

    static int[][] memo;

    public static void main(String[] args) {
        memo = new int[avWeight + 1][weights.length];
        
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }

        System.out.println(knapsack(avWeight, 0, 0));
    }

    public static int knapsack(int avWeight, int index, int profit) {
        if (avWeight < 0) return -1;
        if (index == weights.length) return profit;

        if (memo[avWeight][index] != -1) return memo[avWeight][index];

        int best = Math.max(
            knapsack(avWeight - weights[index], index + 1, profit + costs[index]),
            knapsack(avWeight, index + 1, profit)
        );

        memo[avWeight][index] = best;
        return best;
    }   

    public static void outputMemo() {
        for (int i = 0; i < memo.length; i++) {
            String k = "[";
            for (int j = 0; j < memo[0].length; j++) {
                k += memo[i][j] + ", ";
            }
            k = k.substring(0, k.length() - 2);
            System.out.println(k + "]");
        }
    }
}