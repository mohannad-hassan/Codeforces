import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 2/20/16.
 */
public class FarRelativeProblem {

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        final int DAYS = 367;
        int [] males = new int[DAYS];
        int [] females = new int[DAYS];

        for (int i = 0; i < n; i++) {
            String [] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[2]);
            int [] array;
            if (input[0].charAt(0) == 'M') {
                array = males;
            }
            else  {
                array = females;
            }
            for (int j = start; j <= end; j++) {
                array[j] ++;
            }
        }

        int max = 0;
        for (int i = 1; i < DAYS; i++) {
            int temp;
            if (males[i] > females[i] ) {
                temp = females[i];
            }
            else {
                temp = males[i];
            }
            if (temp > max) {
                max = temp;
            }
        }

        System.out.println(max * 2);
    }
}
