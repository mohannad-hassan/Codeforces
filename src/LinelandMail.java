import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 8/5/15.
 */
public class LinelandMail {

    public static  void  main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] array = new int[n];
        String [] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < n; i++) {
            int end1 = array[i] - array[0];
            int end2 = array[n - 1] - array[i];
            int max = end1 > end2 ? end1 : end2;

            end1 = i == 0 ? Integer.MAX_VALUE : array[i] - array[i - 1];
            end2 = i == n - 1 ? Integer.MAX_VALUE : array[i + 1] - array[i];
            int min = end1 < end2 ? end1 : end2;

            System.out.println(min + " " + max);
        }
    }
}
