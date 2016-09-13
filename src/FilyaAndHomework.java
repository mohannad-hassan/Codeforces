import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by MohannadHassanPersonal on 9/13/16.
 */
public class FilyaAndHomework {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(input[i]));
        }

        boolean success;
        if (set.size() > 3) {
            success = false;
        }
        else if (set.size() == 3) {
            Integer [] arr = set.toArray(new Integer[3]);
            java.util.Arrays.sort(arr);
            if (arr[2] - arr[1] == arr[1] - arr[0]){
                success = true;
            }
            else {
                success = false;
            }
        }
        else {
            success = true;
        }

        System.out.println(success ? "YES" : "NO");
    }
}
