import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by mohannadhassan on 5/25/16.
 */
public class VasyaAndString {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        String s = br.readLine();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<VasyaAndStringPair> sorte = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int j;
            for (j = i + 1; j < n && s.charAt(i) == s.charAt(j); j++);

            int length = j - i;
            list.add(length);
            sorte.add(new VasyaAndStringPair(length, list.size() - 1));
        }

        int max = 1;
        for (VasyaAndStringPair pair :
                sorte) {
            int index = pair.index;

            int left = index - 1;
            int right = index + 1;

            int temp = k;
            int total = pair.count;

            if (total + k <= max) {
                break;
            }
            while (temp > 0 && (left >= 0 || right < list.size())) {
                int toAdd = 0;
                int blah = -1;
                if (left > 0 && (right >= list.size() || list.get(left) > list.get(right))) {
                    toAdd = list.get(left);
                    left -= 2;
                    blah = left;
                }
                else if (right < list.size() && (left < 0 || list.get(right) > list.get(left))){
                    toAdd = list.get(right);
                    right += 2;
                    blah = right;
                }
                if (toAdd > temp) {
                    toAdd = temp;
                }
                temp -= toAdd;
                total += toAdd;

                if (blah >= 0 && blah < list.size()) {
                    total += list.get(blah);
                }
            }

            if (total > max) {
                max = total;
            }
        }
        System.out.println(max);
    }
}

class VasyaAndStringPair implements Comparator<VasyaAndStringPair>{
    int count;
    int index;

    public VasyaAndStringPair(int count, int index) {
        this.count = count;
        this.index = index;
    }

    @Override
    public int compare(VasyaAndStringPair o1, VasyaAndStringPair o2) {
        return o2.count - o1.count;
    }
}