import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by MohannadHassanPersonal on 7/6/16.
 */
public class MikeAndShortcuts {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] input = br.readLine().split(" ");

        int [] shortCuts = new int[n];
        for (int i = 0; i < n; i++) {
            shortCuts[i] = Integer.parseInt(input[i]) - 1;
        }

        int [] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = i;
        }

        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int workIndex = start;
            start++;

            int shortCut = shortCuts[workIndex];

            if (shortCut >= start && shortCut <= end) {
                if (distance[shortCut] > distance[workIndex] + 1) {
                    distance[shortCut] = distance[workIndex] + 1;
                    int backward = shortCut - 1;
                    int newDist = distance[shortCut] + 1;
                    while (backward >= start && distance[backward] > newDist) {
                        distance[backward] = newDist;
                        newDist++;
                        backward--;
                    }

                    int foreword = shortCut + 1;
                    newDist = distance[shortCut] + 1;
                    while (foreword <= end && distance[foreword] > newDist) {
                        distance[foreword] = newDist;
                        newDist++;
                        foreword++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(distance[i]);
            if (i < n - 1) {
                sb.append(' ');
            }
        }

        System.out.println(sb.toString());
    }
}