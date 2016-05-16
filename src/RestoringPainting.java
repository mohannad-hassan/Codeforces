import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 5/16/16.
 */
public class RestoringPainting {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);
        int d = Integer.parseInt(input[4]);

        int co1 = b - c;
        int co2 = a - d;
        int co3 = a + b - c - d;

        int min1 = 1;
        int min2 = n;

        int cos [] = {co1, co2, co3};
        for (int temp : cos) {
            if (1 - temp > min1) {
                min1 = 1 - temp;
            }
            if (n - temp < min2) {
                min2 = n - temp;
            }
        }

        System.out.println((min2 - min1 + 1) * (long)n);

    }
}
