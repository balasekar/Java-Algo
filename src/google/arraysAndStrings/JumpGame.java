package google.arraysAndStrings;

public class JumpGame {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("sol.canJump(new int[]{2,3,1,1,4}):: "+sol.canJump(new int[]{2,3,1,1,4}));
        System.out.println("sol.canJump(new int[]{3,2,1,0,4}):: "+sol.canJump(new int[]{3,2,1,0,4}));
    }
}

 class Solution {
    public boolean canJump(int[] nums) {
        int furthestPos = 0;
        for(int i=0; i<nums.length && i <= furthestPos; i++) {
            furthestPos = Math.max(furthestPos, i+nums[i]);
            if(furthestPos >= nums.length-1) return true;
        }
        return false;
    }
}
