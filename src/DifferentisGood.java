import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by mohannadhassan on 5/11/16.
 */
public class DifferentisGood {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        if (n > 'z' - 'a' + 1) {
            System.out.println("-1");
        }
        else  {
            HashSet<Character> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                set.add(s.charAt(i));
            }

            System.out.println(n - set.size());
        }
    }
}
