import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 9/17/16.
 */
public class PlusAndSquareRoot {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long screen = 2;
        int level = 1;

        while (level <= n) {
            long next = screen;
            while (next != -1) {
                if (next < (level + 1))
                    next = (long)Math.ceil(((level + 1) / (double)next)) * next;
                while (next % (level + 1) != 0)
                    next += (level + 1 ) - (next - (next / (level + 1)) * (level + 1));
                long square = next * next;
                if ((square - screen) % level == 0) {
                    System.out.println((square - screen) / level);
                    screen = next;
                    level ++;
                    next = -1;
                }
                else {
                    next += level + 1;
                }
            }
        }
    }
}
