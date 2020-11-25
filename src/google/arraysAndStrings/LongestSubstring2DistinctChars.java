package google.arraysAndStrings;

import java.util.Collections;
import java.util.HashMap;

public class LongestSubstring2DistinctChars {
    public static void main(String[] args) {
        System.out.println("Length of Longest substr of eceba with 2 distinct chars:"+ lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if(n<=2) {
            return n;
        }
        HashMap<Character, Integer> charMap =  new HashMap<Character, Integer>();
        int maxlen = 0;
        int l=0, r=0;
        while(r<n) {
            if(charMap.size() <=2) {
                charMap.put(s.charAt(r), r++);
            }
            if(charMap.size() >2) {
                int del_index = Collections.min(charMap.values());
                charMap.remove(s.charAt(del_index));
                l = del_index+1;
            }
            maxlen = Math.max(maxlen, r-l);
        }
        return maxlen;
    }
}
