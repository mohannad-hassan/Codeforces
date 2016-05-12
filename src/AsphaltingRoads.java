import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by mohannadhassan on 10/3/15.
 */
public class AsphaltingRoads {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean []v = new boolean[n];
        boolean []h = new boolean[n];

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n * n ; i++) {
            String [] input = br.readLine().split(" ");
            int tempV = Integer.parseInt(input[0]) - 1;
            int tempH = Integer.parseInt(input[1]) - 1;

            if (!v[tempV] && !h[tempH]) {
                v[tempV] = true;
                h[tempH] = true;
                list.add(i);
            }
        }

        boolean flag = false;
        for (int i : list) {
            if (flag)
                System.out.print(' ');
            else
                flag = true;
            System.out.print(i);
        }
        System.out.println();
    }
}
