import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by MohannadHassanPersonal on 11/20/15.
 */
public class SpongebobJoke {

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split(" ");

        int n = Integer.parseInt(array[0]);
        int m = Integer.parseInt(array[1]);

        int [] fs = new int [n];
        int [] bs = new int [m];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        array = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            fs[i] = Integer.parseInt(array[i]);
            int b = fs[i];
            int a = i + 1;

            ArrayList<Integer> list = map.get(b);
            if (list == null) {
                list = new ArrayList<>();
                map.put(b, list);
            }
            list.add(a);
        }

        boolean impossible = false, ambigous = false;

        int [] as = new int [m];

        array = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            bs[i] = Integer.parseInt(array[i]);

            if (!impossible) {
                ArrayList<Integer> list = map.get(bs[i]);
                if (list == null) {
                    impossible = true;
                }
                else if(!ambigous){
                    if (list.size() > 1) {
                        ambigous = true;
                    }
                    else {
                        as[i] = list.get(0);
                    }
                }
            }
        }

        if (impossible)
            System.out.println("Impossible");
        else if (ambigous)
            System.out.println("Ambiguity");
        else {
            System.out.println("Possible");
            for (int i = 0; i < m; i++) {
                if (i > 0)
                    System.out.print(' ');
                System.out.print(as[i]);
            }
            System.out.println();
        }
    }
}
