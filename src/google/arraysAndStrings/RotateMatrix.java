package google.arraysAndStrings;

import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("a:"+ Arrays.deepToString(a));
        rotate1(a);
        System.out.println("rotated a:"+ Arrays.deepToString(a));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //Transpose
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //Horizontal flip
        for(int i=0; i<n; i++) {
            for(int j = 0; j<n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

    public static void rotate1(int[][] a) {
        int n = a.length;
        for(int i=0; i<n/2; i++){
            for(int j=i; j<n-1-i; j++) {
                //90 degree rotate
                int temp = a[i][j];
                a[i][j] = a[n-1-j][i];
                a[n-1-j][i] = a[n-1-i][n-1-j];
                a[n-1-i][n-1-j] = a[j][n-1-i];
                a[j][n-1-i] = temp;
            }
        }
    }
}
