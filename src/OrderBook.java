import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by mohannadhassan on 8/22/15.
 */
public class OrderBook {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        TreeMap<Integer, Integer>buys = new TreeMap<>();
        TreeMap<Integer, Integer>sells = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int price = Integer.parseInt(input[1]);
            int vol = Integer.parseInt(input[2]);

            TreeMap<Integer, Integer>map;
            if (input[0].charAt(0) == 'B') {
                map = buys;
            }
            else {
                map = sells;
            }

            Integer volSum = map.get(price);
            if (volSum == null) {
                volSum = 0;
            }
            volSum += vol;
            map.put(price, volSum);
        }

        if (sells.size() <= k)
            print(sells, k, 'S');
        else  {
            int [] arr = new int[k];
            Iterator<Integer> ite = sells.keySet().iterator();
            int index = k - 1;
            while (index >= 0) {
                arr[index] = ite.next();
                index--;
            }

            for (int i : arr) {
                System.out.println("S " + i + " " + sells.get(i));
            }
        }
        print(buys, k, 'B');
    }

    static void  print (TreeMap<Integer, Integer> map, int s, char dir) {
        Iterator<Integer> ite = map.descendingKeySet().iterator();

        while (ite.hasNext() && s-- > 0) {
            int price = ite.next();
            int vol = map.get(price);

            System.out.println(dir + " " + price + " " + vol);
        }
    }
}
