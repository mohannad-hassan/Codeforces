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
        long all = 0;
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            bs[i] = Integer.parseInt(input[i]);
            all += bs[i];
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
        }

        int capitalsSum = 0;
        for (int i = 0; i < k; i++) {
            int j = capitals[i];
            long temp = all - capitalsSum - bs[j];
            if (j > 0) {
                if (!isCapital[j - 1])
                    temp -= bs[j - 1];
            }
            else {
                temp -= bs[n - 1];
            }

            if (j < n - 1) {
                temp -= bs[j + 1];
            }
            else if (!isCapital[0]){
                temp -= bs[0];
            }

            sum += bs[j] * temp;
            capitalsSum += bs[j];
        }

        System.out.println(sum);
    }
}
