import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created by mohannadhassan on 8/10/15.
 */
public class Inventory {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int actual [] = new int[n];
        int [] occurences = new int[n + 1];
        LinkedList<Integer> surp = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            actual[i] = Integer.parseInt(input[i]);
            if (actual[i] <= n) {
                occurences[actual[i]]++;
                if (occurences[actual[i]] > 1) {
                    surp.add(i);
                }
            }
            else {
                surp.add(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (occurences[i] == 0) {
                int pos = surp.poll();
                actual[pos] = i;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(actual[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
