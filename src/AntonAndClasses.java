import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by mohannadhassan on 3/15/17.
 */
public class AntonAndClasses {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, List<Integer>> nStarts = new TreeMap<>();
        TreeMap<Integer, List<Integer>> nEnds = new TreeMap<>();
        populateMaps(br, nStarts, nEnds, n);

        int m = Integer.parseInt(br.readLine());

        TreeMap<Integer, List<Integer>> mStarts = new TreeMap<>();
        TreeMap<Integer, List<Integer>> mEnds = new TreeMap<>();
        populateMaps(br, mStarts, mEnds, m);

        int max = 0;

        int nEndsBig = nEnds.firstKey();
        int mStartsStart = mStarts.lastKey();

        if (nEndsBig < mStartsStart) {
            int temp = - nEndsBig + mStartsStart;
            if (temp > max) {
                max = temp;
            }
        }

        int mEndsBig = mEnds.firstKey();
        int nStartsStart = nStarts.lastKey();

        if (mEndsBig < nStartsStart) {
            int temp = - mEndsBig + nStartsStart;
            if (temp > max) {
                max = temp;
            }
        }

        System.out.println(max);
    }

    static int doit(TreeMap<Integer, List<Integer>> starts, TreeMap<Integer, List<Integer>> ends) {
        Iterator<Integer> startsIte = starts.keySet().iterator();
        Iterator<Integer> endsIts = ends.descendingKeySet().iterator();

        while (startsIte.hasNext() && endsIts.hasNext()) {
            int startNext = startsIte.next();
            int endsNext = endsIts.next();

            Integer[] startList = starts.get(startNext).toArray(new Integer[0]);
            Integer[] endList = starts.get(endsNext).toArray(new Integer[0]);

            java.util.Arrays.sort(startList);
            java.util.Arrays.sort(endList);
        }

        return 0;
    }

    static void populateMaps(BufferedReader br, TreeMap<Integer, List<Integer>> nStarts,
                             TreeMap<Integer, List<Integer>> nEnds, int length)  throws IOException{
        for (int i = 0; i < length; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            updateList(nStarts, start, end);
            updateList(nEnds, end, start);
        }
    }

    static void updateList(TreeMap<Integer, List<Integer>> map, int index, int value) {
        List<Integer> list = map.get(index);
        if (list == null) {
            list = new LinkedList<>();
            map.put(index, list);
        }
        list.add(value);
    }
}
