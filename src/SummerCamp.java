import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 5/11/16.
 */
public class SummerCamp {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int current = 1;

        while (true) {
            int digits;
            if (current < 10) {
                digits = 1;
            }
            else  if (current < 100) {
                digits = 2;
            }
            else  {
                digits = 3;
            }

            if (digits < n) {
                n -= digits;
                current++;
            }
            else {
                String s = current + "";
                System.out.println(s.charAt(n - 1));
                return;
            }
        }
    }
}
