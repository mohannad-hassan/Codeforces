import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by MohannadHassanPersonal on 3/18/17.
 */
public class BearAndFriendshipCondition {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashSet<Integer> [] friends = new HashSet[n + 1];

        for (int i = 1; i <= n; i++) {
            friends[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");;

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int lower = a > b ? b : a;
            int higher = a > b ? a : b;

            friends[lower].add(higher);
        }

        boolean flag = true;
        for (int i = 1; i <= n && flag; i++) {
            Iterator<Integer> ite = friends[i].iterator();
            while (ite.hasNext() && flag) {
                int f1 = ite.next();
                Iterator<Integer> ite2 = friends[f1].iterator();
                while (ite2.hasNext() && flag) {
                    int f2 = ite2.next();
                    flag = friends[i].contains(f2);
                }
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }
}
