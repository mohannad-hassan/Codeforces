import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 10/6/15.
 */
public class OlesyaRodion {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int t = Integer.parseInt(input[1]);

        int num = t;
        while (num < 10)
            num *= t;

        if (t == 10) {
            if (n == 1) {
                System.out.println(-1);
            }
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(1);
                for (int i = 1; i < n; i++)
                    sb.append(0);
                System.out.println(sb.toString());
            }
        }
        else if (n == 1) {
            System.out.println(t);
        }
        else if (n == 2) {
            System.out.println(num);
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < n; i++) {
                sb.append(t + "");
            }

            sb.append(num + "");
            System.out.println(sb.toString());
        }
    }
}
