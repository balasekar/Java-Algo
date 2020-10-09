package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private boolean visited;
    private List<Node> adjacentList;

    public Node(String name) {
        this.name = name;
        this.adjacentList = new ArrayList<Node>();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void addAdjacent(Node node) {
        this.adjacentList.add(node);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Node> getAdjacentList() {
        return adjacentList;
    }
}
