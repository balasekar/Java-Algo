package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        Map<Character, Integer> charLocationMap = new HashMap<>();

        for(int i=0, j=0; j<n; j++) {
            char ch = s.charAt(j);
            if(charLocationMap.containsKey(ch)) {
                i = Math.max(i, charLocationMap.get(ch));
            }
            maxLen = Math.max(maxLen, j-i+1);
            charLocationMap.put(ch, j+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution soln = new Solution();
        System.out.println("longest Sub String len:"+soln.lengthOfLongestSubstring("abcdeafbdge"));
    }
}
