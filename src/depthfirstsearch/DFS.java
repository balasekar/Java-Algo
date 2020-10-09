package depthfirstsearch;

import java.util.Stack;

class DFS {

    Stack<Node> nodeStack;

    DFS() {
        nodeStack = new Stack<>();
    }

    boolean hasPathDFSStack(Node source, Node destination){
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

    boolean hasPathDFS(Node source, Node destination) {
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
