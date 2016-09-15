import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 9/14/16.
 */
public class MemoryAndDeEvolution {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);

        int a = target, b = target, c = target;

        int turns = 0;
        while (true) {
            if (a >= start && b >= start && c >= start)
                break;
            if (turns % 3 == 0) {
                a = b + c - 1;
            }
            else if (turns % 3 == 1) {
                b = a + c - 1;
            }
            else {
                c = a + b - 1;
            }
            turns++;
        }

        System.out.println(turns);
    }
}
