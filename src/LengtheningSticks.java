import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LengtheningSticks {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int [] startLeng = new int[3];
        for (int i = 0; i < startLeng.length; i++) {
            startLeng[i] = Integer.parseInt(input[i]);
        }
        int l = Integer.parseInt(input[3]);

        long sol = 0;

        if (check(startLeng))
            sol++;

        if (!checkSolution(startLeng, l)) {
            System.out.println("0");
            return;
        }

        java.util.Queue<int []> q0 = new LinkedList<>();
        q0.add(startLeng);

        java.util.Queue<int []> q1 = new LinkedList<>();

        HashSet<String> set = new HashSet<>();
        set.add(arrToStr(startLeng));
        while (l > 0) {
            while (!q0.isEmpty()) {
                int [] sticks = q0.poll();

                for (int i = 0; i < sticks.length; i++) {
                    int [] temp = add1(sticks, i);

                    String id = arrToStr(temp);
                    if (set.contains(id)) {
                        continue;
                    }
                    set.add(id);

                    if (check(temp))
                        sol++;
                    if (checkSolution(temp, l - 1)) {
                        q1.add(temp);
                    }

                }
            }
            q0 = q1;
            q1 = new LinkedList<>();
            l--;
        }

        System.out.println(sol);
    }

    private static boolean check(int [] lengs) {
        int [][] poses = {{0, 1, 2}, {0, 2, 1}, {1, 2, 0}};

        for (int [] pos : poses) {
            if (lengs[pos[2]] >= lengs[pos[1]] + lengs[pos[0]])
                return false;
        }

        return true;
    }

    private static boolean checkSolution(int [] lengs, int l) {

        int [][] poses = {{0, 1, 2}, {0, 2, 1}, {1, 2, 0}};

        for (int [] pos : poses) {
            if (lengs[pos[2]] >= lengs[pos[1]] + lengs[pos[0]] + l)
                return false;
        }

        return true;
    }

    private static int [] add1(int [] lengs, int j) {
        int [] sol = new int[lengs.length];
        for (int i = 0; i < lengs.length; i++) {
            sol[i] = lengs[i];
        }
        sol[j]++;
        return sol;
    }

    private static String arrToStr(int [] arr) {
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
            if (i != arr.length - 1) {
                s += " ";
            }
        }
        return s;
    }
}
