import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 9/16/15.
 */
public class RaisingBacteria {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        while(n > 0) {
            if (n % 2 == 1)
                cnt++;
            n /= 2;
        }

        System.out.println(cnt);
    }

}
