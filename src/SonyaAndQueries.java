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

        HashMap<Long, Integer> countMap = new HashMap<>();
        SonyaAndQueriesIndex index = new SonyaAndQueriesIndex();

        for (int i = 0; i < n; i++) {
            String [] input = br.readLine().split(" ");
            if (input[0].equals("+")) {
                long num = Long.parseLong(input[1]);
                increment(countMap, num);
                index.add(num);
            }
            else if (input[0].equals("-")) {
                decrement(countMap, Long.parseLong(input[1]));
            }
            else {
                HashSet<Long> searchResult = index.search(input[1]);
                System.out.println(aggregateResult(searchResult, countMap));
            }
        }
        System.exit(0);
    }

    static void increment(HashMap<Long, Integer> countMap, long num){
        Integer cnt = countMap.get(num);
        if (cnt == null) {
            cnt = 0;
        }
        countMap.put(num, cnt + 1);
    }

    static void decrement(HashMap<Long, Integer> countMap, long num){
        Integer cnt = countMap.get(num);
        if (cnt == null || cnt == 0) {
            return;
        }
        countMap.put(num, cnt - 1);
    }

    static int aggregateResult(HashSet<Long> searchResult, HashMap<Long, Integer> countMap) {
        int sum = 0;
        Iterator<Long> ite = searchResult.iterator();
        while (ite.hasNext()) {
            Long num = ite.next();
            sum += countMap.get(num);
        }
        return sum;
    }
}

class SonyaAndQueriesIndex {
    class BitIndex {
        HashSet<Long> even = new HashSet<>();
        HashSet<Long> odd = new HashSet<>();
    }

    BitIndex [] indexes = new BitIndex[18];
    public SonyaAndQueriesIndex() {
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = new BitIndex();
        }
    }

    public void add(long num) {
        int cnt = 0;
        long temp = num;

        while (temp > 0 && cnt < 1) {
            long digit = temp % 10;
            if (digit % 2 == 0) {
                indexes[cnt].even.add(num);
            }
            else {
                indexes[cnt].odd.add(num);
            }
            cnt++;
            temp /= 10;
        }
//        for (; cnt < 18; cnt++) {
//            indexes[cnt].even.add(num);
//        }
    }

    public HashSet<Long> search(String pattern) {
        HashSet<Long> result = null;

        StringBuilder strBuilder = new StringBuilder(pattern).reverse();
//        for (int i = pattern.length(); i < 18; i++) {
//            strBuilder.append('0');
//        }
        pattern = strBuilder.toString();


        char digitPattern = pattern.charAt(0);
        HashSet<Long> currentSet = digitPattern == '0' ? indexes[0].even : indexes[0].odd;
        if (result == null) {
            result = (HashSet<Long>) currentSet.clone();
        }

        Iterator<Long> ite = result.iterator();
        while (ite.hasNext()) {
            Long l = ite.next();

            long temp = l;
            int cnt = 0;
            boolean passes = true;

            while (temp > 0 && cnt < pattern.length() && passes) {
                long digit = temp % 10;
                boolean even = digit % 2 == 0;
                char patternDigit = pattern.charAt(cnt);
                if ((patternDigit == '0' && !even) || (patternDigit == '1' && even))
                    passes = false;
                cnt++;
                temp /= 10;
            }

            if (passes) {
                if (temp == 0) {
                    for (; cnt < pattern.length() && passes; cnt++) {
                        if (pattern.charAt(cnt) == '1') {
                            passes = false;
                        }
                    }
                }
                else {
                    while (temp > 0 && passes) {
                        long digit = temp % 10;
                        passes = digit % 2 == 0;
                        temp /= 10;
                    }
                }
            }

            if (!passes)
                ite.remove();
        }

//        for (int i = 0; i < pattern.length(); i++) {
//            char digitPattern = pattern.charAt(i);
//            HashSet<Long> currentSet = digitPattern == '0' ? indexes[i].even : indexes[i].odd;
//            if (result == null) {
//                result = (HashSet<Long>) currentSet.clone();
//            }
//            else {
//                result.retainAll(currentSet);
//            }
//            if (result.isEmpty()) {
//                break;
//            }
//        }
        return result;
    }
}
