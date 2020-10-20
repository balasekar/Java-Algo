package reverselinkedlist;

public class SolutionIterative {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        SolutionIterative solIterative = new SolutionIterative();
        System.out.println("Acutal Linked list");
        solIterative.printNodes(node1);
        System.out.println("Modified Linked List");
        Node nodeAltered = solIterative.reverseLinkedList(node1);
        solIterative.printNodes(nodeAltered);
    }

    private Node reverseLinkedList(Node head) {
        if(head == null) return null;

        Node prev = null;
        Node current = head;
        Node next;

        while(current != null){
            next = current.next;
            //Remap the current.next to point to the prev node
            current.next = prev;
            //Goto the next node
            prev = current;
            current = next;
        }

        return prev;
    }

    private void printNodes(Node head) {

        Node current = head;

        while(current != null) {
            System.out.println("Node::"+current.data);
            current = current.next;
        }
    }
}
