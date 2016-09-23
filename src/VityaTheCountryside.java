import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 9/23/16.
 */
public class VityaTheCountryside {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");


        int last = Integer.parseInt(input[n - 1]);

        boolean hasAnswer = true;
        boolean up;

        if (last == 0) {
            up = true;
        }
        else if (last == 15) {
            up = false;
        }
        else if (n > 1) {
            int lastTwo = Integer.parseInt(input[n - 2]);

            up = last > lastTwo;
        }
        else {
            up = false;
            hasAnswer = false;
        }

        if (hasAnswer) {
            System.out.println(up ? "UP" : "DOWN");
        }
        else {
            System.out.println("-1");
        }
    }

}
