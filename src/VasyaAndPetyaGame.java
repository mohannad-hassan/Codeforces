import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by mohannadhassan on 9/10/15.
 */
public class VasyaAndPetyaGame {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean []array = new boolean[n + 1];

        int count = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (!array[i]) {
                for (int j = i; j <= n; j *= i) {
                    if (!array[j]) {
                        count++;
                        list.add(j);
                        array[j] = true;
                    }
                }
                for (int j = i; j <= n; j += i)
                    array[j] = true;
            }
        }

        System.out.println(count);
        for (Integer i : list) {
            System.out.print(i);
            System.out.print(' ');
        }
        System.out.println();
    }
}
