import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 3/15/17.
 */
public class AntonAndFairyTale {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        long cap = Long.parseLong(input[0]);
        long ship = Long.parseLong(input[1]);

        long a = 1;
        long b = 3;
        long c = -2 * cap;

        double sqrt = Math.sqrt(b * b - 4 * c);

        long sqrtFloor = (long) Math.floor(sqrt);
        long sqrtCeil = (long) Math.ceil(sqrt);

        long sol1 = (sqrtFloor - b) / 2 ;
        long sol2 = (sqrtCeil - b) / 2 ;

        long sol;
        if (sol1 * sol1 + 3 * sol1 - 2 * cap <= 0) {
            sol = sol1;
        }
        else {
            sol = sol2;
        }

        if (cap <= ship) {
            System.out.println(ship + 1);
        }
        else {
            int add = 0;
            if (ship == 1 && cap % 2 == 1)
                add = 1;
            System.out.println(sol + ship + 1 + add);
        }

    }
}
