package depthfirstsearch;

import java.util.Stack;

public class DFS {

    private Stack<Node> stack;

    public DFS() {
        this.stack = new Stack<>();
    }

    public void dfs(Node node) {
        if(!node.isVisited()) {
            node.setVisited(true);
            dfsWithStack(node);
        }
    }

    private void dfsWithStack(Node rootNode) {
        this.stack.add(rootNode);
        rootNode.setVisited(true);

        while(! stack.isEmpty()) {
            Node currentNode = this.stack.pop();
            System.out.println("currentNode: "+ currentNode + " ");
            for(Node node : currentNode.getAdjacentList()) {
                if( !node.isVisited() ) {
                    node.setVisited(true);
                    this.stack.push(node);
                }
            }
        }
    }
}
