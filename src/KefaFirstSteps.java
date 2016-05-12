import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 9/22/15.
 */
public class KefaFirstSteps {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int [] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            int j;
            for (j = i + 1; j < numbers.length && numbers[j] >= numbers[j - 1]; j++);
            int len = j - i;
            if (len > max)
                max = len;
            i = j - 1;
        }

        System.out.println(max);
    }
}
