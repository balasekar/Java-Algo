package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        System.out.println("Ans:: "+ sol.solution(2, new int[][]{{0,0,0,0}, {0,0,1,0}, {1,0,0,1}}));
        System.out.println("Ans:: "+ sol.solution(4, new int[][]{{0,0,0,1}, {0,1,0,0}, {0,0,1,0}, {1,0,0,0}, {0,0,0,0}}));
    }
}

class Solution3 {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solution(int K, int[][] A) {
        if (A == null || A.length == 0) return 0;
        int m = A.length;
        int n = A[0].length;
        int result = 0;
        int numberOfHouses = 0;
        System.out.println("K:" + K + " Given Matrix:");
        for (int[] ints : A) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j]);
                if (ints[j] == 1) numberOfHouses++;
            }
            System.out.println();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) {
                    int housesReachable = getNumberOfHousesReachable(A, K, m, n, i, j);
                    System.out.println("housesReachable : "+housesReachable);
                    if(housesReachable == numberOfHouses) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public int getNumberOfHousesReachable(int[][] A, int K, int m, int n, int R, int C) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {R,C,K});
        int numberOfHousesReachable=0;
        boolean[][] seen = new boolean[m][n];
        seen[R][C] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            System.out.println("cur:"+r+","+c);
            for(int i =0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int movesLeft = cur[2];
                if(nr < 0 || nr >= m || nc < 0 || nc >= n || movesLeft<= 0 || seen[nr][nc]) continue;

                seen[nr][nc] = true;
                if(A[nr][nc] == 1) {
                    numberOfHousesReachable++;
                } else {
                    queue.offer(new int[] {nr, nc, movesLeft-1});
                }
            }
        }
        return numberOfHousesReachable;
    }
}
