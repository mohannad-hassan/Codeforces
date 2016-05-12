import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 10/6/15.
 */
public class KolyaTanya {

    static final double MOD = 10000000007l;

    static long [][] combs;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        combs = new long[n + 1][n + 1];

        calculateCombs(n);

        long answer = 0;

        for (int i = 1; i <= n; i++) {
            long temp = (long) ((pow(20, i) * (double) combs[n][i]) % MOD);
            temp = (long) ((temp * (double) pow(7, n - i)) % MOD);
            answer = (long) ((answer + temp) % MOD);

            if (answer < 0) {
                System.err.println("Main loop " + i);
                System.err.println("\t " + temp);
                System.err.println("\t " + pow(20, i));
                System.err.println("\t " + combs[n][i]);
            }
        }

        System.out.print(answer);
    }

    public static long pow(int x, long n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        long half = pow(x, n / 2);

        return (long) ((half * half * (n % 2 == 1 ? x : 1)) % MOD);
    }

    public static void calculateCombs(int n) {

        combs[1][1] = 1;
        for (int j = 1; j <= n; j++) {
            combs[j][0] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                combs[i][j] = (long) ((combs[i - 1][j] + combs[i - 1][j - 1]) % MOD);
                if (combs[i][j] < 0) {
                    System.err.println("calculateCombs " + i + " " + j);
                }
            }
        }
    }
}
