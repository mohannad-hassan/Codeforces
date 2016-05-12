import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PashaAndString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		char [] charArray = input.toCharArray();
		
		br.readLine();
		
		String [] poses = br.readLine().split("[ ]+");
		
		for (int i = 0; i < poses.length; i++) {
			int pos = Integer.parseInt(poses[i]) - 1;
			for (int j = pos; j < input.length() / 2; j++) {
				char temp = charArray[j];
				charArray[j] = charArray[input.length() - j - 1];
				charArray[input.length() - j - 1] = temp;
			}
		}
		
		System.out.println(new String(charArray));
	}

}
