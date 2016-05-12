import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EquidistantString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();
		
		boolean even = true;
		
		StringBuilder p = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char cs = s.charAt(i), ct = t.charAt(i);
			if(cs == ct) {
				p.append(cs);
			}
			else {
				if (even) {
					p.append(cs);
				}
				else {
					p.append(ct);
				}
				even = !even;
			}
		}

		if (even) {
			System.out.println(p.toString());
		}
		else {
			System.out.println("impossible");
		}
	}

}
