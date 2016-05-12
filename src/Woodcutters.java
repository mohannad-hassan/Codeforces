import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Woodcutters {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] indexes = new int[n];
		int [] heights = new int[n];
		
		for (int i = 0; i < n; i++) {
			String [] input = br.readLine().split("[ ]+");
			indexes[i] = Integer.parseInt(input[0]);
			heights[i] = Integer.parseInt(input[1]);
		}
		
		if (n == 1) {
			System.out.println(1);
			return;
		}

		int rightShift [] = new int[n];
		int count = 2;
		
		for (int i = 1; i < n - 1; i++) {
			if (indexes[i] - heights[i] > indexes[i - 1] + rightShift[i - 1])
				count++;
			else if (indexes[i] + heights[i] < indexes[i + 1]) {
				count++;
				rightShift[i] = heights[i];
			}
		}
		System.out.println(count);
	}

}
