package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {

    public static void main(String[] args) {
        System.out.println("Ans:: "+ new ladderSolution().findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}

class ladderSolution {
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        // Store all available words we can traverse
        Set<String> dict = new HashSet<String>(wordList);
        dict.add(start);
        // Neighbors for every node
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();
        // Distance of every String from Begin word
        HashMap<String, Integer> distance = new HashMap<String, Integer>();

        // List res :
        List<List<String>> res = new ArrayList<List<String>>();
        if(!dict.contains(end)) return res;
        // Single Solution:
        ArrayList<String> solution = new ArrayList<String>();

        // BFS
        BFS(start, end, dict, nodeNeighbors, distance);

        // DFS
        DFS(start, end, dict, nodeNeighbors, distance, solution, res);
        return res;

    }

    private void BFS(String start, String end, Set<String> dict,
                     HashMap<String, ArrayList<String>> nodeNeighbors,
                     HashMap<String, Integer> distance) {
        // Queue for a BFS
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);

        for(String str: dict) nodeNeighbors.put(str, new ArrayList<String>());
        while(!q.isEmpty()) {
            int size = q.size();
            boolean isEndWordFound=false;

            for(int i=0; i<size; i++) {
                String currStr = q.poll();
                int curDistance = distance.get(currStr);

                List<String> neighbours = getNeighbors(currStr, dict);

                for(String nWord: neighbours) {
                    nodeNeighbors.get(currStr).add(nWord);
                    if(!distance.containsKey(nWord)) { // check if already visited
                        distance.put(nWord, curDistance + 1);
                        if(nWord.equals(end)) {
                            isEndWordFound = true;
                        } else {
                            q.offer(nWord);
                        }
                    }
                }
                if(isEndWordFound) break;
            }
        }

    }

    private void DFS(String curr, String end, Set<String> dict,
                     HashMap<String, ArrayList<String>> nodeNeighbors,
                     HashMap<String, Integer> distance,
                     ArrayList<String> solution, List<List<String>> res
    ) {
        solution.add(curr);
        if(curr.equals(end)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for(String next: nodeNeighbors.get(curr)) {
                if(distance.get(next) == distance.get(curr)+1 && !(distance.get(next)>distance.get(end))) {
                    DFS(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }

    private List<String> getNeighbors(String start, Set dict) {

        ArrayList<String> res = new ArrayList<String>();
        char chs[] = start.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

}
