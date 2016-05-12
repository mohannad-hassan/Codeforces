import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AAndBAndTeamTraining {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int a, b;
		
		if (n > m) {
			a = n;
			b = m;
		}
		else {
			b = n;
			a = m;
		}
		
		int count = 0;
		
		int add = a >= 2 * b ? b : a / 2;
		
		count += add;
		a -= add * 2;
		b -= add;
		
		if (a != 0 && b >= 2) {
			count ++;
		}
		
		System.out.println(count);
	}

}
