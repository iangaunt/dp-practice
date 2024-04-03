import java.util.Scanner;

public class PathCounter {
    static int[] memo;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a value n: ");
        int n = input.nextInt();
        input.close();

        memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= n; i++) {
            int sum = memo[i - 3] + memo[i - 2] + memo[i - 1];
            memo[i] = sum;
        }

        System.out.println(memo[n]);
    }
}
