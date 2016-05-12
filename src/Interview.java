import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 3/3/16.
 */
public class Interview {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long a = 0;
        String [] input = br.readLine().split(" ");

        for (String s : input) {
            int num = Integer.parseInt(s);
            a = a | num;
        }

        long b = 0;input = br.readLine().split(" ");

        for (String s : input) {
            int num = Integer.parseInt(s);
            b = b | num;
        }

        System.out.println(a + b);
    }
}
