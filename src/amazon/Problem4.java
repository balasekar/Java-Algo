package amazon;

public class Problem4 {
    public static void main(String[] args) {
        Solution4 sol = new Solution4();
        System.out.println("Ans:: "+ sol.solution(2, new int[][]{{0,0,0,0}, {0,0,1,0}, {1,0,0,1}}));
        System.out.println("Ans:: "+ sol.solution(4, new int[][]{{0,0,0,1}, {0,1,0,0}, {0,0,1,0}, {1,0,0,0}, {0,0,0,0}}));
    }
}

class Solution4 {
    int[][] distanceMatrix;
    boolean[][] vistited;
    public int solution(int K, int[][] A) {
        int noOfPlotsAvailable = 0;
        int numberOfHouses = 0;
        int m = A.length;
        int n = A[0].length;
        this.distanceMatrix = new int[A.length][A[0].length];
        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(A[i][j]);
                if(A[i][j] == 1) {
                    numberOfHouses++;
                }
            }
            System.out.println();
        }
        for (int i=0; i<m; i++) {
            for (int j = 0; j <n; j++) {
                if(A[i][j] == 1) {
                    vistited = new boolean[m][n];
                    markReachablePlots(A, K, i, j);
                }
            }
        }
        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if(this.distanceMatrix[i][j] == numberOfHouses) {
                System.out.println(i +" "+ j);
                    noOfPlotsAvailable++;
                }
            }
        }

        return noOfPlotsAvailable;
    }

    public void markReachablePlots(int[][] A, int dist, int row, int col) {
        if(row < 0 || row >= A.length || col < 0 || col >= A[row].length || this.vistited[row][col]) return;
        if(dist < 0) return;
        this.vistited[row][col] = true;
        if(row+1 < A.length && !this.vistited[row + 1][col] ) {
            this.distanceMatrix[row + 1][col]++;
            markReachablePlots(A, dist-1, row+1, col);
        }
        if(row-1 >= 0 && !vistited[row - 1][col]) {
            this.distanceMatrix[row - 1][col]++;
            markReachablePlots(A, dist-1, row-1, col);
        }
        if(col+1 < A[row].length && !vistited[row][col + 1]) {
            this.distanceMatrix[row][col + 1]++;
            markReachablePlots(A, dist-1, row, col+1);
        }
        if(col-1 >= 0 && !vistited[row][col - 1]) {
            this.distanceMatrix[row][col - 1]++;
            markReachablePlots(A, dist-1, row, col-1);
        }
    }
}
