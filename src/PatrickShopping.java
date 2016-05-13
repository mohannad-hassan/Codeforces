import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 11/20/15.
 */
public class PatrickShopping {

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] array = br.readLine().split(" ");

        long d1 = Integer.parseInt(array[0]);
        long d2 = Integer.parseInt(array[1]);
        long d3 = Integer.parseInt(array[2]);

        long min = d1 + d2 + d3;

        if (d1 * 2 + d2 * 2 < min)
            min = d1 * 2 + d2 * 2;

        if (d1 * 2 + d3 * 2 < min)
            min = d1 * 2 + d3 * 2;

        if (d2 * 2 + d3 * 2 < min)
            min = d2 * 2 + d3 * 2;

        System.out.println(min);
    }
}
