import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 5/16/16.
 */
public class InfiniteSequence {



    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        if (a == b) {
            System.out.println("YES");
        }
        else if (c == 0) {
            System.out.println("NO");
        }
        else if ((b - a) % c == 0) {
            if (b > a && c > 0) {
                System.out.println("YES");
            }
            else if(b < a && c < 0) {
                System.out.println("YES");
            }
            else  {
                System.out.println("NO");
            }
        }
        else  {
            System.out.println("NO");
        }
    }
}
