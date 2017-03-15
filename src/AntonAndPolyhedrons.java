import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mohannadhassan on 3/15/17.
 */
public class AntonAndPolyhedrons {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            switch (s) {
                case "Tetrahedron": cnt += 4; break;
                case "Cube": cnt += 6; break;
                case "Octahedron": cnt += 8; break;
                case "Dodecahedron": cnt += 12; break;
                case "Icosahedron": cnt += 20; break;
            }
        }

        System.out.println(cnt);
    }

}
