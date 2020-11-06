package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int [] array1 = new int []{2,7,4,1,5,3};
        System.out.println("Before sort: " + Arrays.toString(array1) );
        bubbleSort.bubbleSortMethod(array1, 6);
        System.out.println("After sort: " + Arrays.toString(array1) );
    }

    private void bubbleSortMethod(int[] A, int n) {

        for(int i=1; i<n; i++) {
            int flag = 0;
            for(int j=0; j<n-i; j++) {
                if(A[j] > A[j+1]){
                    swap(j, j+1, A);
                    flag=1;
                }
            }
            System.out.println("After sort loop: "+ i + " : " + Arrays.toString(A) );
            if(flag == 0) break;
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
