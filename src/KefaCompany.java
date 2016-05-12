import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by mohannadhassan on 9/22/15.
 */
public class KefaCompany {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);

        int [] money = new int[n];
        int [] friendship = new int[n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            money[i] = Integer.parseInt(input[0]);
            friendship[i] = Integer.parseInt(input[1]);
        }

        ArrayList<KefaCompanyEntry> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            
//            list.add(new KefaCompanyEntry());
        }
    }
}

class KefaCompanyEntry {

    HashSet<Integer>reps;
    HashSet<Integer>connections;

    public KefaCompanyEntry(HashSet<Integer> connections, HashSet<Integer> reps) {
        this.connections = connections;
        this.reps = reps;
    }

    @Override
    public String toString() {
        return getSetString(reps) + " --> " + getSetString(connections);
    }

    String getSetString(HashSet<Integer> set) {
        String s = "";
        for (Iterator<Integer> ite = set.iterator(); ite.hasNext();) {
            s += ite.next() + ", ";
        }
        return s.substring(0, s.length() - 2);
    }
}
