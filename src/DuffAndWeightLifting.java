import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class DuffAndWeightLifting {

    /**
     * @param args
     * @throws IOException
     * @throws NumberFormatException
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        HashMap<Integer, Integer> countMap = new HashMap();

        int maxKey = 0;

        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(input[i]);
            increase(countMap, key);
            if (maxKey < key) {
                maxKey = key;
            }
        }

        Map<Integer, Integer> oldMap = countMap;

        int answer = 0;
        long carry = 0;
        int i = 0;

        while (i <= maxKey) {
            Integer cnt = countMap.get(i);
            if (cnt == null) {
                cnt = 0;
            }
            carry += cnt;
            answer += carry % 2;
            carry /= 2;
            if (carry > 0 && i == maxKey) {
                maxKey++;
            }
            i++;
        }

        System.out.println(answer);
    }

    private static void increase(Map<Integer, Integer> countMap,
                                 int i) {
        Integer cnt = countMap.get(i);
        if (cnt == null) {
            cnt = 0;
        }
        cnt ++;
        countMap.put(i, cnt);
    }

}