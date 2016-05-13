import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 2/20/16.
 */
public class BabaeiBirthdayCake {

    static long vols[];
    static long dp[];
    static int next[];

    static long answer;

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        vols = new long[n];
        for (int i = 0; i < n; i++) {
            String [] array = br.readLine().split(" ");
            int rad = Integer.parseInt(array[0]);
            int height = Integer.parseInt(array[1]);
            vols[i] = rad * (long)rad * ((long)height);
        }

        dp = new long[n];
        next = new int[n];
        answer = 0;

        solve();
        System.out.printf("%.7f", answer * Math.PI);
    }

    public static void solve() {
        for (int i = vols.length - 1; i >= 0; i--) {
            solve(i);
            if (dp[i] > answer) {
                answer = dp[i];
            }
        }
    }

    public static void solve(int index) {
        int compareIndex = index + 1;
        while (compareIndex < vols.length && compareIndex != -1 && dp[index] == 0) {
            if (vols[compareIndex] > vols[index]) {
                dp[index] = vols[index] + dp[compareIndex];
                next[index] = compareIndex;
            }
            else  {
                compareIndex = next[compareIndex];
            }
        }
        if (dp[index] == 0) {
            dp[index] = vols[index];
            next[index] = -1;
        }
    }
}
