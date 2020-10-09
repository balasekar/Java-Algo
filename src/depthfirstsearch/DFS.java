package depthfirstsearch;

import java.util.Stack;

public class DFS {

    Stack<Node> nodeStack;

    public DFS() {
        nodeStack = new Stack<>();
    }

    public boolean hasPathDFSStack(Node source, Node destination){
        nodeStack.push(source);
        while(!nodeStack.isEmpty()){
            Node currentNode = nodeStack.pop();
            if(!currentNode.isVisited()){
                currentNode.setVisited(true);
                System.out.println("Stack DFS: "+currentNode);
                if(currentNode == destination) return true;
                for(Node child : currentNode.getAdjacentList()) {
                    if(!child.isVisited()) {
                        nodeStack.push(child);
                    }
                }
            }
        }
        return false;
    }

    public boolean hasPathDFS(Node source, Node destination) {
        System.out.println("currentNode: "+source);
        if(source.isVisited()){
            return false;
        }
        source.setVisited(true);
        if(source == destination) return true;
        for(Node child : source.getAdjacentList()) {
            if(hasPathDFS(child, destination)){
                return true;
            }
        }
        return false;
    }
}
