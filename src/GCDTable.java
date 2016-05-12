import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by mohannadhassan on 10/3/15.
 */
public class GCDTable {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n * n; i++) {
            int temp = Integer.parseInt(input[i]);
            Integer count = map.get(temp);
            if (count == null) {
                count = 0;
            }
            count += 1;
            map.put(temp, count);
        }

        Integer[] array = map.keySet().toArray(new Integer[map.size()]);

        Arrays.sort(array);

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> neededFactors = new HashMap<>();

        for (int i = array.length - 1; i >= 0; i--) {
            int number = array[i];
            int count = map.get(number);

            if (neededFactors.get(number) != null) {
                count -= neededFactors.get(number);
            }

            if (count > 0) {
                int listGCD = 0;
                for (int listNum : list) {
                    if (listNum % number == 0) {
                        listGCD ++;
                    }
                }

                int root = (int) Math.sqrt(4 * listGCD * listGCD + 4 * count);
                int currentListCnt = (root - 2 * listGCD) / 2;

                ArrayList<Integer> newFactors = new ArrayList<>();

                for (int listNum : list) {
                    int gcd = gcd(listNum, number);
                    if (gcd != number)
                        newFactors.add(gcd);
                }

                for (int j = 0; j < currentListCnt; j++) {
                    list.add(number);
                }

                for (int factor : newFactors) {
                    Integer facCnt = neededFactors.get(factor);
                    if (facCnt == null) {
                        facCnt = 0;
                    }
                    facCnt += 2 * currentListCnt;
                    neededFactors.put(factor, facCnt);
                }
            }
        }

        boolean flag = false;
        for (int i : list) {
            if (flag)
                System.out.print(' ');
            else
                flag = true;

            System.out.print(i);
        }
        System.out.println();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
