package sorting;

import java.util.Arrays;

public class MergeSort {


    private static int[] mergeSort(int[] array) {
        System.out.println("array at every call " + Arrays.toString(array));
        int n = array.length;
        if(n <= 1) return array;

        int midPoint = n / 2;

        int[] left = new int[midPoint];
        int[] right = new int[n%2 == 0 ? midPoint : midPoint +1];

        System.arraycopy(array, 0, left, 0, midPoint);
        System.arraycopy(array, midPoint, right, 0, right.length);

        left = mergeSort(left);
        right = mergeSort(right);
        int[] result = merge(left, right);
        System.out.println("sort at merge ==>" + Arrays.toString(result));
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int nLeft = left.length;
        int nRight = right.length;
        int[] result = new int[nLeft + nRight];

        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        while(leftPointer < nLeft || rightPointer < nRight) {
            if(leftPointer < nLeft && rightPointer < nRight) {
                if(left[leftPointer] < right[rightPointer]){
                    result[resultPointer++] = left[leftPointer++];
                } else  {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < nLeft) {
                result[resultPointer++] = left[leftPointer++];
            } else {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] array1 = new int []{2,7,4,1,5,3};
        System.out.println("Before sort: " + Arrays.toString(array1) );
        System.out.println("After sort: " + Arrays.toString(MergeSort.mergeSort(array1)) );
    }

}
