import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by MohannadHassanPersonal on 11/17/17.
 */
public class Greed {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        int [] capacities = new int[count];
        long allSoda = 0;

        String [] input = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            allSoda += Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            capacities[i] = Integer.parseInt(input[i]);
        }

        java.util.Arrays.sort(capacities);

        long biggestTwoCans = ((long) capacities[count - 1]) + capacities[count - 2];

        if (biggestTwoCans < allSoda)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}
