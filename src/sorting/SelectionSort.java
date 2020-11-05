package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int [] array1 = new int []{2,7,4,1,5,3};
        System.out.println("Before sort: " + Arrays.toString(array1) );
        selectionSort.selectionSortMethod(array1, 6);
        System.out.println("After sort: " + Arrays.toString(array1) );
    }

    private void selectionSortMethod(int[] A, int n) {
        for(int i=0; i<n-1; i++) {
            int iMin = i;
            for(int j=i+1; j<n; j++) {
                if(A[j] < A[iMin]){
                    iMin = j;
                }
            }
            swap(i, iMin, A);
        }
    }

    private void swap(int i, int j, int[] a) {
        if(i != j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
