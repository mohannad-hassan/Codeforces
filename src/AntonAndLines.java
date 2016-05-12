import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 11/4/15.
 */
public class AntonAndLines {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String [] input = br.readLine().split(" ");
        int x1 = Integer.parseInt(input[0]);
        int x2 = Integer.parseInt(input[1]);

        int [] ks = new int[n];
        int [] bs = new int[n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            ks[i] = Integer.parseInt(input[0]);
            bs[i] = Integer.parseInt(input[1]);

            int temp1 = ks[i] * x1 + bs[i];
            int temp2 = ks[i] * x2 + bs[i];
        }

        boolean flag = false;
        for (int i = 0; !flag && i < n; i++) {
            for (int j = i + 1; !flag && j < n; j++) {
                if (ks[i] != ks[j]) {
                    double x = ((double)bs[j] - bs[i]) / (ks[i] - ks[j]);
                    if (x > x1 && x < x2) {
                        flag = true;
                    }
                }
            }
        }

        System.out.println(flag ? "Yes" : "No");
    }
}
