import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Collections;

/**
 * Created by mohannadhassan on 8/5/15.
 */
public class GeometricProgression {

    public static  void  main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        TreeMap<Integer, ArrayList<Integer> > tree = new TreeMap<Integer, ArrayList<Integer> >();

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(input[i]);
            ArrayList<Integer> list = tree.get(temp);
            if (list == null) {
                list = new ArrayList<>();
                tree.put(temp, list);
            }
            list.add(i);
        }

        long count = 0;

        Iterator<Integer> ite = tree.keySet().iterator();

        while (ite.hasNext()) {
            Integer key = ite.next();
            ArrayList<Integer> first = tree.get(key);

            if (k == 1 || key == 0) {
                if (first.size() == 3) {
                    count ++;
                }
                else if (first.size() > 3) {
                    count += combs(first.size(), 3);
                }
                continue;
            }
            ArrayList<Integer> second = tree.get(key * k);
            ArrayList<Integer> third = tree.get(key * k * k);

            if (second == null || third == null)
                continue;

            for (Integer firstIndex : first) {
                int secondIndex = Collections.binarySearch(second, firstIndex);
                secondIndex = (secondIndex + 1) * -1;
                for (int j = secondIndex; j < second.size(); j++) {
                    int thirdIndex = Collections.binarySearch(third, second.get(j));
                    thirdIndex = (thirdIndex + 1) * -1;
                    if (thirdIndex < third.size())
                        count += third.size() - thirdIndex;
                }
            }
        }
        System.out.println(count);
    }

    private static long combs(int n, int r) {
        long sum = 1;
        long c = n - r;

        while(n > 1) {
            sum *= n--;
            if (c > 1 && sum % c == 0)
                sum = sum / c--;
        }

        while(c > 1) {
            sum /= c--;
        }

        while (r > 1) {
            sum /= r--;
        }

        return sum;
    }
}
