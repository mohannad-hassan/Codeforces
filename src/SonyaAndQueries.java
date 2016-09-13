import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by MohannadHassanPersonal on 9/13/16.
 */
public class SonyaAndQueries {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String [] input = br.readLine().split(" ");
            if (input[0].equals("+")) {
                long num = Long.parseLong(input[1]);

                increment(countMap, convert(num));
            }
            else if (input[0].equals("-")) {
                decrement(countMap, convert(Long.parseLong(input[1])));
            }
            else {
                Integer cnt = countMap.get(extend(input[1]));
                System.out.println(cnt == null ? 0 : cnt);
            }
        }
        System.exit(0);
    }

    static void increment(HashMap<String, Integer> countMap, String num){
        Integer cnt = countMap.get(num);
        if (cnt == null) {
            cnt = 0;
        }
        countMap.put(num, cnt + 1);
    }

    static void decrement(HashMap<String, Integer> countMap, String num){
        Integer cnt = countMap.get(num);
        if (cnt == null || cnt == 0) {
            return;
        }
        countMap.put(num, cnt - 1);
    }

    static String convert(long num) {
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            long digit = num % 10;
            if (digit % 2 == 0) {
                builder.append('0');
            }
            else {
                builder.append('1');
            }
            num /= 10;
        }
        return extend(builder.reverse().toString());
    }

    static String extend(String str) {
        for (int i = str.length(); i < 18; i++) {
            str = "0" + str;
        }
        return str;
    }
}
