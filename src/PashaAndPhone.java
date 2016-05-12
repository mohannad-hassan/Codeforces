import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 11/8/15.
 */
public class PashaAndPhone {

    static final Long MOD = 1000000007l;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        long highestBlock = (long)Math.pow(10, k);
        long temp = (long)Math.pow(10, k - 1);

        String [] as = br.readLine().split(" ");
        String [] bs = br.readLine().split(" ");

        long answer = 1;

        for (int i = 0; i < n / k; i++) {
            int a = Integer.parseInt(as[i]);
            int b = Integer.parseInt(bs[i]);

            long allNumbers = (highestBlock - 1) / a + 1;

            long limitStart = b * temp;
            long limitEnd = limitStart + temp - 1;
            if (b != 0)
                limitStart--;
            else
                allNumbers--;

            long caseAns = allNumbers - (limitEnd / a - limitStart / a);

            caseAns = caseAns % MOD;

            answer = (caseAns * answer) % MOD;
        }

        System.out.println(answer);
    }

}
