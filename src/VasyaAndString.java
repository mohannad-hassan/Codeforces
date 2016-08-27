import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 5/25/16.
 */
public class VasyaAndString {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        String s = br.readLine();

        int l = 0, r = 0;
        int max = 0;
        int as = 0, bs = 0;

        while (r < n) {
            while (r < n && (as <= k || bs <= k)) {
                if (s.charAt(r) == 'a')
                    as++;
                else
                    bs++;
                r++;
            }

            int len = r - l - (r < n || !(as <= k || bs <= k) ? 1 : 0);
            if (len > max) {
                max = len;
            }
            if (r < n)
                while (l < r && (as > k && bs > k)) {
                    if (s.charAt(l) == 'a')
                        as--;
                    else
                        bs--;
                    l++;
                }
        }
        System.out.println(max);
        System.exit(0);
    }
}