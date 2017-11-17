import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 11/17/17.
 */
public class Wrath {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        String [] input = br.readLine().split(" ");

        int[] lengths = new int[count];

        for (int i = 0; i < count; i++) {
            lengths[i] = Integer.parseInt(input[i]);
        }

        boolean [] isDead = new boolean[count];

        int current = count - 1;

        while (current > 0) {
            int length = lengths[current];
            int end = current - length;

            int next = current - 1;
            int endOfNext = next - lengths[next];

            for (int i = current - 1; i >= end && i >= 0; i--) {
                isDead[i] = true;
                int endOfDead = i - lengths[i];
                if (endOfDead < end) {
                    if (endOfDead < endOfNext) {
                        next = i;
                        endOfNext = endOfDead;
                    }
                }
            }

            current = next;
        }

        int alive = 0;
        for (int i = 0; i < count; i++) {
            if (!isDead[i]) {
                alive++;
            }
        }

        System.out.println(alive);
    }
}
