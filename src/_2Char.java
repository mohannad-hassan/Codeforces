import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by mohannadhassan on 11/4/15.
 */
public class _2Char {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<Character, HashSet<Integer> >map = new HashMap<>();
        HashMap<Integer, Integer> lengths = new HashMap<>();
        HashMap<Integer, HashSet<Character> >chars = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; set.size() <= 2 && j < s.length(); j++)
                set.add(s.charAt(j));
            if (set.size() <= 2) {
                for (Character c : set) {
                    HashSet<Integer>list = map.get(c);
                    if (list == null) {
                        list = new HashSet<>();
                        map.put(c, list);
                    }
                    list.add(i);
                    chars.put(i, set);
                }
                lengths.put(i, s.length());
            }
        }

        Character [] array = map.keySet().toArray(new Character [0]);

        int max = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int cnt = 0;
                HashSet<Integer> s1 = map.get(array[i]);
                HashSet<Integer> s2 = map.get(array[j]);

                if (i == j) {
                    for (Integer index : s2) {
                        if(chars.get(index).size() == 1){
                            cnt += lengths.get(index);
                        }
                    }
                }
                else {
                    for (Integer index : s1) {
                        if (s2.contains(index)) {
                            cnt += lengths.get(index);
                        }
                        else if(chars.get(index).size() == 1){
                            cnt += lengths.get(index);
                        }
                    }
                    for (Integer index : s2) {
                        if(chars.get(index).size() == 1){
                            cnt += lengths.get(index);
                        }
                    }
                }

                if (cnt > max) {
                    max = cnt;
                }
            }
        }

        System.out.println(max);
    }
}
