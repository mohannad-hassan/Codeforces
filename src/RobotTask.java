import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 10/3/15.
 */
public class RobotTask {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] input = br.readLine().split(" ");
        int [] array = new int [n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int info = 0;
        int changes = 0;
        int direction = 1;

        int index = 0;
        while (info < n) {
            if (array[index] != -1 && array[index] <= info) {
                info++;
                array[index] = -1;
            }
            if (info == n) {
                break;
            }
            if (index + direction < 0 || index + direction >= n) {
                direction *= -1;
                changes++;
            }
            index += direction;
        }

        System.out.println(changes);
    }
}
