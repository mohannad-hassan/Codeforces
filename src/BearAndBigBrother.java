import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 3/18/17.
 */
public class BearAndBigBrother {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        double n = (Math.log(b) - Math.log(a)) / (Math.log(3) - Math.log(2));

        int floor = (int)Math.floor(n);

        System.out.println(floor + 1);
    }
}
