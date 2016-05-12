import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mohannadhassan on 2/4/16.
 */
public class GraphString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int [] similar = new int [n];
        int [] pos = new int[n];

        for (int i = 0; i < n; i++) {
            similar[i] = -1;
        }

        HashSet<Integer> [] sets = new HashSet[n];

        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
            sets[i].add(i);
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            int s1 = Integer.parseInt(input[0]) - 1;
            int s2 = Integer.parseInt(input[1]) - 1;

            sets[s1].add(s2);
            sets[s2].add(s1);
        }

        boolean correct = true;

        for (int i = 0; i < n && correct; i++) {
            Set<Integer> set = sets[i];

            for (Integer j : set) {
                if (j <= i)
                    continue;
                Set<Integer> jSet = sets[j];
                Set<Integer> union = new HashSet<>(set);
                union.addAll(jSet);
                Set<Integer> inter = new HashSet<>(set);
                inter.retainAll(jSet);

                if (union.size() == set.size()) {

                    if (similar[i] != -1) {
                        if (similar[j] == -1)
                            similar[j] = similar[i];
                        else if (similar[j] != similar[i]) {
                            correct = false;
                            break;
                        }
                    }
                    else if (similar[j] == -1){
                        similar[j] = i;
                    }
                    else  {
                        correct = false;
                        break;
                    }
                }
                else if (set.containsAll(union)){
                    if (similar[i] != -1 && pos[similar[i]] == 2) {
                        correct = false;
                        break;
                    }
                    if (similar[j] != -1 && pos[similar[j]] == 1){
                        correct = false;
                        break;
                    }
                    pos[i] = 1;
                    pos[j] = 2;
                }
                else if (jSet.containsAll(union)){
                    if (similar[j] != -1 && pos[similar[j]] == 2) {
                        correct = false;
                        break;
                    }
                    if (similar[i] != -1 && pos[similar[i]] == 1){
                        correct = false;
                        break;
                    }
                    pos[j] = 1;
                    pos[i] = 2;
                }
                else {
                    correct = false;
                    break;
                }
            }
        }

        int count = 0;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> grpPos = new HashMap<>();

        for (int i = 0; correct && i < n; i++) {
            if (similar[i] == -1) {
                count++;
                ArrayList<Integer> temp = new ArrayList<>();
                map.put(i, temp);
                temp.add(i);
                grpPos.put(i, pos[i]);
            }
            else {
                map.get(similar[i]).add(i);
                if (grpPos.get(similar[i]) != pos[i]) {
                    correct = false;
                }
            }
            if (count > 3) {
                correct = false;
            }
        }

        for (ArrayList<Integer> grp: map.values() ) {
            Set<Integer> set = sets[grp.get(0)];
            for (int i : grp) {
                set.addAll(sets[i]);
                if (set.size() != sets[i].size()) {
                    correct = false;
                    break;
                }
            }
            if (!correct)
                break;
        }

        if (!correct) {
            System.out.println("No");
        }
        else  {
            System.out.println("Yes");

            char [] res = new char[n];
            boolean useA = false;
            for (int i : grpPos.keySet()) {
                if (grpPos.get(i) == 1) {
                    for (int j : map.get(i)) {
                        res[j] = 'b';
                    }
                }
                else if (!useA){
                    useA = true;
                    for (int j : map.get(i)) {
                        res[j] = 'a';
                    }
                }
                else  {
                    for (int j : map.get(i)) {
                        res[j] = 'c';
                    }
                }
            }

            System.out.println(new String(res));
        }

    }
}
