package sums.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>  ans = new ArrayList<>();

        for(int i=0; i<nums.length && nums[i]<0; i++) {
            if(i == 0 || nums[i-1] != nums[i]) {
                this.twoSum(nums, i, ans);
            }
        }

        return ans;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> ans) {
        Set<Integer> seen = new HashSet<>();
        for(int j = i+1; j<nums.length; j++) {
            int complement = -nums[i]-nums[j];
            if(seen.contains(complement)) {
                ans.add(Arrays.asList(nums[i], nums[j], complement));
                while(j+1<nums.length && nums[j+1] == nums[j]) ++j;
            }
            seen.add(nums[j]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Three SUM :"+ sol.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }
}
