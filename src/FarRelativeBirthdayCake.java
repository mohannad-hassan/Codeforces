import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 2/20/16.
 */
public class FarRelativeBirthdayCake {

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] rows = new int [n];
        int [] cols = new int [n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'C') {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += (rows[i] * (rows[i] - 1)) / 2;
            total += (cols[i] * (cols[i] - 1)) / 2;
        }

        System.out.println(total);
    }
}
