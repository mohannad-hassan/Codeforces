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

        PriorityQueue<MikeAndShortcutsPair> queue = new PriorityQueue<>(n);
        int [] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = i;
            queue.add(new MikeAndShortcutsPair(i, i));
        }

        boolean []visited = new boolean[n];

        while (!queue.isEmpty()) {
            MikeAndShortcutsPair top = queue.poll();
            int temp = shortCuts[top.node];
            visited[top.node] = true;
            int curDist = top.distance;
            if (temp != top.node) {
                for (int i = temp; i > 0; i--) {
                    int newDist = curDist + temp - i + 1;
                    if (visited[i] || distance[i] <= newDist) {
                        break;
                    }
                    distance[i] = newDist;
                    int newI = i;
                    queue.removeIf(o -> o.node == newI);
                    queue.add(new MikeAndShortcutsPair(i, newDist));
                }
                for (int i = temp + 1; i < n; i++) {
                    int newDist = curDist + i - temp + 1;
                    if (visited[i] || distance[i] <= newDist) {
                        break;
                    }
                    distance[i] = newDist;
                    int newI = i;
                    queue.removeIf(o -> o.node == newI);
                    queue.add(new MikeAndShortcutsPair(i, newDist));
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

class MikeAndShortcutsPair implements Comparable<MikeAndShortcutsPair>{
    int node;
    int distance;

    public MikeAndShortcutsPair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(MikeAndShortcutsPair o) {
        return distance - o.distance;
    }

    @Override
    public String toString() {
        return node + " - Distance: " + distance;
    }
}