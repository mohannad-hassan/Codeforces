import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 9/23/16.
 */
public class AnatolyAndCockroaches {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();

        boolean [] array = new boolean[n];
        for (int i = 0; i < n; i++) {
            array[i] = s.charAt(i) == 'r';
        }

        boolean [] matchesFirst = generate(array[0], n);
        int ans1 = getMoves(matchesFirst, array);

        int answer = -1;
        if (ans1 == 0) {
            answer = ans1;
        }

        if (answer == -1) {
            boolean [] other = generate(!array[0], n);
            int ans2 = getMoves(other, array);

            answer = Math.min(ans1, ans2);
        }

        System.out.println(answer);
    }

    static int getMoves(boolean [] required, boolean [] actual) {

        boolean [] different = new boolean[required.length];

        int r = 0;
        int b = 0;

        for (int i = 0; i < required.length; i++) {
            different[i] = required[i] ^ actual[i];
            if (different[i]) {
                if (actual[i]) {
                    r++;
                }
                else {
                    b++;
                }
            }
        }

        int moves = r + b - Math.min(r, b);

        return moves;
    }

    static boolean [] generate(boolean first, int len) {
        boolean [] result = new boolean[len];
        result[0] = first;

        for (int i = 1; i < len; i++) {
            result[i] = !result[i - 1];
        }

        return result;
    }

}
