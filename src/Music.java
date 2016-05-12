import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 8/10/15.
 */
public class Music {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");

        int t = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int q = Integer.parseInt(input[2]);

        int counter = 1;
        while (true) {
            int temp = s * q;
            if (temp < t) {
                counter++;
                s = temp;
            }
            else {
                break;
            }
        }

        System.out.println(counter);
    }
}
