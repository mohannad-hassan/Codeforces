import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Queue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] list = new int[n];

		String [] input = br.readLine().split("[ ]+");
		for (int i = 0; i < n; i++)
			list[i] = Integer.parseInt(input[i]);
		Arrays.sort(list);
		
		int [] latency = new int[n];
		latency[0] = list[0];
		int count = 1;
		
		for (int i = 1; i < n; i++) {
			if (latency[i - 1] <= list[i]) {
				count++;
				latency[i] = latency[i - 1] + list[i];
			}
			else {
				latency[i] = latency[i - 1];
			}
		}
		
		System.out.println(count);
	}

}
