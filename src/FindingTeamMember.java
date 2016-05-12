import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by mohannadhassan on 9/16/15.
 */
public class FindingTeamMember {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        FindingTeamMemberStruct [] arr = new FindingTeamMemberStruct[2 * n * n - n ];
        int index = 0;

        for (int i = 1; i < 2 * n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {

                arr[index++] = new FindingTeamMemberStruct(i, j, Integer.parseInt(input[j]));
            }
        }

        java.util.Arrays.sort(arr);

        LinkedList<FindingTeamMemberStruct> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        int [] sol = new int[n * 2];
        Set<Integer> excludeList = new HashSet<>();

        while (!list.isEmpty()) {
            FindingTeamMemberStruct struct = list.remove();

            if (!excludeList.contains(struct.i) && !excludeList.contains(struct.j)) {
                sol[struct.i] = struct.j;
                sol[struct.j] = struct.i;
                excludeList.add(struct.i);
                excludeList.add(struct.j);
            }


//            Stack<FindingTeamMemberStruct> toRemove = new Stack<>();
//            for (Iterator<FindingTeamMemberStruct> ite = list.iterator(); ite.hasNext(); ) {
//                FindingTeamMemberStruct temp = ite.next();
//                if (temp.i == struct.i || temp.i == struct.j || temp.j == struct.j || temp.j == struct.i) {
//                    toRemove.add(temp);
//                }
//            }
//
//            list.removeAll(toRemove);
        }

        for (int i = 0; i < sol.length; i++) {
            System.out.print(sol[i] + 1);
            if (i < sol.length - 1) {
                System.out.print(' ');
            }
        }
        System.out.println();
    }
}

class FindingTeamMemberStruct implements Comparable<FindingTeamMemberStruct>{
    int i;
    int j;
    int amount;

    public FindingTeamMemberStruct(int i, int j, int amount) {
        this.j = j;
        this.i = i;
        this.amount = amount;
    }

    @Override
    public int compareTo(FindingTeamMemberStruct o) {
        return o.amount - this.amount;
    }

    @Override
    public String toString() {
        return "(" + i + ", " + j + "): " + amount;
    }
}
