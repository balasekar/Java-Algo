package amazon;

import java.util.LinkedList;

public class Problem1 {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int [] ans = sol.solution(new int[]{6,1}, 1,1);
        for(int a : ans) {
            System.out.println(a);
        }
    }
}

class Solution1 {
    public int[] solution(int[] A, int F, int M) {
        int n = A.length;
        int totalRolls = n+F;
        int sumOfRolls = (totalRolls * M);
        int knownSum = 0;
        for(int a : A) {
            knownSum += a;
        }
        int forgottenSum = sumOfRolls - knownSum;

        int[] ans = findPossibleRolls(forgottenSum, F, new LinkedList<>());
        if(ans.length > 0) return ans;
        return new int[] {0};
    }

    public int[] findPossibleRolls(int sum, int n, LinkedList<Integer> rolls) {
        if(sum < 0 || n < 0 || (sum > n*6) ) return new int []{};
        if(sum == 0 && n == 0) return rolls.stream().mapToInt(i -> i).toArray();
        if(n == 1 && sum <=6) {
            rolls.add(sum);
            return rolls.stream().mapToInt(i->i).toArray();
        }

        for (int i = 1; i <=6; i++) {
            rolls.add(i);
            int[] possibleValue = findPossibleRolls(sum-i, n-1, rolls);
            if(possibleValue.length > 0) {
                return possibleValue;
            }
            rolls.remove();
        }
        return new int[]{0};
    }
}
