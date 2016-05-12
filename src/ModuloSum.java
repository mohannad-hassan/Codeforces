import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by mohannadhassan on 9/10/15.
 */
public class ModuloSum {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);

        int [] array = new int[n];
        input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        HashSet<Integer>reminders = new HashSet<>();

        boolean flag = false;

        for (int i = 0; i < n && !flag; i++) {
            ArrayList<Integer>list = new ArrayList<>(reminders.size());

            int ownRem = array[i] % x;
            if (ownRem == 0) {
                flag = true;
                break;
            }

            list.add(ownRem);

            for (Iterator<Integer>ite = reminders.iterator(); ite.hasNext(); ) {
                int temp = (int)((array[i] + (long)ite.next()) % x);
                if (temp == 0) {
                    flag = true;
                    break;
                }
                list.add(temp);
            }
            reminders.addAll(list);
        }

        System.out.println(flag ? "YES" : "NO");
    }
}
