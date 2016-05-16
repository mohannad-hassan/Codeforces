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

        int lowerBound = 1;
        int upperBound = n;

        int cos [] = {co1, co2, co3};
        for (int temp : cos) {
            if (1 - temp > lowerBound) {
                lowerBound = 1 - temp;
                if (lowerBound > n) {
                    lowerBound = n;
                    upperBound = n - 1;
                    break;
                }
            }
            if (n - temp < upperBound) {
                upperBound = n - temp;
                if (upperBound < 1) {
                    upperBound = 0;
                    lowerBound = 1;
                    break;
                }
            }
        }

        if (upperBound < lowerBound) {
            System.out.print(0);
        }
        else
            System.out.println((upperBound - lowerBound + 1) * (long)n);

    }
}
