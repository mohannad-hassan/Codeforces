import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 1/22/17.
 */
public class FrodoAndPillows {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int beds = Integer.parseInt(input[0]);
        int pillows = Integer.parseInt(input[1]);
        int frodo = Integer.parseInt(input[2]);

        int left = frodo - 1;
        int right = beds - frodo;

        int max = pillows - beds + 1;
        int min = 1;

        while (true) {

            if (max == min + 1 || max == min) {
                int maxPillows = allPillows(max, left, right);

                if (maxPillows > pillows) {
                    max = min;
                }
                break;
            }
            int mid = (max + min) / 2;
            int midPillows = allPillows(mid, left, right);

            if (midPillows > pillows) {
                max = mid;
            }
            else {
                min = mid;
            }
        }

        System.out.println(max);
    }

    static int allPillows(int main, int left, int right) {
        main--;
        int allPillows = left + right + 1 + main + calc(main, left) + calc(main, right);

        return allPillows;
    }

    static int calc(int main, int len) {
        if (len == 1) return main - 1;
        return seriesSum(main - 1) - seriesSum(main - len - 1);
    }

    static int seriesSum(int n) {
        if (n < 0) return 0;
        return (int) ((long)n * (n + 1)) / 2;
    }
}
