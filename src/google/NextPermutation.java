package google;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] input = new int[] {1,2,3};
        System.out.println("Next permutation of input :: "+ Arrays.toString(input));
        np.nextPermutation(input);
        System.out.println("Next permutation of output :: "+Arrays.toString(input));
    }

    public void nextPermutation(int[] nums) {

        int pivot = -1;
        //find first change in descending
        for(int i=nums.length-1; i>0; i--){
            if(nums[i-1]<nums[i]){
                pivot = i-1;
                break;
            }
        }
        // if full array is descending
        if(pivot==-1){
            reverse(nums, 0);
        } else {
            for(int i=nums.length-1; i>pivot; i--) {
                // find first element bigger than element at pivot
                if(nums[i]>nums[pivot]) {
                    //swap
                    swap(nums, i, pivot);

                    //Reverse array from pivot+1 till nums[nums.length-1]
                    reverse(nums, pivot+1);
                    break;
                }
            }
        }

    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length-1;
        while(i<j){
            swap(nums, i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
