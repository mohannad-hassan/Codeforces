import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 9/10/16.
 */
public class MemoryAndCrow {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String [] input = br.readLine().split(" ");

        long [] as = new long[n];
        for (int i = 0; i < n; i++) {
            as[i] = Integer.parseInt(input[i]);
        }

        long [] bs = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            bs[i] = as[i];
            if (i < n - 1) {
                bs[i] += as[i + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(bs[i]);
            if (i != n - 1)
                System.out.print(" ");
        }
        System.out.println();
        System.exit(0);
    }
}
