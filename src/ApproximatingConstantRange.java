import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 11/24/15.
 */
public class ApproximatingConstantRange {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int [] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int max = 0;

            int j;
            for (j = i; j < n && max - min <= 1; j++) {
                if (array[j] > max)
                    max = array[j];
                if (array[j] < min)
                    min = array[j];
            }

            int temp = j - i;
            if (max - min > 1)
                temp--;
            if (temp > answer)
                answer = temp;
        }

        System.out.println(answer);
    }
}
