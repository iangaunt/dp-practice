import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubsequence {
    static Map<String, String> memo = new HashMap<String, String>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a string m: ");
        String m = input.nextLine();

        System.out.println("Input a string n: ");
        String n = input.nextLine();
        input.close();

        System.out.println(longestCommonSubsequence(m, n));
    }

    public static String longestCommonSubsequence(String m, String n) {
        if (m.length() == 0 || n.length() == 0) return "";

        String key = m + ":" + n;
        if (memo.containsKey(key)) return memo.get(key);

        String solution;
        if (m.charAt(m.length() - 1) == n.charAt(n.length() - 1)) {
            solution = longestCommonSubsequence(
                m.substring(0, m.length() - 1), 
                n.substring(0, n.length() - 1)
            ) + m.charAt(m.length() - 1);
        } else {
            String solM = longestCommonSubsequence(m.substring(0, m.length() - 1), n);
            String solN = longestCommonSubsequence(m, n.substring(0, n.length() - 1));

            solution = solM.length() > solN.length() ? solM : solN;
        }

        memo.put(m + ":" + n, solution);
        return solution;
    }
}
