import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 8/22/15.
 */
public class Arrays {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int []a = new int[input.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        int []b = new int[input.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(input[i]);
        }

        int kth = a[k - 1];
        int mth = b[b.length - m];
        if (mth > kth)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
