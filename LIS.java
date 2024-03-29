import java.util.HashMap;
import java.util.Map;

public class LIS {
    static Map<Integer, Integer[]> memoArrs = new HashMap<Integer, Integer[]>();

    static Integer[] values = new Integer[500];
    
    public static void main(String[] args) {
        for (int i = 0; i < values.length; i++) {
            values[i] = (int) (Math.round(Math.random() * 100));
        }
        outputArray(values);

        Integer[] initArr = new Integer[1];
        initArr[0] = values[0];
        memoArrs.put(0, initArr);

        int biggest = 0;

        for (int i = 1; i < values.length; i++) {
            int largestSub = 0;
            for (int j = 0; j < i; j++) {
                Integer[] arr = memoArrs.get(j);
                if (arr[arr.length - 1] < values[i] && arr.length > memoArrs.get(largestSub).length) {
                    largestSub = j;
                }
            }

            Integer[] newLIS = new Integer[memoArrs.get(largestSub).length + 1];
            for (int j = 0; j < newLIS.length - 1; j++) {
                newLIS[j] = memoArrs.get(largestSub)[j];
            }
            newLIS[newLIS.length - 1] = values[i];

            memoArrs.put(i, newLIS);
            if (newLIS.length > memoArrs.get(biggest).length) biggest = i;
        }

        outputArray(memoArrs.get(biggest));
    }

    public static void outputArray(Integer[] arr) {
        String k = "{";
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[0] > arr[1]) continue;
            k += arr[i] + ", ";
        }
        k = k.substring(0, k.length() - 2);
        k += "}";

        System.out.println(k);
    }
}