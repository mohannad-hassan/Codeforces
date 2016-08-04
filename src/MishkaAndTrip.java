import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by mohannadhassan on 8/4/16.
 */
public class MishkaAndTrip {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int [] bs = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            bs[i] = Integer.parseInt(input[i]);
        }

        int [] capitals = new int[k];
        boolean [] isCapital = new boolean[n];
        input = br.readLine().split(" ");

        for (int i = 0; i < k; i++) {
            capitals[i] = Integer.parseInt(input[i]) - 1;
            isCapital[capitals[i]] = true;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            sum += bs[i] * bs[next];

            if (isCapital[i]) {
                for (int c = 0; c < k && capitals[c] < i; c++) {
                    int j = capitals[c];
                    if (i == j || i == (j + 1) % n || j == (i + 1) % n)
                        continue;
                    sum += bs[i] * bs[j];
                }
                continue;
            }
            for (int c = 0; c < k; c++) {
                int j = capitals[c];
                if (i == j || i == (j + 1) % n || j == (i + 1) % n)
                    continue;

                sum += bs[i] * bs[j];
            }
        }

        System.out.println(sum);
    }
}
