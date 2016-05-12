import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ToyCars {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [][] collisions = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String [] input = br.readLine().split("[ ]+");
			for (int j = 0; j < n; j++) {
				collisions[i][j] = Integer.parseInt(input[j]);
			}
		}

		int goodCars = 0;
		ArrayList<Integer> list = new ArrayList<Integer>(n);
		
		for (int i = 0; i < n; i++) {
			boolean isGood = true;
			for (int j = 0; j < n && isGood; j++) {
				if (collisions[i][j] == 1 || collisions[i][j] == 3)
					isGood = false;
			}
			if (isGood) {
				goodCars ++;
				list.add(i + 1);
			}
		}
		
		System.out.println(goodCars);
		if (goodCars > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i != 0)
					System.out.print(" ");
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}

}
