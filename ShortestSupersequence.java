import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShortestSupersequence {
    static Map<String, String> memo = new HashMap<String, String>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a string m: ");
        String m = input.nextLine();

        System.out.println("Input a string n: ");
        String n = input.nextLine();
        input.close();

        System.out.println(shortestSupersequence(m, n));
    }

    public static String shortestSupersequence(String m, String n) {
        if (m.length() == 0 || n.length() == 0) return m.length() == 0 ? n : m;

        String key = m + ":" + n;
        if (memo.containsKey(key)) return memo.get(key);

        char m1 = m.charAt(0);
        char n1 = n.charAt(0);

        String solution;
        if (m1 == n1) {
            solution = m1 + shortestSupersequence(m.substring(1), n.substring(1));
        } else {
            String mSol = m1 + shortestSupersequence(m.substring(1), n);
            String nSol = n1 + shortestSupersequence(m, n.substring(1));

            solution = mSol.length() > nSol.length() ? nSol : mSol;
        }

        memo.put(key, solution);
        return solution;
    }
}
