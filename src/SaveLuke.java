import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 2/4/16.
 */
public class SaveLuke {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int d = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);
        int v1 = Integer.parseInt(input[2]);
        int v2 = Integer.parseInt(input[3]);

        double ans = (l - d) / (double) (v1 + v2);

        System.out.printf("%.7f", ans);
    }
}
