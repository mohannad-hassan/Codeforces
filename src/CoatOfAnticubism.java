import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by MohannadHassanPersonal on 4/29/16.
 */
public class CoatOfAnticubism {

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] array = br.readLine().split(" ");

        int [] sides = new int[n];
        for (int i = 0; i < n; i++) {
            sides[i] = Integer.parseInt(array[i]);
        }

        Arrays.sort(sides);

        int l = sides[n - 1] + 1;

        for (int i = 0; i < n - 1; i++) {
            l -= sides[i];
        }

        System.out.println(l);
    }
}
