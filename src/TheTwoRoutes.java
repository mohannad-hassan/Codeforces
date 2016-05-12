import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by mohannadhassan on 11/24/15.
 */
public class TheTwoRoutes {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        boolean [][] matrix = new boolean[n + 1][n + 1];

        LinkedList <Integer> [] trainAdj = new LinkedList[n + 1];
        LinkedList <Integer> [] busAdj = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            trainAdj[i] = new LinkedList<>();
            busAdj[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            matrix[u][v] = matrix[v][u] = true;
            trainAdj[u].add(v);
            trainAdj[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (!matrix[i][j]) {
                    busAdj[i].add(j);
                    busAdj[j].add(i);
                }
            }
        }

        LinkedList<Integer> busRoute = visit(busAdj);
        LinkedList<Integer> trainRoute = visit(trainAdj);

        if (busRoute == null || trainRoute == null) {
            System.out.println(-1);
            return;
        }

        int busLen = busRoute.size();
        int trainLen = trainRoute.size();

        Integer [] busArr = busRoute.toArray(new Integer [0]);
        Integer [] trainArr = trainRoute.toArray(new Integer [0]);

        int i = 1, j = 1;

        while (i < busArr.length - 1 && j < trainArr.length - 1) {
            if (busArr[i] == trainArr[j]) {
                if (busLen < trainLen) {
                    busLen += 2;
                    j += 1;
                }
                else  {
                    trainLen += 2;
                    i += 1;
                }
            }
            else {
                i++;
                j++;
            }
        }

        System.out.println((busLen > trainLen ? busLen : trainLen) - 1);
    }

    public static LinkedList<Integer> visit(LinkedList<Integer>[] adjList) {
        int [] parent = new int[adjList.length];
        boolean [] visited = new boolean[adjList.length];

        visited[1] = true;

        java.util.Queue<Integer> q0 = new LinkedList<>();
        q0.add(1);

        while (!q0.isEmpty()) {
            java.util.Queue<Integer> q1 = new LinkedList<>();
            while (!q0.isEmpty()) {
                int next = q0.poll();
                visited[next] = true;
                if (next == adjList.length - 1) {
                    LinkedList<Integer> route = new LinkedList<>();
                    Stack<Integer> stack = new Stack<>();

                    int temp = next;
                    while (temp != 0) {
                        stack.add(temp);
                        temp = parent[temp];
                    }

                    while (!stack.isEmpty()) {
                        route.add(stack.pop());
                    }

                    return route;
                }
                else  {
                    Iterator <Integer> adjIte = adjList[next].iterator();

                    while (adjIte.hasNext()) {
                        int temp = adjIte.next();
                        if (!visited[temp] && parent[temp] == 0) {
                            parent[temp] = next;
                            q1.add(temp);
                        }
                    }
                }
            }
            q0 = q1;
        }

        return null;
    }
}
