package amazon;

public class Problem3 {
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        System.out.println("Ans:: "+ sol.solution(2, new int[][]{{0,0,0,0}, {0,0,1,0}, {1,0,0,1}}));
        System.out.println("Ans:: "+ sol.solution(4, new int[][]{{0,0,0,1}, {0,1,0,0}, {0,0,1,0}, {1,0,0,0}, {0,0,0,0}}));
    }
}

class Solution3 {
    int[][] distanceMatrix;
    public int solution(int K, int[][] A) {
        int noOfPlotsAvailable = 0;
        int numberOfHouses = 0;
        this.distanceMatrix = new int[A.length][A[0].length];
        for (int i=0; i<A.length; i++) {
            for(int j=0; j<A[i].length; j++) {
                System.out.print(A[i][j]);
                if(A[i][j] == 1) {
                    boolean[][] visitedMatrix = new boolean[A.length][A[0].length];
                    markReachablePlots(A, K, i, j, visitedMatrix);
                    numberOfHouses++;
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i=0; i<A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(this.distanceMatrix[i][j]);
                if(this.distanceMatrix[i][j] == numberOfHouses) {
                    noOfPlotsAvailable++;
                }
            }
            System.out.println();
        }

        return noOfPlotsAvailable;
    }

    public void markReachablePlots(int[][] A, int dist, int row, int col, boolean[][] visited) {
        if(row < 0 || row >= A.length || col < 0 || col >= A[row].length || visited[row][col]) return;
        visited[row][col] = true;
        if(dist == 0) return;
        if(row+1 < A.length && !visited[row + 1][col] ) {
            this.distanceMatrix[row + 1][col]++;
            markReachablePlots(A, dist-1, row+1, col, visited);
        }
        if(row-1 >= 0 && !visited[row - 1][col]) {
            this.distanceMatrix[row - 1][col]++;
            markReachablePlots(A, dist-1, row-1, col, visited);
        }
        if(col+1 < A[row].length && !visited[row][col + 1]) {
            this.distanceMatrix[row][col + 1]++;
            markReachablePlots(A, dist-1, row, col+1, visited);
        }
        if(col-1 >= 0 && !visited[row][col - 1]) {
            this.distanceMatrix[row][col - 1]++;
            markReachablePlots(A, dist-1, row, col-1, visited);
        }
    }
}
