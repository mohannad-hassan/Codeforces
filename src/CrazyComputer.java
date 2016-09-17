import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 9/17/16.
 */
public class CrazyComputer {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int count = 1;
        for (int i = 1; i < n; i++) {
            if (array[i] - array[i - 1] <= c) {
                count++;
            }
            else {
                count = 1;
            }
        }

        System.out.println(count);
    }
}
