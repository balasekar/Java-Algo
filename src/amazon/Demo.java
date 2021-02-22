package amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("sol.canJump(new int[]{2,3,1,1,4}):: "+sol.solution(new int[]{1, 3, 6, 4, 1, 2}));
    }
}

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int n = A.length;
        int max = A[n-1];

        Set<Integer> numSet = new HashSet<>();
        for(Integer a : A) {
            numSet.add(a);
        }

        for(int i =1; i<max; i++) {
            if(!numSet.contains(i))
                return i;
        }
        return 0;
    }
}
