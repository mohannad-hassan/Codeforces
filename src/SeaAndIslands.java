import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SeaAndIslands {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String []input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		int allCells = n * n;
		
		if((allCells % 2 == 0 && k > allCells / 2) || (allCells % 2 == 1 && 2 * k > allCells + 1)) {
			System.out.println("NO");
			return;
		}
		
		boolean [][]map = new boolean[n][n];
		
		int islands = 0;
		for (int i = 0; i < n && islands < k; i++) {
			int j = 0;
			if (i % 2 == 1)
				j = 1;
			for(; j < n && islands < k; j += 2) {
				map[i][j] = true;
				islands++;
			}
		}
		System.out.println("YES");
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				System.out.print(map[i][j] ? 'L' : 'S');
			System.out.println();
		}
	}

}
