import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 9/10/15.
 */
public class MultiplicationTable {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);

        int count = 0;

        for (int i = 1; i <= n && i <= x; i++) {
            if (x % i == 0 && x / i <= n) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}
