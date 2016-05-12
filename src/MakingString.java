import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by mohannadhassan on 2/4/16.
 */
public class MakingString {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int []array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        java.util.Arrays.sort(array);

        long total = array[n - 1];
        int max = array[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int num;
            if (array[i] < max)
                num = array[i];
            else
                num = max - 1;

            if (num < 0)
                num = 0;
            total += num;
            max = num;
        }

        System.out.println(total);
    }
}
