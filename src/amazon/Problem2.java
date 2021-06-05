package amazon;

public class Problem2 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println("Ans:: "+ sol.solution(2, new int[][]{{0,0,0,0}, {0,0,1,0}, {1,0,0,1}}));
        System.out.println("Ans:: "+ sol.solution(4, new int[][]{{0,0,0,1}, {0,1,0,0}, {0,0,1,0}, {1,0,0,0}, {0,0,0,0}}));
    }
}

class Solution2 {
    int[][] distanceMatrix;
    public int solution(int K, int[][] A) {
        int noOfPlotsAvailable = 0;
        int numberOfHouses = 0;
        this.distanceMatrix = new int[A.length][A[0].length];
        for (int i=0; i<A.length; i++) {
            for(int j=0; j<A[i].length; j++) {
                if(A[i][j] == 1) {
                    boolean[][] visitedMatrix = new boolean[A.length][A[0].length];
                    markReachablePlots(A, K, i, j, visitedMatrix);
                    numberOfHouses++;
                }
            }
        }
        for (int i=0; i<A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if(this.distanceMatrix[i][j] == numberOfHouses) {
                    noOfPlotsAvailable++;
                }
            }
        }

        return noOfPlotsAvailable;
    }

    public void markReachablePlots(int[][] A, int dist, int row, int col, boolean[][] vistited) {
        if(row < 0 || row >= A.length || col < 0 || col >= A[row].length || vistited[row][col]) return;
        vistited[row][col] = true;
        if(dist == 0) return;
        if(row+1 < A.length && A[row+1][col] != 1 && !vistited[row + 1][col] ) {
            this.distanceMatrix[row + 1][col]++;
            markReachablePlots(A, dist-1, row+1, col, vistited);
        }
        if(row-1 >= 0 && A[row-1][col] != 1 && !vistited[row - 1][col]) {
            this.distanceMatrix[row - 1][col]++;
            markReachablePlots(A, dist-1, row-1, col, vistited);
        }
        if(col+1 < A[row].length && A[row][col+1] != 1 && !vistited[row][col + 1]) {
            this.distanceMatrix[row][col + 1]++;
            markReachablePlots(A, dist-1, row, col+1, vistited);
        }
        if(col-1 >= 0 && A[row][col-1] != 1 && !vistited[row][col - 1]) {
            this.distanceMatrix[row][col - 1]++;
            markReachablePlots(A, dist-1, row, col-1, vistited);
        }
    }
}
