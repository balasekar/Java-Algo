package leftRightPointers.trappingWater;

public class Solution {
    public int getTrappedRainWater(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while(left < right) {
            if(height[right] < height[left]) {
                if(height[right] > rightMax) rightMax = height[right];
                else {
                    trappedWater += rightMax - height[right];
                }
                right --;
            } else {
                if(height[left] > leftMax) leftMax = height[left];
                else {
                    trappedWater += leftMax - height[left];
                }
                left ++;
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Trapped water: "+ sol.getTrappedRainWater(new int[] {0,1,0,2,1,0,1,3,2,1,2,1} ));
    }
}
