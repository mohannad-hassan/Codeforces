import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by MohannadHassanPersonal on 9/30/16.
 */
public class Passwords {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int k = Integer.parseInt(input[1]);

        TreeMap<Integer, Integer> lengthCount = new TreeMap<>();
        HashMap<String, Integer> frequency = new HashMap<>();

        String s;
        String last = "";
        while ((s = br.readLine()) != null) {
            if (s.trim().length() == 0) {
                break;
            }
            last = s;
            increment(lengthCount, s.length());
            increment(frequency, s);
        }

        int allAttempts = 0;
        int best = 0;
        int worst = 0;

        int attempts = 0;

        Iterator<Integer> ite = lengthCount.keySet().iterator();
        while (true) {
            int next = ite.next();
            if (next != last.length()) {
                attempts += lengthCount.get(next);
                allAttempts += lengthCount.get(next);
                allAttempts += (attempts / k) * 5;
                attempts = attempts % k;
            }
            else {
                best = allAttempts + 1;

                int rest = lengthCount.get(next) - frequency.get(last);

                attempts += rest;
                allAttempts += rest;
                allAttempts += (attempts / k) * 5;
                attempts = attempts % k;

                worst = allAttempts + 1;

                break;
            }
        }

        System.out.println(best + " " + worst);
    }

    static <T> void increment(Map<T, Integer> map, T key) {
        Integer count = map.get(key);
        if (count == null) {
            count = 0;
        }
        map.put(key, count + 1);
    }
}
