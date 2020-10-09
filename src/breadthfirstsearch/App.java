package breadthfirstsearch;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        Node n6 = new Node("6");

        n1.addAdjacent(n2);
        n1.addAdjacent(n3);
        n2.addAdjacent(n4);
        n4.addAdjacent(n5);

        List<Node> list = new ArrayList<Node>();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);

        BFS dfs = new BFS();
        System.out.println("BFS has Path n1 to n5?:"+ dfs.hasPathBFS(n1, n5));
        System.out.println("BFS Queue has Path n1 to n5?:"+ dfs.hasPathBFSQueue(n1, n5));
        System.out.println("BFS has Path n1 to n6?:"+ dfs.hasPathBFS(n1, n6));
    }
}
