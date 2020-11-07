package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int [] array1 = new int []{2,7,4,1,5,3};
        System.out.println("Before sort: " + Arrays.toString(array1) );
        insertionSort.insertionSortMethod(array1, 6);
        System.out.println("After sort: " + Arrays.toString(array1) );
    }

    private void insertionSortMethod(int[] A, int n){
        for(int i =1; i<n; i++) {
            int value = A[i];
            int hole = i;
            while(hole >0 && A[hole-1] > value){
                A[hole] = A[hole-1];
                hole = hole - 1;
            }
            A[hole] = value;
            System.out.println("After sort loop: "+ i + " : " + Arrays.toString(A) );
        }
    }
}
