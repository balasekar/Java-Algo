package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int [] array1 = new int []{2,7,4,1,5,3};
        System.out.println("Before sort: " + Arrays.toString(array1) );
        QuickSort.quickSort(array1, 0, array1.length-1);
        System.out.println("After sort: " + Arrays.toString(array1));
    }

    private static void quickSort(int[] array, int start, int end) {
        //End conditon
        if(start>=end) return;

        //Partition the array such that elements left to pivot is less and right is greater value
        int pIdex = partition(array, start, end);
        System.out.println("After every partition =>" + Arrays.toString(array));
        quickSort(array, start, pIdex-1);
        quickSort(array, pIdex+1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int randomNumber = new Random().ints(1, start, end).findFirst().getAsInt();
        System.out.println("Random: ==>"+ randomNumber);
        int pivot = array[randomNumber];
        int pIndex = start;
        for(int i = start; i<end; i++) {
            if(array[i] < pivot) {
                swap(array, i, pIndex);
                pIndex++;
            }
        }
        swap(array, pIndex, end);
        return pIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
