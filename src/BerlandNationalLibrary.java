import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by mohannadhassan on 8/5/15.
 */
public class BerlandNationalLibrary {
    public static  void  main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

//        ArrayList<Integer> newComers = new ArrayList<Integer>();
//        HashSet<Integer> oldComers = new HashSet<Integer>();
        int max = 0;
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            String [] input = br.readLine().split(" ");
            if (input[0].charAt(0) == '+') {
                set.add(input[1]);
                if (set.size() > max) {
                    max = set.size();
                }
            }
            else {
                if (set.contains(input[1])) {
                    set.remove(input[1]);
                }
                else {
                    max++;
                }
            }
        }
        System.out.println(max);
    }
}
