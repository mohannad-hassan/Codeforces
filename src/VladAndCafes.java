import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by MohannadHassanPersonal on 11/12/17.
 */
public class VladAndCafes {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] places = new int[input.length];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            places[i] = Integer.parseInt(input[i]);
            map.put(places[i], i);
        }

        int minVal = Integer.MAX_VALUE;
        int minPlace = 0;
        for (Integer place : map.keySet()) {
            int val = map.get(place);
            if (val < minVal) {
                minVal = val;
                minPlace = place;
            }
        }
        System.out.println(minPlace);
    }
}
