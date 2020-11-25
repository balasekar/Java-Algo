package google.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        System.out.println("missing range for 0,1,3,50,75 list with boundaries 0, 99 :: "+ findMissingRanges(new int[]{0,1,3,50,75}, 0, 99));
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<String>();
        for(int val : nums) {
            if(val > lower) {
                ans.add(getRange(lower, val-1));
            }
            lower = val+1;
        }
        if(lower <= upper) {
            ans.add(getRange(lower, upper));
        }
        return ans;
    }

    public static String getRange(int n1, int n2) {
        if(n1==n2) {
            return String.valueOf(n1);
        } else {
            return String.format("%d->%d", n1, n2);
        }
    }
}
