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

        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        TreeSet<Integer>allKeys = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(input[i]);
            increase(countMap, key);
            allKeys.add(key);
        }

        Map<Integer, Integer> oldMap = countMap;

        int answer = 0;

        while (!allKeys.isEmpty()){
            int pow = allKeys.pollFirst();
            int cnt = oldMap.get(pow);
            while(cnt > 0) {
                int newCnt = 1;
                int log = 0;
                while (newCnt * 2 <= cnt) {
                    newCnt *= 2;
                    log ++;
                }
                cnt -= newCnt;
                increase(oldMap, pow + log);
                if (!allKeys.contains(pow + log) && log != 0)
                    allKeys.add(pow + log);
                if (log == 0)
                    answer++;
            }
        }

        System.out.println(answer);
    }

    private static int log2(int n) {
        int log = 0;
        while(n > 1) {
            n /= 2;
            log++;
        }
        return log;
    }

    private static int getHighest(int cnt) {
        int ans = 1;
        while(ans * 2 <= cnt) {
            ans *= 2;
        }
        return ans;
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