import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MohannadHassanPersonal on 4/29/16.
 */
public class PouringRain {

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = br.readLine().split(" ");

        int d = Integer.parseInt(array[0]);
        int h = Integer.parseInt(array[1]);
        int e = Integer.parseInt(array[2]);
        int v = Integer.parseInt(array[3]);

        double r = d / 2.0;
        double e2 = e / (Math.PI * r * r);

        if (e2 > v) {
            System.out.println("YES");
            double t = h / (e2 - v);
            System.out.println(t);
        }
        else  {
            System.out.println("NO");
        }
    }
}
