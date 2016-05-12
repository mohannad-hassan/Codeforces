import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 11/24/15.
 */
public class TwoBases {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int nx = Integer.parseInt(input[0]);
        int bx = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        long x = 0;

        for (int i = 0; i < nx; i++) {
            x *= bx;
            x += Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        int ny = Integer.parseInt(input[0]);
        int by = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        long y = 0;

        for (int i = 0; i < ny; i++) {
            y *= by;
            y += Integer.parseInt(input[i]);
        }

        if (x < y)
            System.out.println("<");
        else if (x > y)
            System.out.println(">");
        else
            System.out.println("=");
    }

}
