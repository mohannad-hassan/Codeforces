import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by mohannadhassan on 5/25/16.
 */
public class NicholasAndPermutation {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int [] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int first = -1, last = -1;

        for (int i = 0; i < n && (first < 0 || last < 0); i++) {
            if (numbers[i] == 1) {
                first = i;
            }
            else if (numbers[i] == n) {
                last = i;
            }
        }

        int [] arr = {first, last};
        java.util.Arrays.sort(arr);

        if (n - arr[1] - 1 > arr[0] - 0) {
            System.out.println(n - 1 - arr[0]);
        }
        else  {
            System.out.println(arr[1] - 0);
        }
    }
}
