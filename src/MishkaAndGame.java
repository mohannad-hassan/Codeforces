import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 8/4/16.
 */
public class MishkaAndGame {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            int m = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);

            if (m > c)
                count++;
            else if (m < c)
                count--;
        }

        if (count > 0)
            System.out.println("Mishka");
        else if (count < 0)
            System.out.println("Chris");
        else
            System.out.println("Friendship is magic!^^");

    }
}
