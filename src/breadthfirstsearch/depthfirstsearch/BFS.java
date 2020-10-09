package breadthfirstsearch.depthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    Queue<Node> nodeQueue;

    public BFS() {
        nodeQueue = new LinkedList<>();
    }

    public boolean hasPathBFSQueue(Node source, Node destination){
        nodeQueue.add(source);
        while(!nodeQueue.isEmpty()){
            Node currentNode = nodeQueue.poll();
            if(!currentNode.isVisited()){
                currentNode.setVisited(true);
                System.out.println("Queue DBS: "+currentNode);
                if(currentNode == destination) return true;
                for(Node child : currentNode.getAdjacentList()) {
                    if(!child.isVisited()) {
                        nodeQueue.add(child);
                    }
                }
            }
        }
        return false;
    }

    public boolean hasPathBFS(Node source, Node destination) {
        Queue <Node> q = new LinkedList<>();
        q.add(source);
        return hasPathBFSRecursive(q, destination);
    }

    public boolean hasPathBFSRecursive(Queue<Node> q, Node destination) {
        if(q.isEmpty()) return false;
        Node currentNode = q.poll();
        System.out.println("Queue DBS: "+currentNode);
        if(currentNode == destination) return true;
        for(Node child : currentNode.getAdjacentList()) {
            if(!child.isVisited()) {
                q.add(child);
            }
        }
        return hasPathBFSRecursive(q, destination);
    }
}
