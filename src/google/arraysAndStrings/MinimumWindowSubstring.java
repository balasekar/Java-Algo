package google.arraysAndStrings;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println("Min substring of ADOBECODEBANC, ABC :: "+ minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        // Handle empty string
        if(s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for(int i=0; i<t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count+1);
        }

        int required = dictT.size();

        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(dictT.containsKey(c)) {
                filteredS.add(new Pair<Integer, Character>(i,c));
            }
        }

        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int[] ans = {-1, 0, 0};

        while (r < filteredS.size()) {
            char c = filteredS.get(r).getValue();
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count+1);

            if(dictT.containsKey(c)
                    && windowCounts.get(c).intValue() == dictT.get(c).intValue())
            {
                formed++;
            }

            while(l<=r && formed == required) {

                int end = filteredS.get(r).getKey();
                int start = filteredS.get(l).getKey();
                if(ans[0] == -1 || end - start+1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                // Move left pointer if substring already formed
                c = filteredS.get(l).getValue();
                windowCounts.put(c, windowCounts.get(c) -1);
                if(dictT.containsKey(c)
                        && windowCounts.get(c) < dictT.get(c)) {
                    formed--;
                }

                l++;
            }
            r++;
        }

        return ans[0] == -1 ? "": s.substring(ans[1], ans[2]+1);
    }
}
