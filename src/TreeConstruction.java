import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Created by mohannadhassan on 5/16/16.
 */
public class TreeConstruction {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        String[] input = temp.split(" ");

        StringBuilder builder = new StringBuilder(temp.length());

        TreeMap<Integer, Integer> tree = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int newVal = Integer.parseInt(input[i]);
            Integer floor = tree.lowerKey(newVal);
            Integer ceil = tree.ceilingKey(newVal);

            if (i > 1) {
                builder.append(" ");
            }

            if (floor == null && ceil == null) {
            }
            else if (floor == null) {
                builder.append(ceil.intValue());
            }
            else if (ceil == null) {
                builder.append(floor.intValue());
            }
            else {
                if (tree.get(floor) > tree.get(ceil)) {
                    builder.append(floor.intValue());
                }
                else {
                    builder.append(ceil.intValue());
                }
            }
            tree.put(newVal, i);
        }


        System.out.println(builder.toString());
    }
}