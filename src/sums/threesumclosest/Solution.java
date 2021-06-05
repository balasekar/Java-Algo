package sums.threesumclosest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2];
        for(int i=0; i<nums.length-3 && closest != target; i++) {
            int low = i+1;
            int high = nums.length-1;

            while(low<high) {
                int currSum = nums[i]+nums[low]+nums[high];
                if(Math.abs(target - currSum) < Math.abs(target-closest)) {
                    closest = target-currSum;
                }

                if(currSum > target) {
                    high--;
                } else if(currSum < target) {
                    low++;
                } else {
                    break;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Three sum closest :"+sol.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
    }
}
